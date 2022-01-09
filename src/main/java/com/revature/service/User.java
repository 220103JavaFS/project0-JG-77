package com.revature.service;

public class User {
    //user info variables
    //essentially three tiers: employee, manager, Admin (HR) for management system app
    private int id; // unique employee id for each user (all employees)

    private String firstName;

    private String lastName;

    private fullName;

    public String getFullName() {
        fullName = firstName + lastName;

        System.out.println(fullname);
        return fullName;
    }

    private int dept;

    private List<Integer> hoursWorked; //object with # of hours worked for the week

    //employees can see who their manager is
    private String manager;

    //Collection of employees in department for manager/admin to view
    private ArrayDeque<String> employees = new ArrayDeque<String>;
}