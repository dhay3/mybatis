import com.chz.dao.IRoleDao;
import com.chz.entity.Role;
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

public class RoleTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IRoleDao roleDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlSessionMap.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession(true);
        roleDao = sqlSession.getMapper(IRoleDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void selectMethod(){
        List<Role> roles = roleDao.selectRole();
        for (Role role : roles) {
            System.out.println("---每个角色的信息---");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }


}
