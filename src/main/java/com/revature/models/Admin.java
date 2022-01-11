package com.revature.models;

import java.util.List;



public class Admin extends User {

    //constructor matching User
    public Admin(int id, String firstName, String lastName, String fullName, int dept, List<Integer> hoursWorked, String password) {
        super(id, firstName, lastName, fullName, dept, hoursWorked, password);
    }

    public Admin() {
    }

}
