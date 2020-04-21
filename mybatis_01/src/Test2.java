import dto.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("config/config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = build.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("username","小马宝莉");
//        String s = mapper.queryByProcedure(map);
//        System.out.println(s);
//        List<String> select = mapper.select("43");
//        for (String s : select) {
//            System.out.println(s);
//        }
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("1","213");
        stringStringMap.put("112","213");
        stringStringMap.put("12","213");
        System.out.println(stringStringMap);
    }
}
