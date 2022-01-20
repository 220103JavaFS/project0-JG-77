package com.revature;

import com.revature.controller.*;
import io.javalin.Javalin;

public class Driver {

    private static Javalin app;

    public static void main(String[] args) {
        app = Javalin.create();
        configure(new RoleController(), new DepartmentController(), new EmployeeController(), new Login()); //, new Login()

        app.start(); //Synchronously starts the application instance on the configured port
    }

    public static void configure(Controller... controllers){

        for(Controller c:controllers){
            //addRoutes() from Controller class
            c.addRoutes(app); //everything gets the app object to add routes
        }
    }
}