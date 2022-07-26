package com.example.chainqt3walletbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor(staticName = "create")
@Document("account")
public class AccountEntity {
    @Id
    private String id;
    private String mnemonic;
    private byte[] accountKey;
    private String baseAddress;
    private String changeAddress;
    private String enterpriseAddress;
    private String stakeAddress;
}


