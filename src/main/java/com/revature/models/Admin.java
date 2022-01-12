package com.revature.models;

public class Admin extends Employee {

    //constructor
    public Admin() {
        super();
    }

    @Override
    public boolean isAdmin() {
        return true;
    }
}
