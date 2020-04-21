package com.chz.entity;

public class Account {
    private int ID;
    private int UID;
    private double MONEY;
    //多对一或是一对一映射,主表实体因包含从表实体的集合应用(主表是Account)
    private User user;

    public Account(int ID, int UID, double MONEY) {
        this.ID = ID;
        this.UID = UID;
        this.MONEY = MONEY;
    }

    public Account() {
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
