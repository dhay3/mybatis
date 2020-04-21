package com.chz.dao;

import com.chz.entity.User;
import org.apache.ibatis.annotations.MapKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IUserDao {
    @MapKey("id")//会查询所有然后以id为key,其他字段为value返回一个map
    HashMap<Integer,User> queryByKey();

    List<User> findAll();

    User findByID(int i);

//    void insertUser(User u);
    //增删改即使mapper文件中的sql不支持返回值,增加也可以返回Integer只支持Integer或int还有boolean
    //返回int表示执行成功的行数,返回boolean只要执行成功就返回true,否则抛出异常
    Integer insertUser(User u);

    void deleteUser(User u);

    void updateUser(User u);

    void communistDie(User u);

    List<User> pollCommunist(Boolean isCommunist);

    List<User> findByUsername(User u);

    List<User> findByCascade(User u);

    //map做参数一般用String 做key,Object做value
    User findByHashMap(Map<String, Object> map);

    //存储过程没有返回值,用OUT来模拟返回值
    void queryByProcedure(Map<String, Object> map);

    //对login表操作
    void deleteByProcedure(int password);

    List<User> lazySelect();
}
