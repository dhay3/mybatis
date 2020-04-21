package dao;

import pojo.User;

import java.util.List;

public interface IUserDao {
    List<User> queryAll();
}
