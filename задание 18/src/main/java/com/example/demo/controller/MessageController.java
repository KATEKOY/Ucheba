package com.example.demo.controller;

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

    @GetMapping("/message")
    public Iterable<Message> getMessages() {
        return mesrepository.findAll();
    }

    @GetMapping("/message/{id}")
    public Optional<Message> findMessageById(@PathVariable int id) {
        return mesrepository.findById(id);
    }
    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message) {
        mesrepository.save(message);
        return message;
    }
    @PutMapping("/message/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message) {
        if (!mesrepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        message.setId(id);
        message = mesrepository.save(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id) {
        mesrepository.deleteById(id);
    }
}

