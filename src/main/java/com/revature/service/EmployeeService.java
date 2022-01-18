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
}
