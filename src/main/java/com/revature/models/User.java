package com.revature.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class User {
    //constructor
    public User(int id, String firstName, String lastName, String fullName, String password, int dept, List<Integer> hoursWorked, String manager) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.password = password;
        this.dept = dept;
        this.hoursWorked = hoursWorked;
        this.manager = manager;
    }

    public User() {
    }

    //user info variables
    //essentially three tiers: employee, manager, Admin (HR) for management system app
    private int id; // unique employee id for each user (all employees)

    private String firstName;

    private String lastName;

    private String fullName = firstName+lastName;

    private String password;

    private int dept;

    private List<Integer> hoursWorked; //object with # of hours worked for the week

    //employees can see who their manager is
    private String manager; //do I need this here, or in employee?

    //collection of employees --> managers can see all their employees from their dept
    private static ArrayList<Employee> employees;

    //getter & setter methods
    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static void setEmployees(ArrayList<Employee> employees) {
        User.employees = employees;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
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

    public String getFullName() {
        fullName = firstName + lastName;

        System.out.println(fullName);
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDept() {
        return dept;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }

    public List<Integer> getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(List<Integer> hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId() == user.getId() && getDept() == user.getDept() && Objects.equals(getFirstName(), user.getFirstName()) && Objects.equals(getLastName(), user.getLastName()) && Objects.equals(getFullName(), user.getFullName()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getHoursWorked(), user.getHoursWorked()) && Objects.equals(getManager(), user.getManager());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getFullName(), getPassword(), getDept(), getHoursWorked(), getManager());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", dept=" + dept +
                ", hoursWorked=" + hoursWorked +
                ", manager='" + manager + '\'' +
                '}';
    }
    //method for managers to remove employee
//    public static boolean removeEmployee(Employee a) {
//        employees.remove(a);
//        return true;
//    }
//
//    //method for managers to add employee
//    public static boolean addEmployee(Employee a) {
//        employees.add(a);
//        return true;
//    }
//
//    //get employees by dept #
//    public Employee getDeptEmployees(int dept){
//        return employees.get(dept);
//    }
}