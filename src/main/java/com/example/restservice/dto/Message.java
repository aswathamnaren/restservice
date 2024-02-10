package com.example.restservice.dto;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class Message {
    private String content;

    public Message(String content) {
        // Sanitize the input string before assigning it
        this.content = sanitize(content);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Method to sanitize the input string
    private String sanitize(String input) {
        return input.replaceAll("\\r\\n|\\n|\\r", "");
    }
}
