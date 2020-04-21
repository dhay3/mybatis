package dao;

import pojo.User;

import java.util.List;

public interface UserDao {
    List<User> queryAll();
    User queryById(User user);
}
