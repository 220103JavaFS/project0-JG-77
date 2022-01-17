package com.revature.models;

import java.util.Objects;

public class Employee {

    private int employeeID;
    private String firstName;
    private String lastName;
    private static String userName; //made static
    private static String empPassword;
    private int hoursWorked;
    private Roles empRole;
    private Department depNum;

    //3 constructors --> No args, all args, args excluding id variable
    //no id variable to let DB give a serialized employee id
    public Employee(String firstName, String lastName, String userName, String empPassword, int hoursWorked, Roles empRole, Department depNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.empPassword = empPassword;
        this.hoursWorked = hoursWorked;
        this.empRole = empRole;
        this.depNum = depNum;
    }

    public Employee(int employeeID, String firstName, String lastName, int hoursWorked, Roles empRole, Department depNum) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hoursWorked = hoursWorked;
        this.empRole = empRole;
        this.depNum = depNum;
    }

    public Employee() {
    }

    //Getters & setters

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Roles getEmpRole() {
        return empRole;
    }

    public void setEmpRole(Roles empRole) {
        this.empRole = empRole;
    }

    public Department getDepNum() {
        return depNum;
    }

    public void setDepNum(Department depNum) {
        this.depNum = depNum;
    }

    //hashCode, equals, toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getEmployeeID() == employee.getEmployeeID() && getHoursWorked() == employee.getHoursWorked() && Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName()) && Objects.equals(getEmpRole(), employee.getEmpRole()) && Objects.equals(getDepNum(), employee.getDepNum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeID(), getFirstName(), getLastName(), getHoursWorked(), getEmpRole(), getDepNum());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hoursWorked=" + hoursWorked +
                ", empRole=" + empRole +
                ", depNum=" + depNum +
                '}';
    }
}
