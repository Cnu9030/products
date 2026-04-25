package com.ecom.products.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.products.Entity.payment;

public interface paymentRepository extends JpaRepository<payment, Integer>{

}
