package com.ecom.products.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponseDTO {

    private String productName;
    private Integer productPrice;
    private Integer quantity;
    private String productId;

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public Integer getProductPrice() { return productPrice; }
    public void setProductPrice(Integer productPrice) { this.productPrice = productPrice; }

    public Integer getQuantity() { return quantity; }
    public void setQunatity(Integer quantity) { this.quantity = quantity; }

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    @Override
    public String toString() {
        return "ProductResponseDTO{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", quantity=" + quantity +
                ", productId='" + productId + '\'' +
                '}';
    }
}
