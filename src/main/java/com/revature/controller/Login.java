package com.revature.controller;

import com.revature.models.UserDTO;
import com.revature.service.EmployeeService;
import com.revature.service.LoginService;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Login implements Controller{

    private static Logger log = LoggerFactory.getLogger(Login.class);

    LoginService loginService = new LoginService();
    EmployeeService employeeService = new EmployeeService();

    private Handler loginUser = (ctx) -> {
        UserDTO user = ctx.bodyAsClass(UserDTO.class);//Data Transfer Object (DTO) --> temporary object for info

        if(loginService.loginValid(user.userName, user.empPassword)){

            ctx.req.getSession().getAttribute("role"); //create httpSession object
            ctx.status(200);
            log.info("Login Successful!");

        } else{
            ctx.req.getSession().invalidate(); //closes/rejects session if invalid user credentials
            ctx.status(401);
            log.warn("Invalid login attempt!");
        }
    };

    private Handler logoutUser = (ctx) -> {
        ctx.req.getSession().invalidate();
        ctx.status(200);
        log.info("Logout Successful!");
    };


    @Override
    public void addRoutes(Javalin app) {
        app.post("/login", this.loginUser);
        app.post("/logout", logoutUser);
    }
}
