package com.example.chainqt3walletbackend.service;

import com.example.chainqt3walletbackend.entity.AccountEntity;
import com.example.chainqt3walletbackend.repository.AccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WalletServiceTest {

    WalletService walletService;

    @Mock
    AccountRepository accountRepository;

    private AccountEntity accountDummyData;

    @BeforeEach
    void setUp() {
        walletService = new WalletService(accountRepository);
        accountDummyData = new AccountEntity(null, null, null, null, null, null, null);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createAccountSaveSuccess() {
        when(accountRepository.save(any())).thenReturn(Mono.just(accountDummyData));
        var account = walletService.createAccount().log();

        ArgumentCaptor<AccountEntity> accountEntityArgumentCaptor = ArgumentCaptor.forClass(AccountEntity.class);

        StepVerifier.create(account)
                        .assertNext(accountEntity -> {
                            verify(accountRepository).save(accountEntityArgumentCaptor.capture());
                            assertEquals(accountEntity, accountDummyData);
                        })
                .verifyComplete();
    }
}