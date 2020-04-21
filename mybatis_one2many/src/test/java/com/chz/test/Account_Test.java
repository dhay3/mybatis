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
import java.util.Map;

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
        //true开启自动事务提交
        sqlSession = factory.openSession(true);
        accountDao = sqlSession.getMapper(IAccountDao.class);//创建了一个IUserDao接口的实现类
    }

    @After//在测试方法执行之后
    public void destroy() throws IOException {
//        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void lazySelect() {
        List<Account> accounts = accountDao.lazySelect();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void queryReturnHashMap() {
        //HashMap的形式只返回一行
        Map<String, Object> map = accountDao.queryReturnHashMap(1);
//        Object m = map.get("m");
//        Object id = map.get("id");
//        System.out.println(id+"------"+m);
        System.out.println(map);

    }

    @Test
    public void queryReturnHashMaps() {
        //返回多个map
        List<Map<String, Object>> maps = accountDao.queryReturnHashMaps();
        maps.forEach(System.out::println);

    }

    @Test
    //查询方法
    public void selectMethod() {
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("-----------");
            System.out.println(account);
            System.out.println(account.getUser());
            System.out.println("-----------");
        }
    }

    @Test

    public void selectByIDMethod() {
        Account account = accountDao.findByID(2);
        System.out.println("----");
        System.out.println(account);
    }

    @Test
    public void selectByTwoArgs() {
        Account account = accountDao.findByTwoArgs(2, 1200);
        System.out.println(account);
    }

    @Test
    public void orderByMoney() {
        List<Account> accounts = accountDao.orderByColumn("money");
        for (Account account : accounts) {
            System.out.println(account);
        }

    }

    @Test
    public void selectInfo() {
        List<AccountUser> info = accountDao.findInfo();
        for (AccountUser accountUser : info) {
            System.out.println(accountUser);
        }
    }

    @Test
    public void insertUser() {
//        Account account = new Account(4, 43, 3000);
        Account account = new Account(45,3000);
        Integer integer = accountDao.insertAccount(account);
        //拿到回写的主键
        System.out.println(account.getID());
        System.out.println("添加成功");
    }

    @Test
    public void deleteUser() {
        Account account = new Account();
        account.setID(4);
        accountDao.deleteAccount(account);
        System.out.println("删除成功");
    }

    @Test
    public void updateUser() {
        Account account = new Account();
        account.setID(3);
        account.setMONEY(500);
        accountDao.updateAccount(account);
    }


}
