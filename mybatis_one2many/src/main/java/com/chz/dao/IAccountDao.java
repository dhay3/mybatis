package com.chz.dao;

import com.chz.entity.Account;
import com.chz.entity.AccountUser;
import org.apache.ibatis.annotations.Options;

import java.util.List;
import java.util.Map;

public interface IAccountDao {
    //    将结果封装到map中
    Map<String, Object> queryReturnHashMap(int i);

    //返回多个map
    List<Map<String, Object>> queryReturnHashMaps();

//    @Options(useGeneratedKeys = true, keyProperty = "id")
    List<Account> findAll();

    Account findByID(int i);

    List<Account> findByUid(int i);

    List<AccountUser> findInfo();

    Account findByTwoArgs(int i, int j);
//    多个参数时也可以通过@Param()来参数修正sql语句中的arg或是param
//    Account findByTwoArgs(@Param("param") int i, int j);

    Integer insertAccount(Account a);

    void deleteAccount(Account a);

    void updateAccount(Account a);

    List<Account> orderByColumn(String column);

    List<Account> lazySelect();
}
