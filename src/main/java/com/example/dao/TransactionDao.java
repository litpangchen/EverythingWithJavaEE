package com.example.dao;

import com.example.pojo.Txn;

public interface TransactionDao {
    void saveTransaction(Txn txn);

    Txn getTransactionById(long id);

    void updateCustomer(Txn txn);

    void deleteTransactionById(long id);
}
