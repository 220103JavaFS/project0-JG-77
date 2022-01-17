package com.revature.controller;

import com.revature.models.Department;
import com.revature.service.DepartmentService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class DepartmentController  implements Controller{

    private DepartmentService departmentService = new DepartmentService();

    Handler getDepts = (ctx) ->{
        //uncomment once login is encrypted
//        if(ctx.req.getSession(false)!=null) { //returns session object if cookie is valid
//
//        } else {
//            ctx.status(401);
//        }

        ctx.json(departmentService.findALLDepartments()); //method from DepartmentService class
        ctx.status(200);
    };

    Handler getOneDept = (ctx) -> {
        //uncomment once login is encrypted
//        if(ctx.req.getSession(false)!=null) { //returns session object if cookie is valid
//
//        } else {
//            ctx.status(401);
//        }
        String deptNumString = ctx.pathParam("deptNum");
        int deptNum = Integer.parseInt(deptNumString); //taking param string and converting to integer
        Department department = departmentService.findDept(deptNum); //integer is passed in service method
        ctx.json(department);
        ctx.status(200);
    };

    Handler updateDepartment = (ctx) -> {
        //uncomment once login is encrypted
//        if(ctx.req.getSession(false)!=null) { //returns session object if cookie is valid
//
//        } else {
//            ctx.status(401);
//        }
        Department department = ctx.bodyAsClass(Department.class);
        if(departmentService.updateDepartment(department)){
            ctx.status(200);
        }else{
            ctx.status(400);
        }
    };

    Handler addDepartment = (ctx) -> {
        //uncomment once login is encrypted
//        if(ctx.req.getSession(false)!=null) { //returns session object if cookie is valid
//
//        } else {
//            ctx.status(401);
//        }
        Department department = ctx.bodyAsClass(Department.class);
        if(departmentService.addDepartment(department)){
            ctx.status(200);
        }else{
            ctx.status(400);
        }
    };


    @Override
    public void addRoutes(Javalin app) {
        //dept routes
        app.get("/dept", getDepts);
        app.get("/dept/{deptNum}", getOneDept);
        app.put("/dept", updateDepartment);
        app.post("/dept", addDepartment);
    }
}
