package com.ecom.products.DTO;

import java.time.LocalDate;

public class paymentDTO {

    private Integer paymentId;
    private Integer orderId;
    private Long cardNumber;
    private String cardType;
    private String expiryDate;
    private Integer cvv;
    
    public Integer getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }
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
   
    public Integer getCvv() {
        return cvv;
    }
    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }
    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    
    public String getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    @Override
    public String toString() {
        return "paymentDTO [paymentId=" + paymentId + ", orderId=" + orderId + ", cardNumber=" + cardNumber
                + ", cardType=" + cardType + ", expiryDate=" + expiryDate + ", cvv=" + cvv + "]";
    }

    
}
