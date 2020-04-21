package com.chz.dao.impl;

import com.chz.dao.IUserDao;
import com.chz.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        //根据factory获取对象
        SqlSession session=factory.openSession();
        //调用session内的方法实现查询对象,参数就是配置信息的namespace+id
        List<User> list = session.selectList("com.chz.dao.IUserDao.findAll");
        session.close();
        return list;
    }

    public void saveUser(User u) {
        SqlSession session = factory.openSession();
        session.insert("com.chz.dao.IUserDao.saveUser",u);//一定要
        session.commit();
        session.close();
    }

    public void updateUser(User u) {
        SqlSession session = factory.openSession();
        session.insert("com.chz.dao.IUserDao.updateUser",u);
        session.commit();
        session.close();
    }

    public void deleteUser(User u) {
        SqlSession session = factory.openSession();
        session.delete("com.chz.dao.IUserDao.deleteUser",u);
        session.commit();
        session.close();

    }

    public User findByID(int i) {
        SqlSession session = factory.openSession();
        User u = session.selectOne("com.chz.dao.IUserDao.findByID", i);
        return u;
    }

    public List<User> findByName(String name) {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.chz.dao.IUserDao.findByName", name);//一定要
        return users;
    }

    public int findUserCount() {
        return 0;
    }
}
