package com.example.chainqt3walletbackend.rest;

import com.bloxbean.cardano.client.backend.api.BackendService;
import com.bloxbean.cardano.client.backend.blockfrost.common.Constants;
import com.bloxbean.cardano.client.backend.blockfrost.service.BFBackendService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class controller {
    BackendService backendService = new BFBackendService(Constants.BLOCKFROST_TESTNET_URL, "dfr");

    @GetMapping("get")
    public String get(){
        return "get";
    }
}

