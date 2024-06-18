package com.example.demo.Service;

import com.example.demo.dto.Message;
import com.example.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository mesrepository;

    public Iterable<Message> getMessages() {
        return mesrepository.findAll();
    }
    public Optional<Message> findMessageById(@PathVariable int id) {
        return mesrepository.findById(id);
    }
    public Message addMessage(@RequestBody Message message) {
        mesrepository.save(message);
        return message;
    }
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message) {
        if (!mesrepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        message.setId(id);
        message = mesrepository.save(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    public void deleteMessage(@PathVariable int id) {
        mesrepository.deleteById(id);
    }
}
