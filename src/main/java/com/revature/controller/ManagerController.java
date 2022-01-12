package com.revature.controller;

import io.javalin.http.Handler;

public class ManagerController {
    //Handler is functional interface
    private Handler getDeptEmployees = (ctx) -> { //managers can see their employees in dept
        //will make a call to Database
    };
}
