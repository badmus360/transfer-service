package com.fintech.transfer.entity;

import com.fintech.transfer.enums.Channel;
import com.fintech.transfer.enums.Status;
import com.fintech.transfer.enums.TrxCategory;
import com.fintech.transfer.enums.TrxType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TRANSACTION")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private String sessionId;
    private String processorStatus;
    private String processorCode;
    private String processorMessage;
    private BigDecimal amount;
    private BigDecimal charges;
    private String beneficiaryName;
    private String beneficiaryAccountNo;
    private String beneficiaryBankCode;
    private String beneficiaryBankName;
    private String sourceAccountNo;
    private String sourceAccountName;
    private String sourceBankName;
    private String sourceBankCode;
    private String description;
    private String narration;
    @Enumerated(EnumType.STRING)
    private TrxType type;
    @Enumerated(EnumType.STRING)
    private TrxCategory category;
    @Enumerated(EnumType.STRING)
    private Channel channel;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime transactionTime;
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
