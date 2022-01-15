package com.revature.dao;

import com.revature.models.Roles;

import java.util.List;

//create interface with methods to loosely couple data from DB to app
public interface RoleDAO {
    public List<Roles> findAllRoles();
    public Roles findByRole(String roleName);
    public boolean updateRole(Roles roles);
    public boolean addRoles(Roles roles);
}
