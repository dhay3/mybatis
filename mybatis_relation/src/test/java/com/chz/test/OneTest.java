package com.chz.test;

import com.chz.entity.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class OneTest {
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession(true);
        String statement="com.chz.dao.IAccountDao.findByID";
        //可以通过单独调用莫一句sql
        Account o = session.selectOne(statement,1);
//        session.insert()
//        session.update()
//        session.delete()
        System.out.println(o);
    }
}
