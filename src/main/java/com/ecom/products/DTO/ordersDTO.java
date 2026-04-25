package com.ecom.products.DTO;

import java.time.LocalDate;

import com.ecom.products.Entity.payment;
import com.ecom.products.Entity.product;
import com.ecom.products.Entity.shipping;


public class ordersDTO {
    private Integer orderId;
    private Integer customerId;
    private LocalDate date;

    private payment payment;

    private product products;

    private shipping ship;

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public payment getPayment() {
        return payment;
    }

    public void setPayment(payment payment) {
        this.payment = payment;
    }

    public product getProducts() {
        return products;
    }

    public void setProducts(product products) {
        this.products = products;
    }

    public shipping getShip() {
        return ship;
    }

    public void setShip(shipping ship) {
        this.ship = ship;
    }

    @Override
    public String toString() {
        return "ordersDTO [orderId=" + orderId + ", customerId=" + customerId + ", date=" + date + ", payment="
                + payment + ", products=" + products + ", ship=" + ship + "]";
    }

    
}
