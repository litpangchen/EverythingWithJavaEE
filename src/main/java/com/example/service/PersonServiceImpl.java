package com.example.service;

import com.example.dao.PersonDao;
import com.example.pojo.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;

    public void setPersonDAO(final PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public List<Person> getAllPerson() {
        return this.personDao.getAllPerson();
    }

    @Override
    @Transactional
    public Person getPersonById(final int id) {
        return this.personDao.getPersonById(id);
    }

    @Override
    public void updatePersonById(Person person) {
        this.personDao.updatePersonById(person);
    }

    @Override
    public int insertPerson(Person person) {
        return this.personDao.insertPerson(person);
    }

    @Override
    public void removePersonById(int id) {
        this.personDao.removePersonById(id);
    }
}
