package com.revature.controller;

import com.revature.models.UserDTO;

import com.revature.service.LoginService;
import io.javalin.Javalin;
import io.javalin.http.Handler;


public class Login implements Controller{

    LoginService loginService = new LoginService();

    private Handler loginUser = (ctx) -> {
        UserDTO user = ctx.bodyAsClass(UserDTO.class);//Data Transfer Object (DTO) --> temporary object for info

        if(loginService.loginValid(user.userName, user.empPassword)){
            ctx.req.getSession(); //create httpSession object
            ctx.status(200);
        } else{
            ctx.req.getSession().invalidate(); //closes/rejects session if invalid user credentials
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.post("/login", this.loginUser);
    }
}
