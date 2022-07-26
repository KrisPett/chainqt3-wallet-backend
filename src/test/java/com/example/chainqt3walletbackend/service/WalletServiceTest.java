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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WalletServiceTest {

    WalletService walletService;

    @Mock
    AccountRepository accountRepository;

    @Captor
    ArgumentCaptor<AccountEntity> argumentCaptor;

    @BeforeEach
    void setUp() {
        walletService = new WalletService(accountRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createAccountSaveSuccess() {
        when(accountRepository.save(any())).thenReturn(Mono.just(AccountEntity.create()));
        walletService.createAccount().log().subscribe();

        verify(accountRepository).save(argumentCaptor.capture());

        assertTrue(argumentCaptor.getValue().getBaseAddress().startsWith("addr_"));
        assertEquals(24, argumentCaptor.getValue().getMnemonic().split(" ").length);
    }


}