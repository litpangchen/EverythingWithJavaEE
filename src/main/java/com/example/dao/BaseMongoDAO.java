package com.example.dao;

import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public interface BaseMongoDAO<T> {
    List<T> find(Query query);
}
