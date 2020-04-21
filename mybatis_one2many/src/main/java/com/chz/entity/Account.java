package com.chz.entity;

import java.io.Serializable;

//二级缓冲结果有关的类要实现序列化接口
public class Account implements Serializable {
    private int ID;
    private int UID;
    private double MONEY;
    //多对一关系映射,主表实体因包含从表实体的集合应用(主表是Account)
    private User user;

    public Account(int ID, int UID, double MONEY) {
        this.ID = ID;
        this.UID = UID;
        this.MONEY = MONEY;
    }

    public Account(int UID, double MONEY) {
        this.UID = UID;
        this.MONEY = MONEY;
    }

    public Account() {
    }

    public Account(double MONEY) {
        this.MONEY = MONEY;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public double getMONEY() {
        return MONEY;
    }

    public void setMONEY(double MONEY) {
        this.MONEY = MONEY;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ID=" + ID +
                ", UID=" + UID +
                ", MONEY=" + MONEY +
                '}';
    }
}
