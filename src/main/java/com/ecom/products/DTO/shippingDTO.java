package com.ecom.products.DTO;

public class shippingDTO {

    private String addressId;
    private Integer orderId;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    
    public String getAddressId() {
        return addressId;
    }
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    
    @Override
    public String toString() {
        return "shippingDTO [addressId=" + addressId + ", orderId=" + orderId + ", street=" + street + ", city=" + city
                + ", state=" + state + ", zipCode=" + zipCode + ", country=" + country + "]";
    }

    
}
