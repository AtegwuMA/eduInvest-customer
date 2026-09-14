package com.martins.eduinvest.controller;

import com.martins.eduinvest.dto.requestdto.LoginRequestDto;
import com.martins.eduinvest.dto.requestdto.SignupRequestDto;
import com.martins.eduinvest.dto.response.AuthResponseDto;
import com.martins.eduinvest.dto.response.GenericResponse;
import com.martins.eduinvest.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup/customer")
    public ResponseEntity<GenericResponse> signupCustomer(@Valid @RequestBody SignupRequestDto request) {
        AuthResponseDto response = authService.signupCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new GenericResponse("201", "Customer account created", HttpStatus.CREATED, response));
    }

    @PostMapping("/signup/agent")
    public ResponseEntity<GenericResponse> signupAgent(@Valid @RequestBody SignupRequestDto request) {
        AuthResponseDto response = authService.signupAgent(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new GenericResponse("201", "Agent account created and pending admin approval", HttpStatus.CREATED, response));
    }

    @PostMapping("/login")
    public ResponseEntity<GenericResponse> login(@Valid @RequestBody LoginRequestDto request) {
        AuthResponseDto response = authService.login(request);
        return ResponseEntity.ok(new GenericResponse("200", "Login successful", HttpStatus.OK, response));
    }
}
