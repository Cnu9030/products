package com.ecom.products.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.products.Entity.product;

public interface productRepository extends JpaRepository<product, String> {

}
