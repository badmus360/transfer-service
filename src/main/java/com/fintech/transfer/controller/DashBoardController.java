package com.fintech.transfer.controller;

import com.fintech.transfer.response.BaseResponse;
import com.fintech.transfer.response.GetAccountResponse;
import com.fintech.transfer.service.DashBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashBoardController {

    private final DashBoardService dashBoardService;

    @Value("${app.secret-key}")
    private String validSecretKey;

    @GetMapping("/account")
    public BaseResponse<GetAccountResponse> getCustomerAccount(
            @RequestHeader("X-API-KEY") String apiKey) {

        if (!validSecretKey.equals(apiKey)) {
            return BaseResponse.<GetAccountResponse>builder()
                    .code("03")
                    .flag(false)
                    .message("Unauthorized")
                    .build();
        }

        return dashBoardService.getCustomerAccount();
    }
}
