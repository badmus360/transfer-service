package com.fintech.transfer.service;

import com.fintech.transfer.entity.Account;
import com.fintech.transfer.repository.AccountRepository;
import com.fintech.transfer.response.BaseResponse;
import com.fintech.transfer.response.GetAccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class DashBoardServiceImpl implements DashBoardService {

    private final AccountRepository accountRepository;

    @Override
    public BaseResponse<GetAccountResponse> getCustomerAccount() {
        String subject = SecurityContextHolder.getContext().getAuthentication().getName();

        Account account = accountRepository.findByEmail(subject).orElse(null);

        if (account == null) {
            return BaseResponse.<GetAccountResponse>builder()
                    .code("00")
                    .flag(true)
                    .message("No account found for user")
                    .build();
        }

        GetAccountResponse response = getGetAccountResponse(account);

        return BaseResponse.<GetAccountResponse>builder()
                .code("00")
                .flag(true)
                .message("Account retrieved successfully")
                .result(response)
                .build();
    }

    private static GetAccountResponse getGetAccountResponse(Account account) {
        GetAccountResponse response = new GetAccountResponse();
        response.setAccountName(account.getAccountName());
        response.setAccountNo(account.getAccountNo());
        response.setAccountType(account.getProductName());
        response.setTier(account.getTier());

        BigDecimal availableBalance = new BigDecimal(account.getAvailableBalanceStr());
        response.setAvailableBalance(availableBalance);
        response.setBalance(availableBalance);
        response.setCanTransfer(account.getTier() != null && account.getTier() >= 2);
        return response;
    }
}