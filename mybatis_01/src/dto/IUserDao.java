package dto;

import java.util.List;
import java.util.Map;

public interface IUserDao {
    String queryByProcedure(Map<String,Object> map);
    List<String> select(String s);
}
