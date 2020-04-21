package com.chz.dao;

import com.chz.entity.User;

import java.util.List;

public interface IUserDao {

    List<User>queryOne2ManyWithMap();
}
