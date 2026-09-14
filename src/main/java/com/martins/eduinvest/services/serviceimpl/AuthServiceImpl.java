package com.martins.eduinvest.services.serviceimpl;

import com.martins.eduinvest.dto.requestdto.LoginRequestDto;
import com.martins.eduinvest.dto.requestdto.SignupRequestDto;
import com.martins.eduinvest.dto.response.AuthResponseDto;
import com.martins.eduinvest.enums.AgentStatus;
import com.martins.eduinvest.exceptions.BadRequestException;
import com.martins.eduinvest.model.Agent;
import com.martins.eduinvest.model.Customer;
import com.martins.eduinvest.repository.AgentRepository;
import com.martins.eduinvest.repository.CustomerRepository;
import com.martins.eduinvest.security.UserPrincipal;
import com.martins.eduinvest.security.jwt.JwtUtils;
import com.martins.eduinvest.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final SecureRandom random = new SecureRandom();

    private final CustomerRepository customerRepository;
    private final AgentRepository agentRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Override
    public AuthResponseDto signupCustomer(SignupRequestDto request) {
        if (customerRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("An account with this email already exists");
        }

        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setGender(request.getGender());
        customer.setDob(toDate(request.getDob()));
        customer.setPhone(request.getPhone());
        customer.setEmail(request.getEmail());
        customer.setPassword(passwordEncoder.encode(request.getPassword()));

        if (request.getReferralCode() != null && !request.getReferralCode().isBlank()) {
            Agent agent = agentRepository.findByReferralCode(request.getReferralCode())
                    .orElseThrow(() -> new BadRequestException("Referral code not recognized"));
            customer.setReferredBy(agent);
            agent.setTotalReferralsCount(agent.getTotalReferralsCount() + 1);
            agentRepository.save(agent);
        }

        customerRepository.save(customer);

        return buildAuthResponse(customer.getEmail(), request.getPassword());
    }

    @Override
    public AuthResponseDto signupAgent(SignupRequestDto request) {
        if (agentRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("An account with this email already exists");
        }

        Agent agent = new Agent();
        agent.setFirstName(request.getFirstName());
        agent.setLastName(request.getLastName());
        agent.setGender(request.getGender());
        agent.setDob(toDate(request.getDob()));
        agent.setPhone(request.getPhone());
        agent.setEmail(request.getEmail());
        agent.setPassword(passwordEncoder.encode(request.getPassword()));
        agent.setAgentStatus(AgentStatus.PENDING);
        agent.setReferralCode(generateReferralCode());
        agent.setTotalReferralsCount(0L);
        agent.setReferralBonus(0.0);

        agentRepository.save(agent);

        return buildAuthResponse(agent.getEmail(), request.getPassword());
    }

    @Override
    public AuthResponseDto login(LoginRequestDto request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        String token = jwtUtils.generateToken(principal);

        return new AuthResponseDto(token, principal.getEmail(), principal.getRole(), principal.getId());
    }

    private AuthResponseDto buildAuthResponse(String email, String rawPassword) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, rawPassword));
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        String token = jwtUtils.generateToken(principal);
        return new AuthResponseDto(token, principal.getEmail(), principal.getRole(), principal.getId());
    }

    private Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    private String generateReferralCode() {
        String code;
        do {
            StringBuilder sb = new StringBuilder("EDU-");
            for (int i = 0; i < 6; i++) {
                sb.append(ALPHANUMERIC.charAt(random.nextInt(ALPHANUMERIC.length())));
            }
            code = sb.toString();
        } while (agentRepository.existsByReferralCode(code));
        return code;
    }
}
