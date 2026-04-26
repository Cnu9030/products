package com.ecom.products.DTO;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ordersDTO {
    private Integer orderId;
    private Integer customerId;
    private LocalDate orderDate;

    @JsonProperty("paymentMethod")
    private paymentDTO payment;

    @JsonProperty("items")
    private List<productDTO> products;

    @JsonProperty("shippingAddress")
    private shippingDTO ship;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public paymentDTO getPayment() {
        return payment;
    }

    public void setPayment(paymentDTO payment) {
        this.payment = payment;
    }

   

    public shippingDTO getShip() {
        return ship;
    }

    public void setShip(shippingDTO ship) {
        this.ship = ship;
    }

    public List<productDTO> getProducts() {
        return products;
    }

    public void setProducts(List<productDTO> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ordersDTO [orderId=" + orderId + ", customerId=" + customerId + ", orderDate=" + orderDate
                + ", payment=" + payment + ", products=" + products + ", ship=" + ship + "]";
    }


    
}