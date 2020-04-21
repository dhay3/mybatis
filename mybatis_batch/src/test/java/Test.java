import dao.BatchDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import pojo.Batch;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Test {
    private InputStream in = null;
    private SqlSession session = null;
    private BatchDao mapper = null;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlConf.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //ExecutorType.BATCH批量执行DML(只预编译一次)
        session = factory.openSession(ExecutorType.BATCH);//最好就用BATCH
        mapper = session.getMapper(BatchDao.class);
    }

    @After
    public void destroy() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    @org.junit.Test
    public void test1() {
        for (int i = 0; i < 5; i++) {
            mapper.batchInsert(new Batch("zs", i));
        }
    }

    @org.junit.Test
    public void test2() {
        ArrayList<Batch> list = new ArrayList<Batch>();
        for (int i = 0; i < 3; i++) {
            Batch batch = new Batch();
            for (int j = 0; j < 3; j++) {
                batch.setName("1");
                batch.setAge(10);
                Collections.addAll(list,batch);
            }
        }
        int i = mapper.batchForEach(list);
        System.out.println(i);
    }

}
