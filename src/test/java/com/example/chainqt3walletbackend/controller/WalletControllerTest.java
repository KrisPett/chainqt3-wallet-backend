package com.example.chainqt3walletbackend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WalletControllerTest {
    @Autowired
    WebTestClient webTestClient;

    @Test
    void newAccountSuccess() {
        webTestClient
                .get().uri("/api/new-account")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(WalletController.AccountDTO.class).value(accountDTO -> {
                    assertTrue(accountDTO.baseAddress().startsWith("addr"));
                    assertEquals(24, accountDTO.mnemonic().split(" ").length);
                });
    }

}