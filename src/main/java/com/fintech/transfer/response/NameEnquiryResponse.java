package com.fintech.transfer.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NameEnquiryResponse {
    private String accountName;
    private String accountNumber;
    private String bank;
}
