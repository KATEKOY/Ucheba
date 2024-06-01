package com.example.demo.controller;

import com.example.demo.dto.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable int id) {
        persrepository.deleteById(id);
    }
}
