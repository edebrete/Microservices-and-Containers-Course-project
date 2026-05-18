package com.example.ui_service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ui")
public class UiMessageController {

    private final UiStreamController stream;

    public UiMessageController(UiStreamController stream) {
        this.stream = stream;
    }

    @PostMapping("/seller")
    public void seller(@RequestBody String msg) {
        stream.sendToSeller(msg);
    }

    @PostMapping("/bidder")
    public void bidder(@RequestBody String msg) {
        stream.sendToBidder(msg);
    }

    @PostMapping("/manager")
    public void manager(@RequestBody String msg) {
        stream.sendToManager(msg);
    }
}

