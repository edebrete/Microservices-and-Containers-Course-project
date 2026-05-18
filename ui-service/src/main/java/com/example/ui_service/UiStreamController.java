package com.example.ui_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/stream")
public class UiStreamController {

    private final SseEmitter sellerEmitter = new SseEmitter(Long.MAX_VALUE);
    private final SseEmitter bidderEmitter = new SseEmitter(Long.MAX_VALUE);
    private final SseEmitter managerEmitter = new SseEmitter(Long.MAX_VALUE);

    @GetMapping("/seller")
    public SseEmitter sellerStream() {
        return sellerEmitter;
    }

    @GetMapping("/bidder")
    public SseEmitter bidderStream() {
        return bidderEmitter;
    }

    @GetMapping("/manager")
    public SseEmitter managerStream() {
        return managerEmitter;
    }

    public void sendToSeller(String msg) {
        try { sellerEmitter.send(msg); } catch (Exception ignored) {}
    }

    public void sendToBidder(String msg) {
        try { bidderEmitter.send(msg); } catch (Exception ignored) {}
    }

    public void sendToManager(String msg) {
        try { managerEmitter.send(msg); } catch (Exception ignored) {}
    }
}
