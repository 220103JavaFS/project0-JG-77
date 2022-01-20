package com.revature.service;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImp;
import com.revature.models.Employee;
import java.util.List;

public class EmployeeService {

    EmployeeDAO employeeDAO = new EmployeeDAOImp();

    public List<Employee> findAllEmployees(){
        return employeeDAO.findAllEmp();
    }

    public Employee findEmployee(int id){
        return employeeDAO.findEmp(id);
    }

    public boolean addEmployee(Employee employee){
        return employeeDAO.addEmp(employee);
    }

    public boolean updateEmployee(Employee employee){
        return employeeDAO.updateEmp(employee);
    }

    public boolean terminateEmployee(int id){
        return employeeDAO.terminateEmp(id);
    }

    public List<Employee> findEmpInRoles(String role){
        return employeeDAO.findInRoles(role);
    };

    public List<Employee> findEmpInDept(int dept){
        return employeeDAO.findInDept(dept);
    }

    public int getEmpHours(String username){ //using 2 methods to add hours and update
        return  employeeDAO.getHours(username);
    }
    public boolean addEmpHours(String username, int hours){ //send in username & hours

        int previousHours = getEmpHours(username); //call getEmpHours to get hours already stored in db
        int combinedHours = previousHours + hours; //add hours together & send to update db
        return  employeeDAO.addHours(username, combinedHours);//passing in username with total hours
    }
}
