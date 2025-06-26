package com.fintech.transfer.service;


import com.fintech.transfer.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.fintech.transfer.util.AppUtils.generateRandomNumeric;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    @Override
    public BaseResponse<String> generateAccountNumber() {
        return BaseResponse.<String>builder()
                .code("00")
                .flag(true)
                .message("Account Created")
                .result("10256"+generateRandomNumeric(5))
                .build();
    }
}
