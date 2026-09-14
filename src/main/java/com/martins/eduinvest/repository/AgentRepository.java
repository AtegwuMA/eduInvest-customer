package com.martins.eduinvest.repository;

import com.martins.eduinvest.enums.AgentStatus;
import com.martins.eduinvest.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AgentRepository extends JpaRepository<Agent, Long> {
    Optional<Agent> findByEmail(String email);
    Optional<Agent> findByReferralCode(String referralCode);
    boolean existsByEmail(String email);
    boolean existsByReferralCode(String referralCode);
    List<Agent> findByAgentStatus(AgentStatus agentStatus);
}
