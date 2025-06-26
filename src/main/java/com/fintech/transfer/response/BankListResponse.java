package com.fintech.transfer.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankListResponse {
    private String bankCode;
    private String bankName;
}
