package com.revature.controller;

import com.revature.service.RoleService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class RoleController implements Controller{

    private RoleService roleService = new RoleService();

    Handler getRoles = (ctx) ->{
        //uncomment once login is encrypted
//        if(ctx.req.getSession(false)!=null) { //returns session object if cookie is valid
//
//        } else {
//            ctx.status(401);
//        }

        ctx.json(roleService.findRolesAll()); //method from roleService class
        ctx.status(200);
    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("/role", getRoles); //GET request to see all roles
    }


}
