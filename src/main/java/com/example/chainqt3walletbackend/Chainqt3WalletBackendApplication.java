package com.example.chainqt3walletbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class Chainqt3WalletBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chainqt3WalletBackendApplication.class, args);
    }


}
