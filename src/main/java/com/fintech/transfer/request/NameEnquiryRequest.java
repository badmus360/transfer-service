package com.fintech.transfer.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NameEnquiryRequest {
    private String bankCode;
    private String accountNumber;
}
