package com.MaintenanceMonitor.Application.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final String defaultMessage = "Everything works as expected";

    public String getDefaultMessage() {
        return defaultMessage;
    }
}