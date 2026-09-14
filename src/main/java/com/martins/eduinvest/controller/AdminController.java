package com.martins.eduinvest.controller;

import com.martins.eduinvest.dto.requestdto.AdminUserInviteDto;
import com.martins.eduinvest.dto.response.GenericResponse;
import com.martins.eduinvest.enums.AgentStatus;
import com.martins.eduinvest.services.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/agents")
    public ResponseEntity<GenericResponse> listAgents(@RequestParam(required = false) AgentStatus status) {
        var agents = adminService.listAgents(status);
        return ResponseEntity.ok(new GenericResponse("200", "Agents fetched", HttpStatus.OK, agents));
    }

    @PutMapping("/agents/{agentId}/approve")
    public ResponseEntity<GenericResponse> approveAgent(@PathVariable Long agentId) {
        var agent = adminService.updateAgentStatus(agentId, AgentStatus.ACTIVE);
        return ResponseEntity.ok(new GenericResponse("200", "Agent approved", HttpStatus.OK, agent));
    }

    @PutMapping("/agents/{agentId}/reject")
    public ResponseEntity<GenericResponse> rejectAgent(@PathVariable Long agentId) {
        var agent = adminService.updateAgentStatus(agentId, AgentStatus.REJECTED);
        return ResponseEntity.ok(new GenericResponse("200", "Agent rejected", HttpStatus.OK, agent));
    }

    @PutMapping("/agents/{agentId}/block")
    public ResponseEntity<GenericResponse> blockAgent(@PathVariable Long agentId) {
        var agent = adminService.updateAgentStatus(agentId, AgentStatus.BLOCKED);
        return ResponseEntity.ok(new GenericResponse("200", "Agent blocked", HttpStatus.OK, agent));
    }

    @GetMapping("/customers")
    public ResponseEntity<GenericResponse> listCustomers() {
        var customers = adminService.listCustomers();
        return ResponseEntity.ok(new GenericResponse("200", "Customers fetched", HttpStatus.OK, customers));
    }

    @GetMapping("/withdrawals/pending")
    public ResponseEntity<GenericResponse> listPendingWithdrawals() {
        var withdrawals = adminService.listPendingWithdrawals();
        return ResponseEntity.ok(new GenericResponse("200", "Pending withdrawals fetched", HttpStatus.OK, withdrawals));
    }

    @PutMapping("/withdrawals/{withdrawalId}/pay")
    public ResponseEntity<GenericResponse> payWithdrawal(@PathVariable Long withdrawalId) {
        var withdrawal = adminService.markWithdrawalPaid(withdrawalId);
        return ResponseEntity.ok(new GenericResponse("200", "Withdrawal marked as paid", HttpStatus.OK, withdrawal));
    }

    @PostMapping("/invite")
    public ResponseEntity<GenericResponse> inviteAdmin(@Valid @RequestBody AdminUserInviteDto request) {
        var result = adminService.inviteAdmin(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new GenericResponse("201", "Admin invited", HttpStatus.CREATED, result));
    }
}
