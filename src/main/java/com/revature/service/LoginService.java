package com.revature.service;

import com.revature.models.Employee;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {

    //logic for retrieving username and password from database
    public boolean loginValid(String userName, String passWord) {
        // BCrypt hashes a password
        String hashedPW = BCrypt.hashpw(Employee.getEmpPassword(), BCrypt.gensalt()); //pw variable & getter made static

        if (BCrypt.checkpw(passWord, hashedPW)) {
//            if (userName.equals(Employee.getUserName()) && passWord.equals(Employee.getEmpPassword())) { //figure out how to retrieve from db
//                return true;
//            }
            return true;
        }else {
            return false;
        }
    }

    //figure out error
}
