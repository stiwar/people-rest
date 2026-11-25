package com.company.peoplerest.controller;

import com.company.peoplerest.model.PersonDTO;
import com.company.peoplerest.service.PeopleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService service;

    public PeopleController(PeopleService service) {
        this.service = service;
    }

    @GetMapping
    public List<PersonDTO> getPeople() {
        return service.getPeople();
    }

    @PostMapping
    public PersonDTO savePerson(@RequestBody PersonDTO personDTO) {
        return service.addPerson(personDTO);
    }
}
