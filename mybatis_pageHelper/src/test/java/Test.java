import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    private InputStream in = null;
    private SqlSession session = null;
    private UserDao mapper = null;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlConf.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //ExecutorType.BATCH批量执行DML(只预编译一次)
        session = factory.openSession(ExecutorType.BATCH);//最好就用BATCH
        mapper = session.getMapper(UserDao.class);
    }

    @After
    public void destroy() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    @org.junit.Test
    public void queryByPageHelper() {
        //pageNum是第几页,pageSize是查看的条数,page存储了信息
        Page<Object> page = PageHelper.startPage(0, 3);
        List<User> users = mapper.queryAllByPageHelper();
        users.forEach(System.out::println);
        System.out.println("当前页" + page.getPageNum());
        System.out.println("页面大小" + page.getPageSize());
        System.out.println("总页数" + page.getPages());
        System.out.println("总数据量" + page.getTotal());
    }
    @org.junit.Test//lambda表达式分页推荐
    public void queryByPageHelperLambda() {
        //返回的page就相当于分页
        Page<Object> page = PageHelper.startPage(2, 3).
                doSelectPage(mapper::queryAllByPageHelper);
        page.forEach(System.out::println);
        //获取PageInfo需要将sql返回的结果传入
        PageInfo<Object> info = new PageInfo<>(page);
//        info.getPrePage()
    }
}
