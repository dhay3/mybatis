import dao.AccountDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlConf.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession(true);
//        UserDao mapper = session.getMapper(UserDao.class);
//        List<User> users = mapper.queryAll();
//        for (User user : users) {
//            System.out.println(user);
//        }
        AccountDao mapper = session.getMapper(AccountDao.class);
        System.out.println(mapper.queryById(45));
//        System.out.println(session.getMapper(AccountDao.class).queryById(41));
    }
}
