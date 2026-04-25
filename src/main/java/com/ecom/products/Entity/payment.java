package com.ecom.products.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class payment {
    @Id
    private Integer paymentId;
    private Integer orderId;
    private Long cardNumber;
    private String cardType;
    private LocalDate expiryDate;
    private Integer cvv;
    
    public Long getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getCardType() {
        return cardType;
    }
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
    public Integer getCvv() {
        return cvv;
    }
    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }
    
    public Integer getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }
    
    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((paymentId == null) ? 0 : paymentId.hashCode());
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
        result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
        result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
        result = prime * result + ((cvv == null) ? 0 : cvv.hashCode());
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
        payment other = (payment) obj;
        if (paymentId == null) {
            if (other.paymentId != null)
                return false;
        } else if (!paymentId.equals(other.paymentId))
            return false;
        if (orderId == null) {
            if (other.orderId != null)
                return false;
        } else if (!orderId.equals(other.orderId))
            return false;
        if (cardNumber == null) {
            if (other.cardNumber != null)
                return false;
        } else if (!cardNumber.equals(other.cardNumber))
            return false;
        if (cardType == null) {
            if (other.cardType != null)
                return false;
        } else if (!cardType.equals(other.cardType))
            return false;
        if (expiryDate == null) {
            if (other.expiryDate != null)
                return false;
        } else if (!expiryDate.equals(other.expiryDate))
            return false;
        if (cvv == null) {
            if (other.cvv != null)
                return false;
        } else if (!cvv.equals(other.cvv))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "payment [paymentId=" + paymentId + ", orderId=" + orderId + ", cardNumber=" + cardNumber + ", cardType="
                + cardType + ", expiryDate=" + expiryDate + ", cvv=" + cvv + "]";
    }

    
    
}
