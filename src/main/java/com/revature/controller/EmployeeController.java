package com.revature.controller;

import com.revature.models.Department;
import com.revature.models.Employee;
import com.revature.service.EmployeeService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class EmployeeController implements Controller{

    private EmployeeService employeeService = new EmployeeService();

    //Handler is functional interface
    Handler getEmployees = (ctx) ->{
        //uncomment once login is encrypted
//        if(ctx.req.getSession(false)!=null) { //returns session object if cookie is valid
//
//        } else {
//            ctx.status(401);
//        }

        ctx.json(employeeService.findAllEmployees()); //method from employeeService class
        ctx.status(200);
    };

    Handler getEmployee = (ctx) ->{
        String empIDString = ctx.pathParam("empID");
        int empID = Integer.parseInt(empIDString); //taking param string and converting to integer
        Employee employee = employeeService.findEmployee(empID); //integer is passed in service method
        ctx.json(employee);
        ctx.status(200);
    };

    Handler addEmployee = (ctx) ->{
        Employee employee = ctx.bodyAsClass(Employee.class);
        if(employeeService.addEmployee(employee)){
            ctx.status(200);
        }else{
            ctx.status(400);
        }
    };

    Handler updateEmployee = (ctx) ->{
        Employee employee = ctx.bodyAsClass(Employee.class);
        if(employeeService.updateEmployee(employee)){
            ctx.status(200);
        }else{
            ctx.status(400);
        }
    };

    Handler removeEmployee = (ctx) ->{
        String empIDString = ctx.pathParam("empID"); //create id paramenter for route
        int empID = Integer.parseInt(empIDString); //taking param string and converting to integer

        if(employeeService.terminateEmployee(empID)){
            ctx.status(200);
        }else{
            ctx.status(400);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("/employee", getEmployees);
        app.get("/employee/{empID}", getEmployee);
        app.put("/employee", updateEmployee);
        app.post("/employee", addEmployee);
        app.delete("/employee/{empID}", removeEmployee);
    }
}
