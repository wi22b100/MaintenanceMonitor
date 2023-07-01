package com.MaintenanceMonitor.Application.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private String falseMessage = "You tried a false statement, the right one is Localhost:8080/api/message/set?m=Your Message";

    private String defaultMessage = "Everything works as expected";

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public String setMessage(String message) {
        if(!message.isEmpty() && !message.isBlank()) {
            message = message.replace("+"," ");
            defaultMessage = message;
            return "ok";
        }
        return getFalseMessage();
    }
    public String getFalseMessage() {
        return falseMessage;
    }

    public String resetMessage() {
        defaultMessage = "Everything works as expected";
        return "ok";
    }
}