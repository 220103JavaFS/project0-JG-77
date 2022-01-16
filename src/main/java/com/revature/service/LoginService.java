package com.revature.service;

import org.mindrot.jbcrypt.BCrypt;

public class LoginService {

    //logic for retrieving username and password from database
    public boolean loginValid(String userName, String passWord) {
        // BCrypt hashes a password
        String hashedPW = BCrypt.hashpw(passWord, BCrypt.gensalt());

        if (userName.equals("") && passWord.equals("")) { //figure out how to retrieve from db
            return true;
        } else {
            return false;
        }
    }

}
