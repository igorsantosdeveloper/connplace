package com.clinus.connplace;

public class ForwardListOfUsers {

    private String nameUser;

    public ForwardListOfUsers() {}

    public ForwardListOfUsers(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    @Override
    public String toString() {
        return "ForwardListOfUsers{" +
                "nameUser='" + nameUser + '\'' +
                '}';
    }
}
