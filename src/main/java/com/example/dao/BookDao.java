package com.example.dao;

import com.example.pojo.Book;

public interface BookDao {
    Book queryById(long id);
}
