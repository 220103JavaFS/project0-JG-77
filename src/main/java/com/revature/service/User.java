package com.revature.service;

import java.util.ArrayDeque;
import java.util.List;

public abstract class User {

    public User(int id, String firstName, String lastName, String fullName, int dept, List<Integer> hoursWorked, String manager, ArrayDeque<String> employees) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.dept = dept;
        this.hoursWorked = hoursWorked;
        this.manager = manager;
        this.employees = employees;
    }


    //user info variables
    //essentially three tiers: employee, manager, Admin (HR) for management system app
    private int id; // unique employee id for each user (all employees)

    private String firstName;

    private String lastName;

    private String fullName = firstName+lastName;

    private int dept;

    private List<Integer> hoursWorked; //object with # of hours worked for the week

    //employees can see who their manager is
    private String manager;

    //Collection of employees in department for manager/admin to view
    private ArrayDeque<String> employees = new ArrayDeque<String>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        fullName = firstName + lastName;

        System.out.println(fullName);
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDept() {
        return dept;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }

    public List<Integer> getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(List<Integer> hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public ArrayDeque<String> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayDeque<String> employees) {
        this.employees = employees;
    }
}