package com.fintech.transfer.controller;

import com.fintech.transfer.request.NameEnquiryRequest;
import com.fintech.transfer.request.TransferRequest;
import com.fintech.transfer.response.*;
import com.fintech.transfer.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfer")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @Value("${app.secret-key}")
    private String validSecretKey;

    @PostMapping("/name-enquiry")
    public BaseResponse<NameEnquiryResponse> initiateNameEnquiry( @RequestBody NameEnquiryRequest request,
                                                                  @RequestHeader("X-API-KEY") String apiKey) {

        if (!validSecretKey.equals(apiKey)) {
            return BaseResponse.<NameEnquiryResponse>builder()
                    .code("03")
                    .flag(false)
                    .message("Unauthorized")
                    .build();
        }

        return transferService.initiateNameEnquiry(request);
    }

    @PostMapping("/create")
    BaseResponse<TransferResponse> makeTransfer(@RequestBody TransferRequest request,
                                                @RequestHeader("X-API-KEY") String apiKey) {

        if (!validSecretKey.equals(apiKey)) {
            return BaseResponse.<TransferResponse>builder()
                    .code("03")
                    .flag(false)
                    .message("Unauthorized")
                    .build();
        }

        return transferService.makeTransfer(request);
    }

    @GetMapping("/banks")
    public BaseResponse<List<BankListResponse>> getBankList(
            @RequestHeader("X-API-KEY") String apiKey) {

        if (!validSecretKey.equals(apiKey)) {
            return BaseResponse.<List<BankListResponse>>builder()
                    .code("03")
                    .flag(false)
                    .message("Unauthorized")
                    .build();
        }

        return transferService.getBankList();
    }
}
