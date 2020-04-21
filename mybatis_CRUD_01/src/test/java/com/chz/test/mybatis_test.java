package com.chz.test;

import com.chz.dao.IUserDao;
import com.chz.entity.QueryVo;
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
import java.util.List;

public class mybatis_test {
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

        sqlSession.close();
        in.close();
    }

    @Test
    //查询方法
    public void selectMethod() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    //保存用户
    public void insetMethod() {
        User u = new User();
        u.setuName("老王八");
        u.setAddr("百老汇");
        u.setGender("女");
        u.setBirthday(new Date());
        System.out.println("保存之前:" + u);
        userDao.saveUser(u);
        System.out.println("保存之后:" + u);
    }

    @Test
    //更新用户
    public void updateMethod() {
        User u = new User();
        u.setuName("老马");
        u.setId(6);
        userDao.updateUser(u);
    }

    @Test
    //删除用户
    public void deleteMethod() {
        userDao.deleteUser(6);
    }

    @Test
    //查询一行
    public void selectByIDMethod() {
        User user = userDao.findByID(6);
        System.out.println(user);
    }

    @Test
    //模糊查询
    public void selectByNameMethod() {
        List<User> users = userDao.findByName("老%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    //查询用户人数
    public void selectUserCount() {
        int userCount = userDao.findUserCount();
        System.out.println(userCount);
    }

    //查询定义在其他类中的信息
    @Test
    public void queryVoMethod() {
        QueryVo vo = new QueryVo();
        User u = new User();
        u.setuName("李四");
        vo.setU(u);
        User user = userDao.queryVo(vo);
        System.out.println(user);

    }


}
