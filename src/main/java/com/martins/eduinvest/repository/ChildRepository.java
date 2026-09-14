package com.martins.eduinvest.repository;

import com.martins.eduinvest.model.Child;
import com.martins.eduinvest.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildRepository extends JpaRepository<Child, Long> {
    List<Child> findByCustomer(Customer customer);
}
