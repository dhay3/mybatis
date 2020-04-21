package com.chz.dao;

import com.chz.entity.User;

import java.util.List;

public interface IUserDao {


    User findByID(int i);
    List<User> lazySelect ();


}
