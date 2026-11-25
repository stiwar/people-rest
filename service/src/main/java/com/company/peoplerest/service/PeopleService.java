package com.company.peoplerest.service;

import com.company.peoplerest.model.PersonDTO;

import java.util.List;

public interface PeopleService {

    List<PersonDTO> getPeople();
    PersonDTO addPerson(PersonDTO personDTO);
}
