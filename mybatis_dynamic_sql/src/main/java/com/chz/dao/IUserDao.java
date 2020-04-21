package com.chz.dao;

import com.chz.entity.User;

import java.util.List;

public interface IUserDao {
    List<User> queryUserByIf(User u);

    List<User> queryUserByChoose(User u);

    List<User> queryUserByWhere(User u);

    void updateBySet(User u);

    //传入一个数组用foreach遍历
    List<User> queryByForeach(List<Integer> list);
}
