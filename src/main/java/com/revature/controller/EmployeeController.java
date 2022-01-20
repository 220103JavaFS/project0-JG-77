package com.revature.controller;

import com.revature.models.Employee;
import com.revature.service.EmployeeService;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class EmployeeController implements Controller{

    private static Logger log = LoggerFactory.getLogger(EmployeeController.class);

    private EmployeeService employeeService = new EmployeeService();

    //Handler is functional interface
    Handler getEmployees = (ctx) ->{

        if(ctx.req.getSession(false)!=null) { //returns session object if cookie is valid
            ctx.json(employeeService.findAllEmployees()); //method from employeeService class
            ctx.status(200);
            log.info("Response received! All employees in DB returned.");
        } else {
            ctx.status(401);
            log.warn("Invalid Request sent!");
        }


    };

    Handler getEmployee = (ctx) ->{
        if(ctx.req.getSession(false)!=null) { //returns session object if cookie is valid
            String empIDString = ctx.pathParam("empID");
            int empID = Integer.parseInt(empIDString); //taking param string and converting to integer
            Employee employee = employeeService.findEmployee(empID); //integer is passed in service method
            ctx.json(employee);
            ctx.status(200);
            log.info("Response received! Found the employee by ID.");
        } else {
            ctx.status(401);
            log.warn("Invalid Request sent!");
        }

    };

    Handler addEmployee = (ctx) ->{
        if(ctx.req.getSession(false)!=null) { //returns session object if cookie is valid
            Employee employee = ctx.bodyAsClass(Employee.class);
            if(employeeService.addEmployee(employee)){
                ctx.status(200);
                log.info("Response received! Employee add to the system!");
            }else{
                ctx.status(400);
            }
        } else {
            ctx.status(401);
            log.warn("Invalid Request sent!");
        }

    };

    Handler updateEmployee = (ctx) ->{
        if(ctx.req.getSession(false)!=null) { //returns session object if cookie is valid
            Employee employee = ctx.bodyAsClass(Employee.class);
            if(employeeService.updateEmployee(employee)){
                ctx.status(200);
                log.info("Response received! Employee information updated.");
            }else{
                ctx.status(400);
            }
        } else {
            ctx.status(401);
            log.warn("Invalid Request sent!");
        }

    };

    Handler removeEmployee = (ctx) ->{
        if(ctx.req.getSession(false)!=null) { //returns session object if cookie is valid
            String empIDString = ctx.pathParam("empID"); //create id parameter for route
            int empID = Integer.parseInt(empIDString); //taking param string and converting to integer

            if(employeeService.terminateEmployee(empID)){
                ctx.status(200);
                log.info("Response received! Employee removed from system database.");
            }else{
                ctx.status(400);
            }
        } else {
            ctx.status(401);
            log.warn("Invalid Request sent!");
        }

    };

    Handler findEmpInRoles = (ctx) ->{
        if(ctx.req.getSession(false)!=null) {
            String roleType = ctx.pathParam("role");
            List<Employee> employee = employeeService.findEmpInRoles(roleType);
            ctx.json(employee);
            ctx.status(200);
            log.info("Response received! Found all employees in this role.");
        } else {
            ctx.status(401);
            log.warn("Invalid Request sent!");
        }
    };

    Handler findEmpInDept = (ctx) ->{
        if(ctx.req.getSession(false)!=null) {
            String deptInt = ctx.pathParam("dept");
            int deptNum = Integer.parseInt(deptInt); //taking param string and converting to integer
            List<Employee> employee = employeeService.findEmpInDept(deptNum);
            ctx.json(employee);
            ctx.status(200);
            log.info("Response received! Found all employees in this department.");
        } else {
            ctx.status(401);
            log.warn("Invalid Request sent!");
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("/employee", getEmployees);
        app.get("/employee/{empID}", getEmployee);
        app.put("/employee", updateEmployee);
        app.post("/employee", addEmployee);
        app.delete("/employee/{empID}", removeEmployee);
        app.get("/employees/{role}", findEmpInRoles);
        app.get("/employeedept/{dept}", findEmpInDept);
    }
}
