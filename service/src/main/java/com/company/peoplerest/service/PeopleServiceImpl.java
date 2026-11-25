package com.company.peoplerest.service;

import com.company.peoplerest.model.PersonDTO;
import com.company.peoplerest.persistence.entity.Person;
import com.company.peoplerest.persistence.repository.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleServiceImpl implements  PeopleService {

    private final PeopleRepository repository;

    public PeopleServiceImpl(PeopleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PersonDTO> getPeople() {
        return repository.findAll().stream()
                         .map(this::buildPersonDto)
                         .toList();
    }

    @Override
    public PersonDTO addPerson(PersonDTO personDTO) {
        return buildPersonDto(repository.save(buildPerson(personDTO)));
    }

    private PersonDTO buildPersonDto(Person person) {
        return new PersonDTO(person.getId(), person.getName(), person.getLastName());
    }

    private Person buildPerson(PersonDTO personDTO) {
        return new Person(personDTO.name(), personDTO.lastName());
    }
}
