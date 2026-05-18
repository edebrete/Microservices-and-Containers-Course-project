package com.example.ui_service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UiController {

    private final RestTemplate rest = new RestTemplate();

    @PostMapping("/ui/send-to-seller")
    public void sendToSeller(@RequestParam String desc) {
        rest.postForObject("http://seller-service:8080/sell?desc=" + desc, null, Void.class);
    }
}

