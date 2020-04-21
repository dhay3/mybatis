package com.chz.entity;

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
