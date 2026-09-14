package com.martins.eduinvest.services;

import com.martins.eduinvest.dto.requestdto.AdminUserInviteDto;
import com.martins.eduinvest.dto.response.SuccessDto;
import com.martins.eduinvest.enums.AgentStatus;
import com.martins.eduinvest.model.Agent;
import com.martins.eduinvest.model.Customer;
import com.martins.eduinvest.model.Withdrawal;

import java.util.List;

public interface AdminService {
    List<Agent> listAgents(AgentStatus status);
    Agent updateAgentStatus(Long agentId, AgentStatus status);
    List<Customer> listCustomers();
    List<Withdrawal> listPendingWithdrawals();
    Withdrawal markWithdrawalPaid(Long withdrawalId);
    SuccessDto inviteAdmin(AdminUserInviteDto request);
}
