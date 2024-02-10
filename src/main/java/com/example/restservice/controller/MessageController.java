package com.example.restservice.controller;

import com.example.restservice.dto.ErrorMessage;
import com.example.restservice.dto.Message;
import com.example.restservice.exception.InternalServerErrorException;
import com.example.restservice.exception.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import java.util.Random;

@Slf4j
@RestController
public class MessageController {

    @PostMapping(path = "/api/messages", produces = "application/json")
    public ResponseEntity<?> createMessage(@RequestBody String message) {
        log.info("MESSAGE RECEIVED: {}", message);
        try {
            // Simulate random exceptions
            simulateRandomExceptions();
            // If no exception is thrown, return success response
            return ResponseEntity.status(HttpStatus.CREATED).body(new Message(message));
        } catch (Exception e) {
            return handleException(e);
        }
    }

    private void simulateRandomExceptions() throws Exception {
        Random random = new Random();
        int randomNumber = random.nextInt(5); // Adjust the range based on the number of exceptions you want to simulate
        switch (randomNumber) {
            case 0:
                throw new IllegalArgumentException("Invalid input provided");
            case 1:
                throw new UnauthorizedException("Unauthorized access");
            case 2:
                throw new InternalServerErrorException("Internal server error occurred");
                // Add more cases for other types of exceptions and their respective HTTP status codes
            default:
                // No exception, continue execution
        }
    }

    private ResponseEntity<?> handleException(Exception e) {
        // Log the exception
        log.error("An error occurred while processing the request: {}", e.getMessage());
        // Return error response with JSON containing error message
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }
}
