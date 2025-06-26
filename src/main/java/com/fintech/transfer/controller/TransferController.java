package com.fintech.transfer.controller;

import com.fintech.transfer.request.NameEnquiryRequest;
import com.fintech.transfer.request.TransferRequest;
import com.fintech.transfer.response.BankListResponse;
import com.fintech.transfer.response.BaseResponse;
import com.fintech.transfer.response.NameEnquiryResponse;
import com.fintech.transfer.response.TransferResponse;
import com.fintech.transfer.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfer")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @PostMapping("/name-enquiry")
    public BaseResponse<NameEnquiryResponse> initiateNameEnquiry(@RequestBody NameEnquiryRequest request) {
        return transferService.initiateNameEnquiry(request);
    }

    @PostMapping("/create")
    BaseResponse<TransferResponse> makeTransfer(@RequestBody TransferRequest request) {
        return transferService.makeTransfer(request);
    }

    @GetMapping("/banks")
    public BaseResponse<List<BankListResponse>> getBankList() {
        return transferService.getBankList();
    }
}
