package com.example.chainqt3walletbackend.rest;

import com.bloxbean.cardano.client.account.Account;
import com.bloxbean.cardano.client.common.model.Networks;
import com.example.chainqt3walletbackend.entity.AccountEntity;
import com.example.chainqt3walletbackend.service.WalletService;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api")
@Slf4j
@AllArgsConstructor
public class WalletController {
    // BackendService backendService = new BFBackendService(Constants.BLOCKFROST_TESTNET_URL, "testnetvDFspA3OrpifwWMHZZVqwL6JIVdFYWIs");
    WalletService walletService;

    private final String MNEMONIC = "ramp all slice month wrong public analyst among blast ankle nephew busy cash spell brick purchase spare unhappy extend wrong drama grid kingdom aim";

    @GetMapping("new-account")
    public Mono<AccountDTO> newAccount() {
        return walletService.createAccount()
                .map(this::toAccountDTO).log();
    }

    @PostMapping("transfer-token")
    public String transferToken() {
        Account senderAccount = new Account(Networks.testnet(), MNEMONIC);

        return senderAccount.mnemonic();
    }

    private AccountDTO toAccountDTO(AccountEntity accountEntity) {
        return new AccountDTO(
                UUID.randomUUID().toString(),
                accountEntity.getMnemonic(),
                accountEntity.getAccountKey(),
                accountEntity.getBaseAddress(),
                accountEntity.getChangeAddress(),
                accountEntity.getEnterpriseAddress(),
                accountEntity.getStakeAddress());
    }

    record AccountDTO(String id, String mnemonic, byte[] accountKey, String baseAddress, String changeAddress,
                      String enterpriseAddress, String stakeAddress) {
    }
}