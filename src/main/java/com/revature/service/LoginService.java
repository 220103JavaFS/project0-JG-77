package com.revature.service;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImp;
import org.mindrot.jbcrypt.BCrypt;

public class LoginService {

   EmployeeDAO employeeDAO = new EmployeeDAOImp();

    public boolean loginValid(String userName, String passWord) {
        // BCrypt hashes a password
        String hashedPW = BCrypt.hashpw(passWord, BCrypt.gensalt());

        String dbPassword = employeeDAO.verifyPassword(userName); //password is returned from DB

        return BCrypt.checkpw(dbPassword, hashedPW); //checking returned pw & hashed pw
    }
}
