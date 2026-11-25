package com.company.peoplerest.persistence.repository;

import com.company.peoplerest.persistence.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<Person, Integer> {
}
