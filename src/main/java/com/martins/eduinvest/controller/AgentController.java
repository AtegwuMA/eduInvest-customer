package com.martins.eduinvest.controller;

import com.martins.eduinvest.dto.requestdto.AgentWithdrawalReqDto;
import com.martins.eduinvest.dto.response.GenericResponse;
import com.martins.eduinvest.security.UserPrincipal;
import com.martins.eduinvest.services.AgentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agent")
@RequiredArgsConstructor
public class AgentController {

    private final AgentService agentService;

    @GetMapping("/profile")
    public ResponseEntity<GenericResponse> getProfile(@AuthenticationPrincipal UserPrincipal principal) {
        var agent = agentService.getProfile(principal.getId());
        return ResponseEntity.ok(new GenericResponse("200", "Profile fetched", HttpStatus.OK, agent));
    }

    @GetMapping("/referrals")
    public ResponseEntity<GenericResponse> listReferrals(@AuthenticationPrincipal UserPrincipal principal) {
        var referrals = agentService.listReferrals(principal.getId());
        return ResponseEntity.ok(new GenericResponse("200", "Referrals fetched", HttpStatus.OK, referrals));
    }

    @PostMapping("/withdrawals")
    public ResponseEntity<GenericResponse> requestWithdrawal(@AuthenticationPrincipal UserPrincipal principal,
                                                                @Valid @RequestBody AgentWithdrawalReqDto request) {
        var withdrawal = agentService.requestWithdrawal(principal.getId(), request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new GenericResponse("201", "Withdrawal requested", HttpStatus.CREATED, withdrawal));
    }

    @GetMapping("/withdrawals")
    public ResponseEntity<GenericResponse> listWithdrawals(@AuthenticationPrincipal UserPrincipal principal) {
        var withdrawals = agentService.listWithdrawals(principal.getId());
        return ResponseEntity.ok(new GenericResponse("200", "Withdrawals fetched", HttpStatus.OK, withdrawals));
    }
}
