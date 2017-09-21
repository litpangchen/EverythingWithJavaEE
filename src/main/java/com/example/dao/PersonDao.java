package com.example.dao;

import com.example.pojo.Person;

public interface PersonDao {
    Person getPersonById(int id);
    void removePersonById(int id);
}
