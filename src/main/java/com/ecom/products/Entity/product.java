package com.ecom.products.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class product {

    @Id
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        result = prime * result + ((productName == null) ? 0 : productName.hashCode());
        result = prime * result + Float.floatToIntBits(productPrice);
        result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
        product other = (product) obj;
        if (productId == null) {
            if (other.productId != null)
                return false;
        } else if (!productId.equals(other.productId))
            return false;
        if (orderId == null) {
            if (other.orderId != null)
                return false;
        } else if (!orderId.equals(other.orderId))
            return false;
        if (productName == null) {
            if (other.productName != null)
                return false;
        } else if (!productName.equals(other.productName))
            return false;
        if (Float.floatToIntBits(productPrice) != Float.floatToIntBits(other.productPrice))
            return false;
        if (quantity == null) {
            if (other.quantity != null)
                return false;
        } else if (!quantity.equals(other.quantity))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "product [productId=" + productId + ", orderId=" + orderId + ", productName=" + productName
                + ", productPrice=" + productPrice + ", quantity=" + quantity + "]";
    }

    
    
    
}
