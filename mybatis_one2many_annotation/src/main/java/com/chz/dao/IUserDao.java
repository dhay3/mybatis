package com.chz.dao;

import com.chz.entity.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IUserDao {

    @Select("select * from user")
    @Results(id="userMap",value={
//            如果与表的列名字一致可以不用写
//            @Result(id=true,column = "id" ,property = "id"),
//            @Result(column = "id" ,property = "id"),
//            @Result(column = "username" ,property = "username"),
//            @Result(column = "address" ,property = "address"),
//            @Result(column = "sex" ,property = "sex"),
//            @Result(column = "birthday" ,property = "birthday"),
//            一对多column就是user表中的id被当成findByID的参数被调用
            @Result(column = "id", property = "accounts"//如果是集合的话就是many
                    ,many = @Many(select = "com.chz.dao.IAccountDao.findByID",fetchType = FetchType.LAZY))
                    //等于执行多变IAccountDao中的findByID知道内有对应的
    })
    List<User> findAll ();

    @Select("select * from user where id=#{i}")
    User findByID(int i);

}
