package com.chz.dao;

import com.chz.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 在mybatis 中针对CRUD一共有四个注释
 * @select @insert @delete @update
 */
public interface IUserDao {
    @Select("select * from user")
    List<User> findAll();
    @Insert("insert into user (username,birthday,sex,address) values (#{username},#{birthday},#{sex},#{address})")
    void insertUser(User u);
    @Delete("delete from user where id=#{id}")
    void deleteUser(int i);
}
