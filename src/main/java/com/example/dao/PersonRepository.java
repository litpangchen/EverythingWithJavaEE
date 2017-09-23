package com.example.dao;

import com.example.pojo.Person2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person2, Integer> {
    Person2 getByLastName(String lastName);
}
