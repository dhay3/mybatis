package com.chz.dao;

import com.chz.entity.Account;
import com.chz.entity.AccountUser;

import java.util.List;

public interface IAccountDao {
    List<AccountUser> queryOne2OneWithExtends();
    List<Account> queryOne2OneWithMap();
}
