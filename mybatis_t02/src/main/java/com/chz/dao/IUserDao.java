package com.chz.dao;

import com.chz.entity.User;

import java.util.List;

public interface IUserDao {
    //查询用户
    List<User> findAll ();
    //保存用户
    void saveUser(User u);
    //更新用户
    void updateUser(User u);
    //删除用户
    void deleteUser(User u);
    //查询一行
    User findByID(int i);
    //模糊查询
    List<User> findByName(String name);
    //查询总用户数
    int findUserCount();

}
