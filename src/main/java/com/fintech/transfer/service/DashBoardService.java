package com.fintech.transfer.service;


import com.fintech.transfer.request.GetAccountRequest;
import com.fintech.transfer.response.BaseResponse;
import com.fintech.transfer.response.GetAccountResponse;

public interface DashBoardService {
    BaseResponse<GetAccountResponse> getCustomerAccount(GetAccountRequest getAccountRequest);
}
