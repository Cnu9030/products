package com.ecom.products.DTO;

import java.util.List;

public class OrderResponseDTO {

    private PaymentResponseDTO payment;
    private List<ProductResponseDTO> products;

    public OrderResponseDTO(PaymentResponseDTO payment, List<ProductResponseDTO> products) {
        this.payment = payment;
        this.products = products;
    }

    public PaymentResponseDTO getPayment() {
        return payment;
    }

    public List<ProductResponseDTO> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "OrderResponseDTO{" +
                "payment=" + payment +
                ", products=" + products +
                '}';
    }
}