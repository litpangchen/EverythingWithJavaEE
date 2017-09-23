package com.example.dao;

import com.example.pojo.Book2;

public interface BookRepository {
    Book2 getById(long id);
}
