package com.martins.eduinvest.controller;

import com.martins.eduinvest.dto.requestdto.ChildDetailsDTO;
import com.martins.eduinvest.dto.requestdto.PurchaseProductRequestDto;
import com.martins.eduinvest.dto.response.GenericResponse;
import com.martins.eduinvest.security.UserPrincipal;
import com.martins.eduinvest.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/profile")
    public ResponseEntity<GenericResponse> getProfile(@AuthenticationPrincipal UserPrincipal principal) {
        var customer = customerService.getProfile(principal.getId());
        return ResponseEntity.ok(new GenericResponse("200", "Profile fetched", HttpStatus.OK, customer));
    }

    @PostMapping("/children")
    public ResponseEntity<GenericResponse> addChild(@AuthenticationPrincipal UserPrincipal principal,
                                                      @Valid @RequestBody ChildDetailsDTO request) {
        var child = customerService.addChild(principal.getId(), request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new GenericResponse("201", "Child added", HttpStatus.CREATED, child));
    }

    @GetMapping("/children")
    public ResponseEntity<GenericResponse> listChildren(@AuthenticationPrincipal UserPrincipal principal) {
        var children = customerService.listChildren(principal.getId());
        return ResponseEntity.ok(new GenericResponse("200", "Children fetched", HttpStatus.OK, children));
    }

    @PostMapping("/products")
    public ResponseEntity<GenericResponse> purchaseProduct(@AuthenticationPrincipal UserPrincipal principal,
                                                              @Valid @RequestBody PurchaseProductRequestDto request) {
        var product = customerService.purchaseProduct(principal.getId(), request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new GenericResponse("201", "Product purchased", HttpStatus.CREATED, product));
    }

    @GetMapping("/products")
    public ResponseEntity<GenericResponse> listProducts(@AuthenticationPrincipal UserPrincipal principal) {
        var products = customerService.listProducts(principal.getId());
        return ResponseEntity.ok(new GenericResponse("200", "Products fetched", HttpStatus.OK, products));
    }

    @GetMapping("/transactions")
    public ResponseEntity<GenericResponse> listTransactions(@AuthenticationPrincipal UserPrincipal principal) {
        var transactions = customerService.listTransactions(principal.getId());
        return ResponseEntity.ok(new GenericResponse("200", "Transactions fetched", HttpStatus.OK, transactions));
    }
}
