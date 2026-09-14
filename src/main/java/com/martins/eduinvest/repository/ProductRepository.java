package com.martins.eduinvest.repository;

import com.martins.eduinvest.model.Customer;
import com.martins.eduinvest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCustomer(Customer customer);
}
