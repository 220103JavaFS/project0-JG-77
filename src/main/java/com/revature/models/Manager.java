package com.revature.models;

import java.util.ArrayDeque;
import java.util.List;

public class Manager extends User {

    //constructors
    public Manager(int id, String firstName, String lastName, String fullName, int dept, List<Integer> hoursWorked, String password) {
        super(id, firstName, lastName, fullName, dept, hoursWorked, password);
    }

    public Manager() {
    }
}
