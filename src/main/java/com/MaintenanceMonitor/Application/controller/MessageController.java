package com.MaintenanceMonitor.Application.controller;

import com.MaintenanceMonitor.Application.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/message")
    public String getDefaultMessage() {
        return messageService.getDefaultMessage();
    }

    @GetMapping("/message/set")
    public String setMessage(@RequestParam(required=true) String m) {
        if(!m.isEmpty() && !m.isBlank())
            return messageService.setMessage(m);
        return messageService.getFalseMessage();
    }

    @GetMapping("/message/reset")
    public String resetMessage() {
        return messageService.resetMessage();
    }
}