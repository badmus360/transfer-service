package com.fintech.transfer.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferRequest {
    private String senderAccount;
    private String beneficiaryAccount;
    private String beneficiaryBankCode;
    private Double amount;
    private String narration;
}
