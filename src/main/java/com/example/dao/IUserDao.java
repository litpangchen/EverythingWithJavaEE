package com.example.dao;

import com.example.pojo.UserPO;

public interface IUserDao {
    Boolean updateUser(UserPO userPO);

    UserPO getUserById(Long id);
}
