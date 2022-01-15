package com.revature.models;

import java.util.Objects;

public class Department {
    //only one field in table
    private int depNum;

    //constructors
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

    //hashCode, equals, toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return getDepNum() == that.getDepNum();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDepNum());
    }

    @Override
    public String toString() {
        return "Department{" +
                "depNum=" + depNum +
                '}';
    }
}
