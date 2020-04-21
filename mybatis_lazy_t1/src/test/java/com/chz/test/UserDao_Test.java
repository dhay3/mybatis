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
import java.util.List;

public class UserDao_Test {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before//在测试方法执行之前执行
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession(true);
        userDao = sqlSession.getMapper(IUserDao.class);//创建了一个IUserDao接口的实现类
    }

    @After//在测试方法执行之后
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    //查询一行
    public void selectByIDMethod() {
        User user = userDao.findByID(48);
        System.out.println(user);
    }

    @Test
    public void lazySelect(){
        List<User> users = userDao.lazySelect();
        for (User user : users) {
//            System.out.println(user.getAccounts());
            System.out.println(user.getSex());
//            List<Account> accounts = user.getAccounts();
//            for (Account account : accounts) {
//                System.out.println(account);
//            }
        }
    }

}
