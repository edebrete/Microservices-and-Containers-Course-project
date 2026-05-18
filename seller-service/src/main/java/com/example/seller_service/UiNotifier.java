package com.example.seller_service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UiNotifier {

    private final RestTemplate rest = new RestTemplate();

    public void sendSellerMessage(String message) {
        rest.postForObject(
                "http://ui-service:8083/ui/seller",
                message,
                Void.class
        );
    }
}

