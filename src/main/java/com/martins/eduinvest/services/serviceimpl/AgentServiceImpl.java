package com.martins.eduinvest.services.serviceimpl;

import com.martins.eduinvest.dto.requestdto.AgentWithdrawalReqDto;
import com.martins.eduinvest.enums.WithdrawalStatus;
import com.martins.eduinvest.exceptions.BadRequestException;
import com.martins.eduinvest.exceptions.ResourceNotFoundException;
import com.martins.eduinvest.model.Agent;
import com.martins.eduinvest.model.Customer;
import com.martins.eduinvest.model.Withdrawal;
import com.martins.eduinvest.repository.AgentRepository;
import com.martins.eduinvest.repository.WithdrawalRepository;
import com.martins.eduinvest.services.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;
    private final WithdrawalRepository withdrawalRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Agent getProfile(Long agentId) {
        return findAgent(agentId);
    }

    @Override
    public List<Customer> listReferrals(Long agentId) {
        return findAgent(agentId).getReferrals();
    }

    @Override
    public Withdrawal requestWithdrawal(Long agentId, AgentWithdrawalReqDto request) {
        Agent agent = findAgent(agentId);

        if (!passwordEncoder.matches(request.getPassword(), agent.getPassword())) {
            throw new BadRequestException("Incorrect password");
        }
        if (request.getAmount() > agent.getReferralBonus()) {
            throw new BadRequestException("Withdrawal amount exceeds available balance");
        }

        Withdrawal withdrawal = new Withdrawal();
        withdrawal.setAgent(agent);
        withdrawal.setAmount(request.getAmount());
        withdrawal.setStatus(WithdrawalStatus.PENDING);
        withdrawalRepository.save(withdrawal);

        agent.setReferralBonus(agent.getReferralBonus() - request.getAmount());
        agentRepository.save(agent);

        return withdrawal;
    }

    @Override
    public List<Withdrawal> listWithdrawals(Long agentId) {
        return withdrawalRepository.findByAgent(findAgent(agentId));
    }

    private Agent findAgent(Long agentId) {
        return agentRepository.findById(agentId)
                .orElseThrow(() -> new ResourceNotFoundException("Agent not found"));
    }
}
