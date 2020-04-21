package dao;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;

public interface UserDao {
    List<User> queryAll();
    User queryById(@Param("id") int i);
}
