package com.revature.controller;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class EmployeeController implements Controller{

    //Handler is functional interface
    private Handler seeTheManager = (ctx) -> { //employee can see their manager
        //will make a call to Database
    };

    @Override
    public void addRoutes(Javalin app) {

    }
}
