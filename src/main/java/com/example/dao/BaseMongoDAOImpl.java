package com.example.dao;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BaseMongoDAOImpl<T> implements BaseMongoDAO<T> {
    @Override
    public List<T> find(Query query) {
        return null;
    }
}
