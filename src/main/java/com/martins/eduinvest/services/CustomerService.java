package com.martins.eduinvest.services;

import com.martins.eduinvest.dto.requestdto.ChildDetailsDTO;
import com.martins.eduinvest.dto.requestdto.PurchaseProductRequestDto;
import com.martins.eduinvest.model.Child;
import com.martins.eduinvest.model.Customer;
import com.martins.eduinvest.model.Product;
import com.martins.eduinvest.model.Transaction;

import java.util.List;

public interface CustomerService {
    Customer getProfile(Long customerId);
    Child addChild(Long customerId, ChildDetailsDTO request);
    List<Child> listChildren(Long customerId);
    Product purchaseProduct(Long customerId, PurchaseProductRequestDto request);
    List<Product> listProducts(Long customerId);
    List<Transaction> listTransactions(Long customerId);
}
