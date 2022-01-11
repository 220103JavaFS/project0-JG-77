package com.revature.models;

import java.util.ArrayDeque;
import java.util.List;

public class Employee extends User {

    public Employee(int id, String firstName, String lastName, String fullName, int dept, List<Integer> hoursWorked, String manager, ArrayDeque<String> employees) {
        super(id, firstName, lastName, fullName, dept, hoursWorked, manager, employees, password);
    }

    public static void addHours(){ //function for employees in add daily hours worked
        addHours();
    }
}
