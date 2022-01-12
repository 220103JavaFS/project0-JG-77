package com.revature.models;

import java.util.Objects;

public class Employee {
    //constructors
    public Employee(String name, String userName, String password, int department, int hoursWorked, boolean isManager, boolean isAdmin) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.department = department;
        this.hoursWorked = hoursWorked;
        this.isManager = isManager;
        this.isAdmin = isAdmin;
    }

    public Employee() {
    }

    //fields for all employees
    private String name;

    private String userName;

    private String password;

    private int department;

    private int hoursWorked;

    private boolean isManager = false;

    private boolean isAdmin = false;

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

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    //equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getDepartment() == employee.getDepartment() && getHoursWorked() == employee.getHoursWorked() && isManager() == employee.isManager() && isAdmin() == employee.isAdmin() && Objects.equals(getName(), employee.getName()) && Objects.equals(getUserName(), employee.getUserName()) && Objects.equals(getPassword(), employee.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getUserName(), getPassword(), getDepartment(), getHoursWorked(), isManager(), isAdmin());
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
                ", isManager=" + isManager +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
