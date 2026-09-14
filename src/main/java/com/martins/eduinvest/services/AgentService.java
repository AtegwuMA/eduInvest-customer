package com.martins.eduinvest.services;

import com.martins.eduinvest.dto.requestdto.AgentWithdrawalReqDto;
import com.martins.eduinvest.model.Agent;
import com.martins.eduinvest.model.Customer;
import com.martins.eduinvest.model.Withdrawal;

import java.util.List;

public interface AgentService {
    Agent getProfile(Long agentId);
    List<Customer> listReferrals(Long agentId);
    Withdrawal requestWithdrawal(Long agentId, AgentWithdrawalReqDto request);
    List<Withdrawal> listWithdrawals(Long agentId);
}
