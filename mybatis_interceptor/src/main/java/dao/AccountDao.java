package dao;

import pojo.Account;

public interface AccountDao {
    Account queryById(Integer uid);
}
