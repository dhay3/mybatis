package com.chz.entity;

/**
 *业务扩展类,简单的逻辑扩展可以采用该方法
 * 一对一或是多对一可以采用继承其中一方,重写另一方的属性(一般来说继承属性多的一个类,重写属性少的类,一对多可以添加一个集合属性)
 */
public class AccountUser extends Account {
    private String username;
    private String address;

    @Override
    //打印自己本身得同时打印父类得toString方法
    public String toString() {
        return super.toString() + "   " + "AccountUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
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
}
