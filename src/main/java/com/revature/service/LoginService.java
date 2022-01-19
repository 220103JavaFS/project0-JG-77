package com.revature.service;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImp;
import org.mindrot.jbcrypt.BCrypt;

public class LoginService {

   EmployeeDAO employeeDAO = new EmployeeDAOImp();

    //logic for retrieving username and password from database
    public boolean loginValid(String userName, String passWord) {
        // BCrypt hashes a password
        String hashedPW = BCrypt.hashpw(passWord, BCrypt.gensalt());

        System.out.println(hashedPW);
        System.out.println("---------------------------");

        employeeDAO.verifyPassword(userName, hashedPW);
        String dbPassword = employeeDAO.verifyPassword(userName, hashedPW);

        System.out.println(dbPassword);
        return BCrypt.checkpw(passWord, dbPassword);
    }
}
