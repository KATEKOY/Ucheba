package com.example.demo.Service;

import com.example.demo.dto.Message;
import com.example.demo.dto.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository persrepository;
    public Person addPerson(Person person) {
        return persrepository.save(person);
    }
    public ResponseEntity<Person> updatePerson(int id, Person person) {
        if (!persrepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        person.setId(id);
        return ResponseEntity.ok(persrepository.save(person));
    }
    public Iterable<Person> getPersons() {
        return persrepository.findAll();
    }

    public Optional<Person> findPersonById(int id) {
        return persrepository.findById(id);
    }

    public List<Message> getMessagesByPersonId(int p_id) {
        Optional<Person> personOptional = persrepository.findById(p_id);
        Person person = personOptional.get();
        return person.getMessages();
    }
    public ResponseEntity<Message> getMessageByPersonIdAndMessageId(int p_id, int m_id) {
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
    public void deletePerson(int id) {
        persrepository.deleteById(id);
    }
    public ResponseEntity<Message> deleteMessageFromPerson(int p_id, int m_id) {
        Optional<Person> personOptional = persrepository.findById(p_id);
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            person.getMessages().removeIf(message -> message.getId() == m_id);
            persrepository.save(person);
        }
        return null;
    }
    public ResponseEntity<Person> addMessage(int p_id, Message message) {
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


