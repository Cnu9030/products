package com.ecom.products.DTO;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ordersDTO {
    private String orderId;
    private String customerId;
    private LocalDate orderDate;

    @JsonProperty("paymentMethod")
    private paymentDTO payment;

    @JsonProperty("items")
    private List<productDTO> products;

    @JsonProperty("shippingAddress")
    private shippingDTO ship;

    

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ordersDTO{");
        sb.append("orderId=").append(orderId);
        sb.append(", customerId=").append(customerId);
        sb.append(", orderDate=").append(orderDate);
        sb.append(", payment=").append(payment);
        sb.append(", products=").append(products);
        sb.append(", ship=").append(ship);
        sb.append('}');
        return sb.toString();
    }

    
}