package com.example.restservice.controller;

import com.example.restservice.dto.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MessageController {

    @PostMapping(path = "/api/messages" , produces="application/json")
    public ResponseEntity<Message> createMessage(@RequestBody String message) {
        log.info("MESSAGE RECEIVED: {}", message);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new Message(message));
    }
}
