package com.ecom.products.DTO;

import java.util.List;


public class CombinedResponseDTO {

    private List<ProductResponseDTO> product;
    private PaymentResponseDTO payment;

    public CombinedResponseDTO(List<ProductResponseDTO> product, PaymentResponseDTO payment) {
        this.product = product;
        this.payment = payment;
    }

    public List<ProductResponseDTO> getProduct() {
        return product;
    }

    public PaymentResponseDTO getPayment() {
        return payment;
    }
}
