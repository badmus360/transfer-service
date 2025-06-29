package com.fintech.transfer.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAccountRequest {
    private String email;
}
