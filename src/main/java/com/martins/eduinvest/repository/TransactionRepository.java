package com.martins.eduinvest.repository;

import com.martins.eduinvest.model.Customer;
import com.martins.eduinvest.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByCustomer(Customer customer);
}
