package com.example.chainqt3walletbackend.service;

import com.bloxbean.cardano.client.account.Account;
import com.bloxbean.cardano.client.common.model.Networks;
import com.example.chainqt3walletbackend.entity.AccountEntity;
import com.example.chainqt3walletbackend.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class WalletService {
    AccountRepository accountRepository;

    public WalletService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Mono<AccountEntity> createAccount() {
        Account newAccount = new Account(Networks.testnet());

        return accountRepository.save(AccountEntity.create(
                UUID.randomUUID().toString(),
                newAccount.mnemonic(),
                newAccount.privateKeyBytes(),
                newAccount.baseAddress(),
                newAccount.changeAddress(),
                newAccount.enterpriseAddress(),
                newAccount.stakeAddress()));
    }

}
