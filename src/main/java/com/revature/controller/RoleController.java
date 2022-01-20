package com.revature.controller;

import com.revature.models.Roles;
import com.revature.service.RoleService;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RoleController implements Controller{

    private static Logger log = LoggerFactory.getLogger(RoleController.class);

    private RoleService roleService = new RoleService();

    Handler getRoles = (ctx) ->{
        if(ctx.req.getSession(false)!=null) { //returns session object if cookie is valid
            ctx.json(roleService.findRolesAll()); //method from roleService class
            ctx.status(200);
            log.info("Response received! All roles displayed.");
        } else {
            ctx.status(401);
            log.warn("Invalid Request sent!");
        }
    };

    Handler getRole = (ctx) -> {

        if(ctx.req.getSession(false)!=null) { //returns session object if cookie is valid
            String roleName = ctx.pathParam("roleName");
            Roles role = roleService.findRole(roleName);
            ctx.json(role);
            ctx.status(200);
            log.info("Response received! Specific role returned.");
        } else {
            ctx.status(401);
            log.warn("Invalid Request sent!");
        }

    };

    Handler updateRole = (ctx) -> {
        if(ctx.req.getSession(false)!=null) { //returns session object if cookie is valid
               Roles role = ctx.bodyAsClass(Roles.class);
            if(roleService.updateRole(role)){
                ctx.status(200);
                log.info("Response received! Role updated.");
            }else{
                ctx.status(400);
                log.warn("Invalid Request sent!");
            }
        } else {
            ctx.status(401);
            log.warn("Invalid Request sent!");
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("/role", getRoles); //GET request to see all roles
        app.get("/role/{roleName}", getRole);
        app.put("/role", updateRole);
    }


}
