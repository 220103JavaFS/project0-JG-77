package com.revature.models;


import java.util.Objects;

public class Manager{

    private boolean isManager;

    //Constructor
    public Manager(boolean isManager) {
        this.isManager = isManager;
    }
    public Manager(){

    }
    //getter and setter
    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    @Override //equals(), hashCode(), toString()
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return isManager() == manager.isManager();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isManager());
    }

    @Override
    public String toString() {
        return "Manager{" +
                "isManager=" + isManager +
                '}';
    }
}
