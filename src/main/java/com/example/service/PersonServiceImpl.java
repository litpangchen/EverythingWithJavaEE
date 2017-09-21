package com.example.service;

import com.example.dao.PersonDao;
import com.example.pojo.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;

    public void setPersonDAO(final PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    @Transactional
    public Person getPersonById(final int id) {
        return this.personDao.getPersonById(id);
    }
}
