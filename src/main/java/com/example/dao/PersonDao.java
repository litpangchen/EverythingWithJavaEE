package com.example.dao;

import com.example.pojo.Person;

import java.util.List;

public interface PersonDao {

    List<Person> getAllPerson();

    Person getPersonById(int id);

    void updatePersonById(Person person);

    int insertPerson(Person person);

    void removePersonById(int id);
}
