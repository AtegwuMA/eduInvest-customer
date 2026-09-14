package com.martins.eduinvest.services;

import com.martins.eduinvest.dto.requestdto.LoginRequestDto;
import com.martins.eduinvest.dto.requestdto.SignupRequestDto;
import com.martins.eduinvest.dto.response.AuthResponseDto;

public interface AuthService {
    AuthResponseDto signupCustomer(SignupRequestDto request);
    AuthResponseDto signupAgent(SignupRequestDto request);
    AuthResponseDto login(LoginRequestDto request);
}
