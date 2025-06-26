package com.fintech.transfer.controller;

import com.fintech.transfer.response.BaseResponse;
import com.fintech.transfer.response.GetAccountResponse;
import com.fintech.transfer.service.DashBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashBoardController {

    private final DashBoardService dashBoardService;

    @GetMapping("/account")
    public BaseResponse<GetAccountResponse> getCustomerAccount() {
        return dashBoardService.getCustomerAccount();
    }
}
