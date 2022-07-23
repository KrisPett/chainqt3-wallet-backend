package com.example.chainqt3walletbackend.entity.DTOs;

import lombok.Value;

@Value
public class AccountDTO {
    String id;
    String mnemonic;
    byte[] accountKey;
    String baseAddress;
    String changeAddress;
    String enterpriseAddress;
    String stakeAddress;
}
