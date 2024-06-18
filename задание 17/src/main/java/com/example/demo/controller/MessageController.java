package com.example.demo.controller;

import com.example.demo.Service.MessageService;
import com.example.demo.dto.Message;
import com.example.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MessageController {
    @Autowired
    private MessageRepository mesrepository;
    @Autowired
    private MessageService messageService;

    @GetMapping("/message")
    public Iterable<Message> getMessages() {
        return messageService.getMessages();
    }

    @GetMapping("/message/{id}")
    public Optional<Message> findMessageById(@PathVariable int id) {
        return messageService.findMessageById(id);
    }
    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message) {
        return messageService.addMessage(message);
    }
    @PutMapping("/message/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message) {
        return messageService.updateMessage(id, message);
    }
    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id) {
        messageService.deleteMessage(id);
    }
}

