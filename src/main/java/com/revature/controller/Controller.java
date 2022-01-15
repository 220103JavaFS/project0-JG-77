package com.revature.controller;

import io.javalin.Javalin;

public interface Controller {

    void addRoutes(Javalin app);
}
