package com.ecom.products.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ecom.products.DTO.OrderResponseDTO;
import com.ecom.products.DTO.ProductResponseDTO;
import com.ecom.products.DTO.PaymentResponseDTO;
import com.ecom.products.DTO.ordersDTO;
import com.ecom.products.Entity.payment;
import com.ecom.products.Entity.product;
import com.ecom.products.Entity.shipping;
import com.ecom.products.Repository.paymentRepository;
import com.ecom.products.Repository.productRepository;
import com.ecom.products.Repository.shippingRepository;
import com.ecom.products.Utility.OrderExistsException;
import com.ecom.products.Utility.externalCalls;

@Service
public class productServiceImpl implements productService {

    private final externalCalls extCalls;
    private final productRepository prodRepo;
    private final shippingRepository shipRepo;
    private final paymentRepository paymentRepo;

    public productServiceImpl(externalCalls extCalls,productRepository prodRepo,shippingRepository shipRepo,paymentRepository paymentRepo) {
        this.extCalls = extCalls;
        this.prodRepo = prodRepo;
        this.shipRepo = shipRepo;
        this.paymentRepo = paymentRepo;
    }

    @Value("${order.exists}")
    private String orderExistsMessage;

    @Override
    public String createOrder(ordersDTO orderDto) {

        Long cardNum = orderDto.getPayment().getCardNumber();

        // 🔹 1. Start payment async (ONLY ONCE)
        CompletableFuture<PaymentResponseDTO> paymentFuture =
                extCalls.getPaymentAsync(cardNum);

        // 🔹 2. Start all product calls in parallel
        List<CompletableFuture<ProductResponseDTO>> productFutures =
                orderDto.getProducts().stream()
                        .map(item -> extCalls.getProductAsync(item.getProductId()))
                        .toList();

        // 🔹 3. Combine ALL futures
        List<CompletableFuture<?>> allFutures = new ArrayList<>();
        allFutures.add(paymentFuture);
        allFutures.addAll(productFutures);

        CompletableFuture<Void> combined =
                CompletableFuture.allOf(allFutures.toArray(new CompletableFuture[0]));

        try {
            // 🔹 4. Apply GLOBAL timeout (60 sec)
            combined.orTimeout(60, TimeUnit.SECONDS).join();

            // 🔹 5. Collect results
            PaymentResponseDTO payment = paymentFuture.join();

            List<ProductResponseDTO> products = productFutures.stream()
                            .map(CompletableFuture::join)
                            .toList();

            OrderResponseDTO response = new OrderResponseDTO(payment, products);

            System.out.println("✅ FINAL Product RESPONSE: " + response.getProducts());
            System.out.println("✅ FINAL Payment RESPONSE: " + response.getPayment());

            storeProductDetails(orderDto,products);
            storeShippingDetails(orderDto);

            if("Active".equalsIgnoreCase(response.getPayment().getCardStatus())){
                storePaymentDetails(orderDto);
            }

        } catch (Exception e) {
            throw new RuntimeException("Order failed (timeout or API error)", e);
        }        

        return "Order Processed Successfully";
    }

    public void storeProductDetails(ordersDTO orderDto,List<ProductResponseDTO> products){

        List<product> productEntities = new ArrayList<>();
        
        for(ProductResponseDTO p : products) {

            product prod = new product();
            prod.setProductId(p.getProductId());    
            prod.setProductName(p.getProductName());  
            prod.setProductPrice(p.getProductPrice()); 
            prod.setQuantity(p.getQuantity());      
            prod.setOrderId(orderDto.getOrderId()); 
            
            productEntities.add(prod);
        }

        prodRepo.saveAll(productEntities);
    }

    public void storeShippingDetails(ordersDTO ordersDTO){
        Optional<shipping> orderExists = shipRepo.findById(ordersDTO.getOrderId());

        if(orderExists.isPresent()) throw new OrderExistsException(orderExistsMessage);

        shipping ship = new shipping();

        ship.setAddressId("SH" +(ordersDTO.getCustomerId()).substring(0,3) + (ordersDTO.getOrderId()).substring((ordersDTO.getOrderId()).length() - 3));
        ship.setCity(ordersDTO.getShip().getCity());
        ship.setCountry(ordersDTO.getShip().getCountry());
        ship.setState(ordersDTO.getShip().getState());
        ship.setStreet(ordersDTO.getShip().getStreet());
        ship.setZipCode(ordersDTO.getShip().getZipCode());
        ship.setOrderId(ordersDTO.getOrderId());

        shipRepo.save(ship);
    }

    public void storePaymentDetails(ordersDTO ordersDTO){
        Optional<payment> orderExists = paymentRepo.findById(ordersDTO.getOrderId());

        if(orderExists.isPresent()) throw new OrderExistsException(orderExistsMessage);

        payment pay = new payment();
        pay.setPaymentId("PY" +(ordersDTO.getCustomerId()).substring(0,3) + (ordersDTO.getOrderId()).substring((ordersDTO.getOrderId()).length() - 3));
        pay.setCardNumber(ordersDTO.getPayment().getCardNumber());
        pay.setCardType(ordersDTO.getPayment().getCardType());
        pay.setExpiryDate(ordersDTO.getPayment().getExpiryDate());
        pay.setCvv(ordersDTO.getPayment().getCvv());

        

        paymentRepo.save(pay);
    }
}