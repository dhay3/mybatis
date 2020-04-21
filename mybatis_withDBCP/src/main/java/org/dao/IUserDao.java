package org.dao;

import org.dto.User;

import java.util.List;

public interface IUserDao {
    List<User> queryAll();
}
