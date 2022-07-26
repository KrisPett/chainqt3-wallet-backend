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
    String id;
    String mnemonic;
    byte[] accountKey;
    String baseAddress;
    String changeAddress;
    String enterpriseAddress;
    String stakeAddress;
}


