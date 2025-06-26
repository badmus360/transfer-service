package com.fintech.transfer.service;

import com.fintech.transfer.request.NameEnquiryRequest;
import com.fintech.transfer.request.TransferRequest;
import com.fintech.transfer.response.BankListResponse;
import com.fintech.transfer.response.BaseResponse;
import com.fintech.transfer.response.NameEnquiryResponse;
import com.fintech.transfer.response.TransferResponse;

import java.util.List;

public interface TransferService {

    BaseResponse<NameEnquiryResponse> initiateNameEnquiry(NameEnquiryRequest enquiryRequest) ;
    BaseResponse<TransferResponse> makeTransfer(TransferRequest request);
    BaseResponse<List<BankListResponse>> getBankList();
}
