package com.example.dao;

import com.example.pojo.Book2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Repository;

@Repository
@EnableCaching
public class SimpleBookRepository implements BookRepository {
    @Override
    @Cacheable("book")
    public Book2 getById(long id) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new IllegalStateException();
        }
        return new Book2(id, "book", 10);
    }
}
