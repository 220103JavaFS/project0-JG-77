package com.revature.models;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private String userName;
    private String empPassword;
    private int hoursWorked;
    private Roles empRole;
    private Department depNum;

    //constructors
    public Employee(String firstName, String lastName, String userName, String empPassword, int hoursWorked, Roles empRole, Department depNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.empPassword = empPassword;
        this.hoursWorked = hoursWorked;
        this.empRole = empRole;
        this.depNum = depNum;
    }

    public Employee() {
    }

    //Getters & setters
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmpPassword() {
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
        return getHoursWorked() == employee.getHoursWorked() && Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName()) && Objects.equals(getUserName(), employee.getUserName()) && Objects.equals(getEmpPassword(), employee.getEmpPassword()) && Objects.equals(getEmpRole(), employee.getEmpRole()) && Objects.equals(getDepNum(), employee.getDepNum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getUserName(), getEmpPassword(), getHoursWorked(), getEmpRole(), getDepNum());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", empPassword='" + empPassword + '\'' +
                ", hoursWorked=" + hoursWorked +
                ", empRole=" + empRole +
                ", depNum=" + depNum +
                '}';
    }
}
