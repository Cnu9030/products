package com.ecom.products.DTO;

public class productDTO {

    private String productId;
    private Integer orderId;
    private Integer productName;
    private float productPrice;
    private Integer quantity;
    
   
    public Integer getProductName() {
        return productName;
    }
    public void setProductName(Integer productName) {
        this.productName = productName;
    }
    public float getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
   
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    @Override
    public String toString() {
        return "productDTO [productId=" + productId + ", orderId=" + orderId + ", productName=" + productName
                + ", productPrice=" + productPrice + ", quantity=" + quantity + "]";
    }

    
}
