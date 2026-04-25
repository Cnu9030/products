package com.ecom.products.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.products.service.productService;

@RestController
@RequestMapping("/products")
public class productController {

    private productService prodService;

    public productController(productService prodService){
        this.prodService = prodService;
    }
}
