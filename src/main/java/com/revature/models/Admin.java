package com.revature.models;

import java.util.Objects;

public class Admin{

    private boolean isAdmin;

    //constructor
    public Admin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Admin() {
    }

    //getter and setter
    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override //equals(), hashCode(), toString()
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return isAdmin() == admin.isAdmin();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isAdmin());
    }

    @Override
    public String toString() {
        return "Admin{" +
                "isAdmin=" + isAdmin +
                '}';
    }
}
