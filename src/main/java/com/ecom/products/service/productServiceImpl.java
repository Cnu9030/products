package com.ecom.products.service;

import org.springframework.stereotype.Service;

import com.ecom.products.DTO.ordersDTO;
import com.ecom.products.Repository.paymentRepository;
import com.ecom.products.Repository.productRepository;
import com.ecom.products.Repository.shippingRepository;
import com.ecom.products.Utility.externalCalls;

@Service
public class productServiceImpl implements productService{

    private final paymentRepository paymentRepo;
    private final productRepository productRepo;
    private final shippingRepository shippingRepo;
    private final externalCalls extCalls;

    public productServiceImpl(paymentRepository paymentRepo,productRepository productRepo,shippingRepository shippingRepo,externalCalls extCalls){
        this.paymentRepo = paymentRepo;
        this.productRepo = productRepo;
        this.shippingRepo = shippingRepo;
        this.extCalls = extCalls;
    }
    
    @Override
    public String createOrder(ordersDTO orderDto) {
        // 1. Get card number from the PaymentDTO
        Long cardNum = orderDto.getPayment().getCardNumber();

        // 2. Loop through the list of ProductDTOs
        orderDto.getProducts().forEach(itemDto -> {
            try {
                // Call external validation using DTO data
                extCalls.validateAndFetch(itemDto.getProductId(), cardNum).join();
                
                System.out.println("Validated Product: " + itemDto.getProductId());
            } catch (Exception e) {
                throw new RuntimeException("Validation failed for: " + itemDto.getProductId());
            }
        });

        return "Order Processed Successfully";
    }
}
