package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    public static Connection getConnection() throws SQLException {
         //register the JDBC Driver
        try {
            Class.forName("org.postgres.Driver");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        //contains DB endpoint, port # and DB name
        String url = "jdbc:postgresql://javafs220103.cbcrwq0mor94.us-east-1.rds.amazonaws.com:5432/employee_db";
        String username = System.getenv("SQLUsername");//hidden in environment variables
        String password = System.getenv("SQLPassword");//Run --> Edit Config.

        return DriverManager.getConnection(url, username, password);
    }

}
