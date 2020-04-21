package com.chz.test;

import com.chz.dao.IAccountDao;
import com.chz.entity.Account;
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
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession(true);
        accountDao= sqlSession.getMapper(IAccountDao.class);//创建了一个IUserDao接口的实现类
    }

    @After//在测试方法执行之后
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    //查询方法
    public void selectMethod() {
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("-----------");
//            System.out.println(account);//如果输出对象,对象带有懒加载中的属性,懒加载还是不会生效
            System.out.println(account.getMONEY());//懒加载生效
//            如果需要加载user的属性是就会调用懒加载配置的select
//            System.out.println(account.getUser());
            System.out.println("-----------");
        }
    }






}
