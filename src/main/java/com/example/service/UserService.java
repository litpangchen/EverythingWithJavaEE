package com.example.service;

import com.example.dao.IUserDao;
import com.example.pojo.UserPO;

public class UserService {
    private IUserDao userDao;

    public void setUserDao(final IUserDao userDao) {
        this.userDao = userDao;
    }

    public boolean updateUserName(
            final Long userId,
            final String name) {
        UserPO userPO = userDao.getUserById(userId);
        if (userPO == null) {
            return false;
        }
        userPO.setName(name);
        return userDao.updateUser(userPO);
    }
}
