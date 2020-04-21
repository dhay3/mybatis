package com.chz.test;

import com.chz.dao.IAccountDao;
import com.chz.entity.Account;
import com.chz.entity.AccountUser;
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

public class Account_Test {
    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

    @Before//在测试方法执行之前执行
    public void init() throws IOException {
        //不能采用ClassPath:(web项目中采用)
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //通过该environment id指定environment
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in,test);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession(true);
        accountDao = sqlSession.getMapper(IAccountDao.class);//创建了一个IUserDao接口的实现类
    }

    @After//在测试方法执行之后
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void queryOne2OneWithExtends() {
        List<AccountUser> accountUsers = accountDao.queryOne2OneWithExtends();
        accountUsers.forEach(System.out::println);
    }

    @Test
    public void queryOne2OneWithMap() {
        List<Account> accountUsers = accountDao.queryOne2OneWithMap();
        for (Account accountUser : accountUsers) {
            System.out.println(accountUser);
            System.out.println(accountUser.getUser());
            System.out.println("--------------");
        }
    }

}
