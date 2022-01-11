package com.revature.models;

import java.util.ArrayDeque;
import java.util.List;

public class Manager extends User {
    //constructor
    public Manager(int id, String firstName, String lastName, String fullName, int dept, List<Integer> hoursWorked, String manager, ArrayDeque<String> employees) {
        super(id, firstName, lastName, fullName, dept, hoursWorked, manager, employees, password);
    }
}
