package com.example.chainqt3walletbackend.rest;


import com.example.chainqt3walletbackend.entity.DTOs.AccountDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@AutoConfigureDataMongo
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
                .expectBody(AccountDTO.class).value(accountDTO -> {
                    assertTrue(accountDTO.getBaseAddress().startsWith("addr"));
                    assertEquals(24, accountDTO.getMnemonic().split(" ").length);
                });
    }

}