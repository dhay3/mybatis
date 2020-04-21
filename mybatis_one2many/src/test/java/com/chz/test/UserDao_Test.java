package com.chz.test;

import com.chz.dao.IUserDao;
import com.chz.entity.Address;
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
import java.util.Date;
import java.util.HashMap;
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
    public void queryByKey() {
        HashMap<Integer, User> integerUserHashMap = userDao.queryByKey();
        System.out.println(integerUserHashMap);
    }

    @Test
    public void lazySelect() {
        List<User> users = userDao.lazySelect();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void postCommunist() {
        User user = new User();
        user.setUsername("ccp");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("peking");
        user.setCommunist(true);
        userDao.communistDie(user);
        System.out.println("poll the fucking communist");
    }

    @Test
    public void pollCommunist() {
        List<User> users = userDao.pollCommunist(true);
        for (User user : users) {
            System.out.println("executed !!!");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void selectMethod() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("-----------------------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test//模糊查询
    public void finByUsername() {
        User user = new User();
//        user.setUsername("%小%");
        user.setUsername("小");
        List<User> byUsername = userDao.findByUsername(user);
        for (User user1 : byUsername) {
            System.out.println(user1);
        }
    }

    @Test
    public void cascadeSelect() {
        Address address = new Address();
        address.setHomeAddress("北京");
        User user = new User();
        user.setAddressBean(address);
        List<User> byCascade = userDao.findByCascade(user);
        for (User user1 : byCascade) {
            System.out.println(user1);
        }
    }

    @Test
    public void findByHashMap() {
        HashMap<String, Object> map = new HashMap<>();
        //对应mapper中sql的参数
        map.put("usernameK", "小马宝莉");
        map.put("sexK", "女");
        User byHashMap = userDao.findByHashMap(map);
        System.out.println(byHashMap);
    }

    @Test
    public void queryByProcedure() {
        HashMap<String, Object> map = new HashMap<>();
        //指定存储过程的IN参数
        map.put("isCommunistK", true);
        //调用存储过程并输入参数
//        int i = userDao.queryByProcedure(map);//这表示执行了几行(并不是procedure的返回值)
        userDao.queryByProcedure(map);
        //获取存储过程的OUT值
        Object count = map.get("countK");
        System.out.println("There is " + count + " communist!");
    }

    @Test
    public void findById() {
        User user = userDao.findByID(41);
        System.out.println(user);
    }

    @Test
    public void insertMethod() {
        User user = new User(100, "赵四", "南京", "男", new Date());
        //返回Integer
        Integer integer = userDao.insertUser(user);
        System.out.println(integer);
        System.out.println("添加成功");
    }

    @Test
    public void deleteByProcedure() {
        //这个是对login表操作的,因为user表有外键
        userDao.deleteByProcedure(111);
        System.out.println("executed ---------");
    }

    @Test
    public void deleteMethod() {
        User user = new User();
        user.setAddress("南京");
        userDao.deleteUser(user);
        System.out.println("删除成功");
    }

    @Test
    public void updateMethod() {
        User user = new User();
        user.setAddress("彩虹桥");
        user.setUsername("小马宝莉");
        userDao.updateUser(user);
        System.out.println("修改成功");
    }
}
