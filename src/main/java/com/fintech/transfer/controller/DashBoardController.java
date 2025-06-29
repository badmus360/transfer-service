package com.fintech.transfer.controller;

import com.fintech.transfer.request.GetAccountRequest;
import com.fintech.transfer.response.BaseResponse;
import com.fintech.transfer.response.GetAccountResponse;
import com.fintech.transfer.service.DashBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashBoardController {

    private final DashBoardService dashBoardService;

    @Value("${app.secret-key}")
    private String validSecretKey;

    @PostMapping("/account")
    public BaseResponse<GetAccountResponse> getCustomerAccount(
            @RequestHeader("X-API-KEY") String apiKey, @RequestBody GetAccountRequest getAccountRequest) {

        if (!validSecretKey.equals(apiKey)) {
            return BaseResponse.<GetAccountResponse>builder()
                    .code("03")
                    .flag(false)
                    .message("Unauthorized")
                    .build();
        }

        return dashBoardService.getCustomerAccount(getAccountRequest);
    }
}
