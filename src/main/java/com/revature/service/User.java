package com.revature.service;

public class User {
//    user info variables
    private int id;

    private String firstName;

    private String lastName;

    private int dept;

    private List<Integer> hoursWorked; //object with # of hours worked for the week

    //employees can see who their manager is
    private String manager;

    //Collection of employees in department for manager/admin to view
    private ArrayDeque<String> employees = new ArrayDeque<String>;
}