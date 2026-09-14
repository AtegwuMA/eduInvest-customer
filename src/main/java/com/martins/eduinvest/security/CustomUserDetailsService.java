package com.martins.eduinvest.security;

import com.martins.eduinvest.model.Admin;
import com.martins.eduinvest.model.Agent;
import com.martins.eduinvest.model.Customer;
import com.martins.eduinvest.repository.AdminRepository;
import com.martins.eduinvest.repository.AgentRepository;
import com.martins.eduinvest.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;
    private final AgentRepository agentRepository;
    private final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var customer = customerRepository.findByEmail(email);
        if (customer.isPresent()) {
            Customer c = customer.get();
            return new UserPrincipal(c.getId(), c.getEmail(), c.getPassword(), "CUSTOMER");
        }

        var agent = agentRepository.findByEmail(email);
        if (agent.isPresent()) {
            Agent a = agent.get();
            return new UserPrincipal(a.getId(), a.getEmail(), a.getPassword(), "AGENT");
        }

        var admin = adminRepository.findByEmail(email);
        if (admin.isPresent()) {
            Admin ad = admin.get();
            return new UserPrincipal(ad.getId(), ad.getEmail(), ad.getPassword(), "ADMIN");
        }

        throw new UsernameNotFoundException("No account found for email: " + email);
    }
}
