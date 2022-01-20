package com.revature.models;

import java.util.Objects;

public class Department {

    private int depNum;
    private String deptName;

    //constructors
    public Department(int depNum, String deptName) {
        this.depNum = depNum;
        this.deptName = deptName;
    }

    public Department(int depNum) {
        this.depNum = depNum;
    }

    public Department() {
    }

    //Getter & Setter
    public int getDepNum() {
        return depNum;
    }

    public void setDepNum(int depNum) {
        this.depNum = depNum;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    //hashCode, equals, toString

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return getDepNum() == that.getDepNum() && Objects.equals(getDeptName(), that.getDeptName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDepNum(), getDeptName());
    }

    @Override
    public String toString() {
        return "Department{" +
                "depNum=" + depNum +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
