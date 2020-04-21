package com.chz.dao;

import com.chz.entity.Role;

import java.util.List;

public interface IRoleDao {
    //查询所有角色
    List<Role> selectRole();

}
