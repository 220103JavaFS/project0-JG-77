package com.revature.models;

import java.util.ArrayDeque;
import java.util.List;

public class Admin extends User {
    //constructor matching Super
    public Admin(int id, String firstName, String lastName, String fullName, int dept, List<Integer> hoursWorked, String manager, ArrayDeque<String> employees) {
        super(id, firstName, lastName, fullName, dept, hoursWorked, manager, employees, password);
    }
}
