package com.revature.dao;

import com.revature.models.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAllEmp();
    Employee findEmp(int id);
    boolean addEmp(Employee employee);
    boolean updateEmp(Employee employee);
    boolean terminateEmp(int id);
    String verifyPassword(String username);
    List <Employee> findInRoles(String role);//returns list of employees by role
    List <Employee> findInDept(int dept); //returns list of employees by role

    int getHours(String username); //retrieves current hours in DB
    boolean addHours(String username, int hours); //adds new hours with current hours to update db
}
