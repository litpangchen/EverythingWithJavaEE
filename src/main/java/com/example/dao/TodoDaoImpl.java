package com.example.dao;

import com.example.pojo.Todo;
import org.springframework.stereotype.Repository;

@Repository
public class TodoDaoImpl extends BaseMongoDAOImpl<Todo> implements TodoDao {

}
