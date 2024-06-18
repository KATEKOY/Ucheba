package com.example.demo.controller;

import com.example.demo.dto.Message;
import com.example.demo.dto.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    @Autowired
    private PersonRepository persrepository;


    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {
        persrepository.save(person);
        return person;
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person person) {
        if (!persrepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        person.setId(id);
        person = persrepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
    @GetMapping("/person")
    public Iterable<Person> getPersons() {
        return persrepository.findAll();
    }
    @GetMapping("/person/{id}")
    public Optional<Person> findPersonById(@PathVariable int id) {
        return persrepository.findById(id);
    }

    @GetMapping("/person/{p_id}/message")
    public List<Message> getMessagesByPersonId(@PathVariable int p_id) {
        Optional<Person> personOptional = persrepository.findById(p_id);
        Person person = personOptional.get();
        return person.getMessages();
    }

    @GetMapping ("/person/{p_id}/message/{m_id}")
    public ResponseEntity<Message> getMessageByPersonIdAndMessageId(@PathVariable int p_id, @PathVariable int m_id) {
        Optional<Person> personId = persrepository.findById(p_id);
        if (personId.isPresent()) {
            for (Message message : personId.get().getMessages()) {
                if (message.getId() == m_id) {
                    return ResponseEntity.ok(message);
                }
            }
        }
        return null;
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable int id) {
        persrepository.deleteById(id);
    }

    @DeleteMapping("/person/{p_id}/message/{m_id}")
    public ResponseEntity<Void> deleteMessageFromPerson(@PathVariable int p_id, @PathVariable int m_id) {
        Optional<Person> personOptional = persrepository.findById(p_id);
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            person.getMessages().removeIf(message -> message.getId() == m_id);
            persrepository.save(person);
        }
        return null;
    }

    @PostMapping("/person/{p_id}/message")
    public ResponseEntity<Person> addMessage(@PathVariable int p_id, @RequestBody Message message) {
        Optional<Person> personOptional = persrepository.findById(p_id);

        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            message.setPerson(person);
            message.setTime(LocalDateTime.now());
            person.addMessage(message);
            return ResponseEntity.ok(persrepository.save(person));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }



}
