package com.revature.controller;

import com.revature.models.UserDTO;

import com.revature.service.LoginService;
import io.javalin.Javalin;
import io.javalin.http.Handler;


public class Login implements Controller{

    LoginService loginService = new LoginService();

    private Handler loginUser = (ctx) -> {
        UserDTO user = ctx.bodyAsClass(UserDTO.class);//Data Transfer Object (DTO) --> temporary object for info


    };

    @Override
    public void addRoutes(Javalin app) {

    }
}
