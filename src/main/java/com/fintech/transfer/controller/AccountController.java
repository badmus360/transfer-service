package com.fintech.transfer.controller;

import com.fintech.transfer.response.BaseResponse;
import com.fintech.transfer.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @Value("${app.secret-key}")
    private String validSecretKey;

    @GetMapping("/create")
    public BaseResponse<String> generateAccountNumber(@RequestHeader("X-API-KEY") String apiKey) {
        if (!validSecretKey.equals(apiKey)) {
            return BaseResponse.<String>builder()
                    .code("03")
                    .flag(false)
                    .message("Unauthorized")
                    .build();
        }

        return accountService.generateAccountNumber();
    }
}
