package com.ecom.products.Utility;

public class OrderExistsException extends RuntimeException {

    public OrderExistsException(String message){
        super(message);
    }
}
