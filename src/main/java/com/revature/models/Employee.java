package com.revature.models;

import java.util.Objects;

public class Employee {
    //constructors


    public Employee(String name, String userName, String password, int department, int hoursWorked, Manager manager, Admin admin) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.department = department;
        this.hoursWorked = hoursWorked;
        this.manager = manager;
        this.admin = admin;
    }

    public Employee() {
    }

    //fields for all employees
    private String name;

    private String userName;

    private String password;

    private int department;

    private int hoursWorked;

    private Manager manager;

    private Admin admin;


    //getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    //equals and hashCode methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getDepartment() == employee.getDepartment() && getHoursWorked() == employee.getHoursWorked() && Objects.equals(getName(), employee.getName()) && Objects.equals(getUserName(), employee.getUserName()) && Objects.equals(getPassword(), employee.getPassword()) && Objects.equals(getManager(), employee.getManager()) && Objects.equals(getAdmin(), employee.getAdmin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getUserName(), getPassword(), getDepartment(), getHoursWorked(), getManager(), getAdmin());
    }

    //toString()

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", department=" + department +
                ", hoursWorked=" + hoursWorked +
                ", manager=" + manager +
                ", admin=" + admin +
                '}';
    }
}
