package com.chz.dao;

import com.chz.entity.User;

public interface IUserDao {


    User findByID(int i);
    void updateToCheck();
}
