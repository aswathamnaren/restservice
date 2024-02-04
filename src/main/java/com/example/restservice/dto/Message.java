package com.example.restservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message
{
    @JsonProperty("message")
    private String message;
    public Message(String message) {
        this.message = message;
    }

    // Getter and setter for message
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
