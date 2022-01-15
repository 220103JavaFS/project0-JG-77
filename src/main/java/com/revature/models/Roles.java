package com.revature.models;

import java.util.Objects;

public class Roles {
    //only one field in Roles table
    private String empRole;

    //constructors
    public Roles(String empRole) {
        this.empRole = empRole;
    }

    public Roles() {
    }

    //Getter & setter
    public String getEmpRole() {
        return empRole;
    }

    public void setEmpRole(String empRole) {
        this.empRole = empRole;
    }
    //hashCode, equals, toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roles roles = (Roles) o;
        return Objects.equals(getEmpRole(), roles.getEmpRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmpRole());
    }

    @Override
    public String toString() {
        return "Roles{" +
                "empRole='" + empRole + '\'' +
                '}';
    }
}
