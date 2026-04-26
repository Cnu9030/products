package com.ecom.products.Entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class orders {
    @Id
    @NotNull(message = "{order.id.required}")
    private Integer orderId;
    @NotNull(message = "{customer.id.required}")
    private Integer customerId;
    private LocalDate date;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="paymentId")
    @NotNull(message = "{payment.required}")
    private payment payment;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="productId")
    @NotEmpty(message = "{products.required}")
    private List<product> products;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="addressId")
    @NotBlank(message = "{shipping.required}")
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

    public List<product> getProducts() {
        return products;
    }

    public void setProducts(List<product> products) {
        this.products = products;
    }

    public shipping getShip() {
        return ship;
    }

    public void setShip(shipping ship) {
        this.ship = ship;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((payment == null) ? 0 : payment.hashCode());
        result = prime * result + ((products == null) ? 0 : products.hashCode());
        result = prime * result + ((ship == null) ? 0 : ship.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        orders other = (orders) obj;
        if (orderId == null) {
            if (other.orderId != null)
                return false;
        } else if (!orderId.equals(other.orderId))
            return false;
        if (customerId == null) {
            if (other.customerId != null)
                return false;
        } else if (!customerId.equals(other.customerId))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (payment == null) {
            if (other.payment != null)
                return false;
        } else if (!payment.equals(other.payment))
            return false;
        if (products == null) {
            if (other.products != null)
                return false;
        } else if (!products.equals(other.products))
            return false;
        if (ship == null) {
            if (other.ship != null)
                return false;
        } else if (!ship.equals(other.ship))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "orders [orderId=" + orderId + ", customerId=" + customerId + ", date=" + date + ", payment=" + payment
                + ", products=" + products + ", ship=" + ship + "]";
    }
    
    

    
}