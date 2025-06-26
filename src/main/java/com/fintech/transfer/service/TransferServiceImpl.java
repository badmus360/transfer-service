package com.fintech.transfer.service;

import com.fintech.transfer.request.NameEnquiryRequest;
import com.fintech.transfer.request.TransferRequest;
import com.fintech.transfer.response.BankListResponse;
import com.fintech.transfer.response.BaseResponse;
import com.fintech.transfer.response.NameEnquiryResponse;
import com.fintech.transfer.response.TransferResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TransferServiceImpl implements TransferService{

    @Override
    public BaseResponse<NameEnquiryResponse> initiateNameEnquiry(NameEnquiryRequest enquiryRequest) {
        return BaseResponse.<NameEnquiryResponse>builder()
                .code("00")
                .flag(true)
                .result(modelAccountsForEnquiries(enquiryRequest))
                .build();
    }

    @Override
    public BaseResponse<TransferResponse> makeTransfer(TransferRequest request) {
        if (request.getAmount() <= 0) {
            return BaseResponse.<TransferResponse>builder()
                    .code("02")
                    .flag(false)
                    .message("Invalid transfer amount")
                    .build();
        }

        if (request.getBeneficiaryAccount().length() != 10) {
            return BaseResponse.<TransferResponse>builder()
                    .code("02")
                    .flag(false)
                    .message("Invalid destination account number")
                    .build();
        }

        String transactionId = UUID.randomUUID().toString();
        TransferResponse transferResponse = new TransferResponse(
                transactionId,
                "SUCCESS",
                "Transfer completed successfully"
        );

        return BaseResponse.<TransferResponse>builder()
                .code("00")
                .flag(true)
                .message("Transfer Successful")
                .result(transferResponse)
                .build();
    }

    @Override
    public BaseResponse<List<BankListResponse>> getBankList() {
        List<BankListResponse> banks = List.of(
                new BankListResponse("044", "Access Bank"),
                new BankListResponse("070", "Fidelity Bank"),
                new BankListResponse("011", "First Bank of Nigeria"),
                new BankListResponse("214", "First City Monument Bank (FCMB)"),
                new BankListResponse("058", "Guaranty Trust Bank (GTB)"),
                new BankListResponse("032", "Union Bank"),
                new BankListResponse("033", "United Bank for Africa (UBA)"),
                new BankListResponse("035", "Wema Bank"),
                new BankListResponse("057", "Zenith Bank")
        );

        return BaseResponse.<List<BankListResponse>>builder()
                .code("00")
                .flag(true)
                .message("Successful")
                .result(banks)
                .build();
    }

    private NameEnquiryResponse modelAccountsForEnquiries(NameEnquiryRequest enquiryRequest) {
        String bankCode = enquiryRequest.getBankCode();
        String accountNumber = enquiryRequest.getAccountNumber();
        String key = bankCode + ":" + accountNumber;

        return switch (key) {
            case "044:1234567890" -> new NameEnquiryResponse("John Legend", accountNumber, "Access Bank");
            case "058:0987654321" -> new NameEnquiryResponse("Michael Smith", accountNumber, "GTBank");
            case "011:1122334455" -> new NameEnquiryResponse("Peter Obi", accountNumber, "First Bank");
            case "033:5566778899" -> new NameEnquiryResponse("Charlie Faith", accountNumber, "UBA");
            default -> new NameEnquiryResponse("Unknown Account", accountNumber, "Unknown Bank");
        };
    }


}
