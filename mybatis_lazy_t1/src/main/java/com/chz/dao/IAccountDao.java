package com.chz.dao;

import com.chz.entity.Account;
import com.chz.entity.AccountUser;

import java.util.List;

public interface IAccountDao {

    List<Account> findAll();
    Account findByID(int i);
}
