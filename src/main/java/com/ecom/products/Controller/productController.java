package com.ecom.products.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.products.DTO.ordersDTO;
import com.ecom.products.service.productService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class productController {

    private productService prodService;

    public productController(productService prodService){
        this.prodService = prodService;
    }

    @PostMapping("/addProducts")
    private ResponseEntity<String> createOrder(@Valid @RequestBody ordersDTO order){
        String message = prodService.createOrder(order);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
}
