package com.chz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 当select * 时不一定要与数据库的列一样
 *
 */

public class User implements Serializable {
    private Integer id;
    private String username;
    private String address;
    private String sex;
    private Date birthday;
    //一对多关系映射,主表实体因包含从表实体的集合应用(主表是User)
    private Boolean communist;


    public User(Integer id, String username, String address, String sex, Date birthday) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.sex = sex;
        this.birthday = birthday;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getCommunist() {
        return communist;
    }

    public void setCommunist(Boolean communist) {
        this.communist = communist;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", communist=" + communist +
                '}';
    }
}
