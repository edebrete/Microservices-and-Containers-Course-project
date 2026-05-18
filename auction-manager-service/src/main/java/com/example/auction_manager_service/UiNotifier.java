package com.example.auction_manager_service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UiNotifier {

    private final RestTemplate rest = new RestTemplate();

    public void sendManagerMessage(String message) {
        rest.postForObject(
                "http://ui-service:8083/ui/manager",
                message,
                Void.class
        );
    }
}
