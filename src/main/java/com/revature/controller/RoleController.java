package com.revature.controller;

import com.revature.models.Roles;
import com.revature.service.RoleService;
import io.javalin.Javalin;
import io.javalin.http.Handler;


public class RoleController implements Controller{

    private RoleService roleService = new RoleService();

    Handler getRoles = (ctx) ->{
        if(ctx.req.getSession(false)!=null) { //returns session object if cookie is valid
            ctx.json(roleService.findRolesAll()); //method from roleService class
            ctx.status(200);
        } else {
            ctx.status(401);
        }
    };

    Handler getRole = (ctx) -> {

        if(ctx.req.getSession(false)!=null) { //returns session object if cookie is valid
            String roleName = ctx.pathParam("roleName");
            Roles role = roleService.findRole(roleName);
            ctx.json(role);
            ctx.status(200);
        } else {
            ctx.status(401);
        }

    };

    Handler updateRole = (ctx) -> {
        if(ctx.req.getSession(false)!=null) { //returns session object if cookie is valid
               Roles role = ctx.bodyAsClass(Roles.class);
            if(roleService.updateRole(role)){
                ctx.status(200);
            }else{
                ctx.status(400);
            }
        } else {
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("/role", getRoles); //GET request to see all roles
        app.get("/role/{roleName}", getRole);
        app.put("/role", updateRole);
    }


}
