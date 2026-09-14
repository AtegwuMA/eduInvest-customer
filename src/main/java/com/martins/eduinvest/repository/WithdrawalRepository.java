package com.martins.eduinvest.repository;

import com.martins.eduinvest.enums.WithdrawalStatus;
import com.martins.eduinvest.model.Agent;
import com.martins.eduinvest.model.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long> {
    List<Withdrawal> findByAgent(Agent agent);
    List<Withdrawal> findByStatus(WithdrawalStatus status);
}
