package com.example.dao;

import com.example.pojo.Txn;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TransactionDaoImpl implements TransactionDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveTransaction(final Txn txn) {
        Session session = sessionFactory.getCurrentSession();
        session.save(txn);
    }

    @Override
    public Txn getTransactionById(final long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Txn.class, id);
    }

    @Override
    public void updateCustomer(Txn txn) {
        Session session = sessionFactory.getCurrentSession();
        session.update(txn);
    }

    @Override
    public void deleteTransactionById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Txn txn = session.load(Txn.class, id);
        session.delete(txn);
        session.flush();
    }
}
