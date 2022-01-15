package com.revature.dao;

import com.revature.models.Roles;
import java.util.List;

//create interface with methods to loosely couple data from DB to app
public interface RoleDAO {
    public List<Roles> findAllRoles();
    public Roles findByRole(String roleName);
    //no method to add roles since we only want 3 roles for 3 user tiers
    public boolean updateRole(Roles roles); //only allow between employee, admin, manager

}
