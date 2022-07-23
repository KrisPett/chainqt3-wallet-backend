package com.example.chainqt3walletbackend.rest;

import com.example.chainqt3walletbackend.entity.AccountEntity;
import com.example.chainqt3walletbackend.entity.DTOs.AccountDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class WalletControllerTest {
    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    WalletController walletController;

    @Test
    void newAccountSuccess() {
        webTestClient
                .get().uri("/api/new-account")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(AccountDTO.class).value(accountDTO -> {
                    assertTrue(accountDTO.getBaseAddress().startsWith("addr"));
                    assertEquals(24, accountDTO.getMnemonic().split(" ").length);
                });
    }

}