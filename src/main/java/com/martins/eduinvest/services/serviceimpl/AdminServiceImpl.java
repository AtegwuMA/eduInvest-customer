package com.martins.eduinvest.services.serviceimpl;

import com.martins.eduinvest.dto.requestdto.AdminUserInviteDto;
import com.martins.eduinvest.dto.response.SuccessDto;
import com.martins.eduinvest.enums.AgentStatus;
import com.martins.eduinvest.enums.WithdrawalStatus;
import com.martins.eduinvest.exceptions.BadRequestException;
import com.martins.eduinvest.exceptions.ResourceNotFoundException;
import com.martins.eduinvest.model.Admin;
import com.martins.eduinvest.model.Agent;
import com.martins.eduinvest.model.Customer;
import com.martins.eduinvest.model.Withdrawal;
import com.martins.eduinvest.repository.AdminRepository;
import com.martins.eduinvest.repository.AgentRepository;
import com.martins.eduinvest.repository.CustomerRepository;
import com.martins.eduinvest.repository.WithdrawalRepository;
import com.martins.eduinvest.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AgentRepository agentRepository;
    private final CustomerRepository customerRepository;
    private final WithdrawalRepository withdrawalRepository;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<Agent> listAgents(AgentStatus status) {
        return status == null ? agentRepository.findAll() : agentRepository.findByAgentStatus(status);
    }

    @Override
    public Agent updateAgentStatus(Long agentId, AgentStatus status) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new ResourceNotFoundException("Agent not found"));
        agent.setAgentStatus(status);
        return agentRepository.save(agent);
    }

    @Override
    public List<Customer> listCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<Withdrawal> listPendingWithdrawals() {
        return withdrawalRepository.findByStatus(WithdrawalStatus.PENDING);
    }

    @Override
    public Withdrawal markWithdrawalPaid(Long withdrawalId) {
        Withdrawal withdrawal = withdrawalRepository.findById(withdrawalId)
                .orElseThrow(() -> new ResourceNotFoundException("Withdrawal not found"));
        withdrawal.setStatus(WithdrawalStatus.PAID);
        withdrawal.setPaidAt(new Date());
        return withdrawalRepository.save(withdrawal);
    }

    @Override
    public SuccessDto inviteAdmin(AdminUserInviteDto request) {
        if (adminRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("An admin account with this email already exists");
        }

        Admin admin = new Admin();
        admin.setFirstName(request.getFirstName());
        admin.setLastName(request.getLastName());
        admin.setPhone(request.getPhone());
        admin.setEmail(request.getEmail());
        admin.setPassword(passwordEncoder.encode(request.getPassword()));
        admin.setAdminRole(request.getAdminRole());
        adminRepository.save(admin);

        return new SuccessDto("Admin invited: " + admin.getEmail());
    }
}
