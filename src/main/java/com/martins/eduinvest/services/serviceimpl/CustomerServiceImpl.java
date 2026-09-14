package com.martins.eduinvest.services.serviceimpl;

import com.martins.eduinvest.dto.requestdto.ChildDetailsDTO;
import com.martins.eduinvest.dto.requestdto.PurchaseProductRequestDto;
import com.martins.eduinvest.exceptions.ResourceNotFoundException;
import com.martins.eduinvest.model.Child;
import com.martins.eduinvest.model.Customer;
import com.martins.eduinvest.model.Product;
import com.martins.eduinvest.model.Transaction;
import com.martins.eduinvest.repository.ChildRepository;
import com.martins.eduinvest.repository.CustomerRepository;
import com.martins.eduinvest.repository.ProductRepository;
import com.martins.eduinvest.repository.TransactionRepository;
import com.martins.eduinvest.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ChildRepository childRepository;
    private final ProductRepository productRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public Customer getProfile(Long customerId) {
        return findCustomer(customerId);
    }

    @Override
    public Child addChild(Long customerId, ChildDetailsDTO request) {
        Customer customer = findCustomer(customerId);

        Child child = new Child();
        child.setFirstName(request.firstName());
        child.setLastName(request.lastName());
        child.setGender(request.gender());
        child.setDob(Date.from(request.dob().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        child.setSchoolName(request.schoolName());
        child.setSchoolType(request.schoolType());
        child.setSchoolAddress(request.schoolAddress());
        child.setCustomer(customer);

        return childRepository.save(child);
    }

    @Override
    public List<Child> listChildren(Long customerId) {
        Customer customer = findCustomer(customerId);
        return childRepository.findByCustomer(customer);
    }

    @Override
    public Product purchaseProduct(Long customerId, PurchaseProductRequestDto request) {
        Customer customer = findCustomer(customerId);

        Child child = childRepository.findById(request.getChildId())
                .orElseThrow(() -> new ResourceNotFoundException("Child not found"));
        if (!child.getCustomer().getId().equals(customer.getId())) {
            throw new ResourceNotFoundException("Child not found");
        }

        Product product = new Product();
        product.setCustomer(customer);
        product.setChild(child);
        product.setProductType(request.getProductType());
        product.setProductCost(request.getProductCost());
        product.setProductDuration(request.getProductDuration());
        product.setPurchaseDate(java.time.LocalDate.now());
        product.setStatus(true);
        productRepository.save(product);

        Transaction transaction = new Transaction();
        transaction.setCustomer(customer);
        transaction.setAgent(customer.getReferredBy());
        transaction.setAmount(request.getProductCost().doubleValue());
        transaction.setStatus("COMPLETED");
        transaction.setPaymentMethod(request.getPaymentMethod());
        transactionRepository.save(transaction);

        return product;
    }

    @Override
    public List<Product> listProducts(Long customerId) {
        Customer customer = findCustomer(customerId);
        return productRepository.findByCustomer(customer);
    }

    @Override
    public List<Transaction> listTransactions(Long customerId) {
        Customer customer = findCustomer(customerId);
        return transactionRepository.findByCustomer(customer);
    }

    private Customer findCustomer(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
    }
}
