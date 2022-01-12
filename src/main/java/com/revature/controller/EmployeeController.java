package com.revature.controller;

import io.javalin.http.Handler;

public class EmployeeController {

    //Handler is functional interface
    private Handler seeTheManager = (ctx) -> { //employee can see their manager
        //will make a call to Database
    };
}
