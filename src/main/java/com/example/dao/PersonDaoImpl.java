package com.example.dao;

import com.example.pojo.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PersonDaoImpl implements PersonDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Person> getAllPerson() {
        Session session = this.sessionFactory.openSession();
        List<Person> persons =
                (List<Person>) session.createQuery("from Person").list();
        session.close();
        return persons;
    }

    @Override
    public Person getPersonById(final int id) {
        Session session = this.sessionFactory.openSession();
        Person person = session.get(Person.class, id);
        session.close();
        return person;
    }

    @Override
    public void updatePersonById(final Person person) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Person personFound = session.load(Person.class, person.getId());
        personFound.setName(person.getName());
        personFound.setCountry(person.getCountry());
        session.update(personFound);
        session.flush();
        transaction.commit();
        session.close();
    }

    @Override
    public int insertPerson(final Person person) {
        Session session = sessionFactory.openSession();
        int id = (Integer) session.save(person);
        session.close();
        return id;
    }

    @Override
    @Transactional
    public void removePersonById(final int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete Person where id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        if (result > 0) {
            System.out.println("Person id " + id + " was removed");
        }
        transaction.commit();
        session.close();

    }
}
