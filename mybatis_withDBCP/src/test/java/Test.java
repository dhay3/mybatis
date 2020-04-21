import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.dao.IUserDao;
import org.dto.User;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    InputStream is = null;
    SqlSession session = null;
    IUserDao userDao = null;

    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        session = factory.openSession(true);
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        if (session != null) session.close();
        if (is != null) is.close();
    }
    @org.junit.Test
    public void queryAll(){
        List<User> users = userDao.queryAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
