package com.example.demo.controller;

import com.example.demo.Service.PersonService;
import com.example.demo.dto.Message;
import com.example.demo.dto.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    @Autowired
    private PersonRepository persrepository;
    @Autowired
    private PersonService personService;


    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @GetMapping("/person")
    public Iterable<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/person/{id}")
    public Optional<Person> findPersonById(@PathVariable int id) {
        return personService.findPersonById(id);
    }

    @GetMapping("/person/{p_id}/message")
    public List<Message> getMessagesByPersonId(@PathVariable int p_id) {
        return personService.getMessagesByPersonId(p_id);
    }

    @GetMapping("/person/{p_id}/message/{m_id}")
    public ResponseEntity<Message> getMessageByPersonIdAndMessageId(@PathVariable int p_id, @PathVariable int m_id) {
        return personService.getMessageByPersonIdAndMessageId(p_id, m_id);
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable int id) {
        personService.deletePerson(id);
    }

    @DeleteMapping("/person/{p_id}/message/{m_id}")
    public ResponseEntity<Message> deleteMessageFromPerson(@PathVariable int p_id, @PathVariable int m_id) {
        return personService.deleteMessageFromPerson(p_id, m_id);
    }

    @PostMapping("/person/{p_id}/message")
    public ResponseEntity<Person> addMessage(@PathVariable int p_id, @RequestBody Message message) {
        return personService.addMessage(p_id, message);
    }
}
