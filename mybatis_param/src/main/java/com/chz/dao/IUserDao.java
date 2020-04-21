package com.chz.dao;

import com.chz.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
//想让mapper中以指定的参数名显示使用@param
public interface IUserDao {
    //通过接口中的@Param来指定mapper中接收的参数,如果不写可以就要采用arg或param
    User queryByArgs(@Param("un")String username,@Param("psd")String password);
    //当参数时包装类和普通类型时,mapper文件中不需要指明parameterType
    @Select
    ("select * from user where username=#{user.username} and password=#{user.password} and no=#{no}")
    User queryByRefAndArg(@Param("user") User user,@Param("no") int no);
}
