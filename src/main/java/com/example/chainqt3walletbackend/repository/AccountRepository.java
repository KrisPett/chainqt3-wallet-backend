package com.example.chainqt3walletbackend.repository;

import com.example.chainqt3walletbackend.entity.AccountEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<AccountEntity, String> {
}
