package com.example.dao;

import com.example.pojo.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements PersonDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Person getPersonById(final int id) {
        Session session = this.sessionFactory.openSession();
        Person person = session.get(Person.class, id);
        session.close();
        return person;
    }

    @Override
    public void removePersonById(final int id) {
        
    }
}
