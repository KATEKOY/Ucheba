package com.example.person.controller;
import com.example.person.model.Location;
import com.example.person.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationRepository locationRepository;

    @GetMapping
    public Iterable<Location> findAll() {
        return locationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Location> findById(@PathVariable int id) {
        return locationRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<Location> save(@RequestBody Location location) {
        return locationRepository.findById(location.getId()).isPresent()
                ? new ResponseEntity(locationRepository.findById(location.getId()), HttpStatus.BAD_REQUEST)
                : new ResponseEntity(locationRepository.save(location), HttpStatus.CREATED);
    }
}