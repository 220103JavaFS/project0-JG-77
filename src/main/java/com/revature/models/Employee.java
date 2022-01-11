package com.revature.models;

import java.util.List;

public class Employee extends User {

    //constructors
    public Employee(int id, String firstName, String lastName, String fullName, int dept, List<Integer> hoursWorked, String manager, String password) {
        super(id, firstName, lastName, fullName, dept, hoursWorked, password);
    }

    public Employee() {
    }

    //Manager variable

    public static void addHours(){ //function for employees in add daily hours worked
        addHours();
    }
}
