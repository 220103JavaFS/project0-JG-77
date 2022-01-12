package com.revature.models;


public class Manager extends Employee{
    //Constructors
//    public Manager(String name, String userName, String password, int department, int hoursWorked, boolean isManager, boolean isAdmin) {
//        super(name, userName, password, department, hoursWorked, isManager, isAdmin);
//    }

    public Manager() {
    }

    @Override
    public boolean isManager() {
        return true;
    }
}
