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
import java.util.Date;
import java.util.List;

public class test {
    InputStream in;
    SqlSession session;
    IUserDao userDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession(true);
        userDao = session.getMapper(IUserDao.class);
    }
    @After
    public void destroy() throws IOException {
        session.close();
        in.close();
    }
    @Test
    public void selectMethod(){
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void insertMethod(){
        User u = new User();
        u.setUsername("五四二");
        u.setBirthday(new Date());
        u.setSex("男");
        u.setAddress("ssss");
        userDao.insertUser(u);
    }
    @Test
    public void deleteMethod(){
        userDao.deleteUser(49);
    }
}
