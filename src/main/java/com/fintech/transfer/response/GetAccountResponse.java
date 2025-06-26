package com.fintech.transfer.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAccountResponse {
    private String accountName;
    private String accountNo;
    private String accountType;
    private Integer tier;
    private BigDecimal balance;
    private BigDecimal availableBalance;
    private Boolean canTransfer;
}
