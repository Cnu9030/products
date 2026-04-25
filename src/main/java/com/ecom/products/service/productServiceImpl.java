package com.ecom.products.service;

import org.springframework.stereotype.Service;

import com.ecom.products.Repository.paymentRepository;
import com.ecom.products.Repository.productRepository;
import com.ecom.products.Repository.shippingRepository;

@Service
public class productServiceImpl implements productService{

    private final paymentRepository paymentRepo;
    private final productRepository productRepo;
    private final shippingRepository shippingRepo;

    public productServiceImpl(paymentRepository paymentRepo,productRepository productRepo,shippingRepository shippingRepo){
        this.paymentRepo = paymentRepo;
        this.productRepo = productRepo;
        this.shippingRepo = shippingRepo;
    }

    
}
