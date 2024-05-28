package com.example.restdemo;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    private List<Person> persons = new ArrayList<>(Arrays.asList(
            new Person(1, "Ivan", "Ivanovich", "Ivanov", LocalDate.of(1999, 2,3)),
            new Person(2, "Петр", "Петрович", "Петров", LocalDate.of(2002, 2,2)),
            new Person(3, "Евгений", "Васильевич", "Васин", LocalDate.of(2005, 4,8)),
            new Person(4, "Максим", "Яковлевич", "Окопский", LocalDate.of(1978, 6,5))
    ));
    private List <Message> messages = new ArrayList<>(Arrays.asList(
            new Message(1,"Заголовок1","text1", LocalDateTime.of(2022, 1, 5, 12, 30 )),
            new Message(2, "Заголовок 2", "text2", LocalDateTime.of(2024, 4, 24, 12, 30)),
            new Message(3, "Заголовок 3", "text3", LocalDateTime.of(2024, 5, 4, 6, 00)),
            new Message(4, "Заголовок 4", "text4", LocalDateTime.of(2003, 4, 9, 18, 00))
            ));

    @GetMapping("/message")
    public Iterable<Message> getMessage() {
        return messages;
    }
    @GetMapping("/message/{id}")
    public Optional<Message> findMessagesById(@PathVariable int id) {
        return messages.stream().filter(p -> p.getId() == id).findFirst();
    }
    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message) {
        messages.add(message);
        return message;
    }
    @PutMapping("/message/{id}")
    public Message updateMessage(@PathVariable int id, @RequestBody Message message) {
        int index = - 1;
        for (Message m : messages) {
            if (m.getId() == id) {
                index = messages.indexOf(m);
                messages.set(index, message);
            }
        }
        return index == -1 ? addMessage(message) : message;
    }
    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id) {
        messages.removeIf(p -> p.getId() == id);
    }


    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {
        persons.add(person);
        return person;
    }

    @PutMapping("/person/{id}")
    public Person updatePerson(@PathVariable int id, @RequestBody Person person) {
        int index = - 1;
        for (Person p : persons) {
            if (p.getId() == id) {
                index = persons.indexOf(p);
                persons.set(index, person);
            }
        }
        return index == -1 ? addPerson(person) : person;
    }
    @GetMapping("/person")
    public Iterable<Person> getPersons() {
        return persons;
    }
    @GetMapping("/person/{id}")
    public Optional<Person> findPersonById(@PathVariable int id) {
        return persons.stream().filter(p -> p.getId() == id).findFirst();
    }
    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable int id) {
        persons.removeIf(p -> p.getId() == id);
    }


    @GetMapping
    public String hello (){
      return "Hello world!";
    }
}
