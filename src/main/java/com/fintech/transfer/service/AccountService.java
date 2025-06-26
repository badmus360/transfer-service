package com.fintech.transfer.service;

import com.fintech.transfer.response.BaseResponse;

public interface AccountService {
    BaseResponse<String> generateAccountNumber();
}
