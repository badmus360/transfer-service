package com.fintech.transfer.controller;

import com.fintech.transfer.response.BaseResponse;
import com.fintech.transfer.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/create")
    public BaseResponse<String> generateAccountNumber() {
        return accountService.generateAccountNumber();
    }
}
