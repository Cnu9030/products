package com.ecom.products.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentResponseDTO {

    @JsonProperty("PayorName")
    private String payorName;

    @JsonProperty("CardStatus")
    private String cardStatus;

    @JsonProperty("LastBill")
    private Integer lastBill;

    public String getPayorName() {
        return payorName;
    }

    public void setPayorName(String payorName) {
        this.payorName = payorName;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Integer getLastBill() {
        return lastBill;
    }

    public void setLastBill(Integer lastBill) {
        this.lastBill = lastBill;
    }

    @Override
    public String toString() {
        return "PaymentResponseDTO{" +
                "payorName='" + payorName + '\'' +
                ", cardStatus='" + cardStatus + '\'' +
                ", lastBill=" + lastBill +
                '}';
    }
}