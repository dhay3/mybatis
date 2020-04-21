package com.chz.test;

import com.chz.dao.IUserDao;
import com.chz.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserDao_Test {
    private InputStream in;
    private SqlSession sqlSession1;
    private SqlSession sqlSession2;
    private IUserDao userDao1;
    private IUserDao userDao2;

    @Before//在测试方法执行之前执行
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession1 = factory.openSession();
        userDao1 = sqlSession1.getMapper(IUserDao.class);//创建了一个IUserDao接口的实现类
        sqlSession2 = factory.openSession();
        userDao2 = sqlSession2.getMapper(IUserDao.class);
        System.out.println(userDao1.equals(userDao2));//false
//        自动用了字符串拼接不能这样只
//        System.out.println(userDao2==userDao+"--");
    }

    @After//在测试方法执行之后
    public void destroy() throws IOException {
        sqlSession1.commit();
        sqlSession1.close();
        in.close();
    }

    @Test
    //查询一行
    public void oneCache() {
        User user1 = userDao1.findByID(48);
        System.out.println(user1);
        //调用了commit清空了一级缓存,回调两次sql
//        sqlSession.commit();
        User user2 = userDao1.findByID(48);//对象相同只执行了一次sql
        System.out.println(user2);
//        System.out.println(user1==user2);
    }

    @Test
    public void secondCache() {
        User user1 = userDao1.findByID(48);
        System.out.println(user1);
        //清空cache二级缓存(只有是相同的namespace中调用commit才会清除二级缓存)
//        sqlSession1.commit();
        User user2 = userDao2.findByID(48);
        System.out.println(user2);
        //不同sqlSession对象同一个namespace共享二级缓存
        System.out.println(user1 == user2);
    }


}
