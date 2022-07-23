package com.example.chainqt3walletbackend.entity.DTOs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonCreator
    public AccountDTO(@JsonProperty("id") String id,
                      @JsonProperty("mnemonic") String mnemonic,
                      @JsonProperty("accountKey") byte[] accountKey,
                      @JsonProperty("baseAddress") String baseAddress,
                      @JsonProperty("changeAddress") String changeAddress,
                      @JsonProperty("enterpriseAddress") String enterpriseAddress,
                      @JsonProperty("stakeAddress") String stakeAddress) {
        this.id = id;
        this.mnemonic = mnemonic;
        this.accountKey = accountKey;
        this.baseAddress = baseAddress;
        this.changeAddress = changeAddress;
        this.enterpriseAddress = enterpriseAddress;
        this.stakeAddress = stakeAddress;
    }
}
