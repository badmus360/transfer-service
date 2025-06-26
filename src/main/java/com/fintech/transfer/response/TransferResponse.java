package com.fintech.transfer.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferResponse {
    private String transactionId;
    private String status;
    private String message;
}
