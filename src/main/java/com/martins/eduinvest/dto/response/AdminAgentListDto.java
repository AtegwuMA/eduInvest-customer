package com.martins.eduinvest.dto.response;

import com.martins.eduinvest.dto.response.baseresponsedto.BaseClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminAgentListDto extends BaseClass {

    private Integer totalAgents;
    private Integer activeAgents;
    private Integer pendingAgents;
    private Integer blockedAgents;
    private Integer totalList;
    private String state; //Same as location;
    private boolean status;

}