package com.example.chainqt3walletbackend.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
