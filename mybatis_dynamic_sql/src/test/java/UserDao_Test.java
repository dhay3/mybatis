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
import java.util.ArrayList;
import java.util.Collections;
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
    public void queryUserByIdOrSex() {
        User user = new User();
        user.setUsername("老王");
        user.setId(46);
        List<User> users = userDao.queryUserByIf(user);
        users.forEach(System.out::println);
    }

    @Test
    public void queryUserByChoose() {
        User user = new User();
//        user.setUsername("老王");
//        user.setSex("女");
        user.setId(41);
        List<User> users = userDao.queryUserByChoose(user);
        users.forEach(System.out::println);
    }

    @Test
    public void queryUserByWhere() {
        User user = new User();
        user.setId(41);
        List<User> users = userDao.queryUserByWhere(user);
        users.forEach(System.out::println);
    }

    @Test
    public void updateBySet() {
        User user = new User();
//        user.setUsername("王翠花");
        user.setSex("男");
        user.setId(41);
        userDao.updateBySet(user);
    }

    @Test
    public void queryByForeach(){
        List<Integer> ids = new ArrayList<>();
        Collections.addAll(ids,41,42,45);
        List<User> users = userDao.queryByForeach(ids);
        users.forEach(System.out::println);
    }

}
