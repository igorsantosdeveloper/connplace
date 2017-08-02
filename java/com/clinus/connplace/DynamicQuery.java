package com.clinus.connplace;

public class DynamicQuery {

    private String forwardListOfUsers;

    public DynamicQuery() {
    }

    public DynamicQuery(String forwardListOfUsers) {
        this.forwardListOfUsers = forwardListOfUsers;
    }

    public String getForwardListOfUsers() {
        return forwardListOfUsers;
    }

    public void setForwardListOfUsers(String forwardListOfUsers) {
        this.forwardListOfUsers = forwardListOfUsers;
    }
}
