package com.ecom.products.DTO;


public class paymentDTO {

    private String paymentId;
    private String orderId;
    private Long cardNumber;
    private String cardType;
    private String expiryDate;
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
   
    public Integer getCvv() {
        return cvv;
    }
    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }
    
    public String getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
   

    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
    @Override
    public String toString() {
        return "paymentDTO [paymentId=" + paymentId + ", orderId=" + orderId + ", cardNumber=" + cardNumber
                + ", cardType=" + cardType + ", expiryDate=" + expiryDate + ", cvv=" + cvv + "]";
    }
    
    

    
}
