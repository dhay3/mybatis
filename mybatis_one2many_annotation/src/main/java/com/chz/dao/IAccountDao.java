package com.chz.dao;

import com.chz.entity.Account;
import com.chz.entity.AccountUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Results 不能直接用要与@select一起使用,@ResultMap以用@Results,
 * 如果列名与属性名相同时可以不用写,但是如果是mapper文件的话即使相同也必须写出
 */
public interface IAccountDao {

    @Select("select * from account")
    //当表中字段名与实体类的成员变量名不同时用@Results指定,名字相同的可以省略
    @Results(id = "accountMap", value = {
            @Result(id = true, property = "ID", column = "aid"),
            @Result(property = "UID", column = "uid"),
            @Result(property = "MONEY", column = "money"),
//            column是另外一张表的外键
            @Result(property = "user", column = "UID"//参数等于
                    , one = @One(select = "com.chz.dao.IUserDao.findByID", fetchType = FetchType.LAZY))
            //就是等于执行Account的findAll执行一遍IUserDao中的findByID
    })
    List<Account> findAll();

    @Select("select * from account where uid=#{i}")
            //通过@ResultMap重复调用指定的@Results
//    @ResultMap("accountMap")
//调用配置好的map
    Account findByID(@Param("i") int i);

    List<AccountUser> findInfo();
}
