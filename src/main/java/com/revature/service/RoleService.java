package com.revature.service;

import com.revature.models.Roles;
import com.revature.dao.RoleDAO;
import com.revature.dao.RoleDAOImp;

import java.util.List;

public class RoleService {

    private RoleDAO roleDAO = new RoleDAOImp(); //call interface RoleDAO using RoleDAOImp class implementation

    public List<Roles> findRolesAll(){
        return roleDAO.findAllRoles(); //from RoleDAO
    }

    public Roles findRole(String roleName){

        return roleDAO.findByRole(roleName);
    }

    public boolean updateRole(Roles roles){
        return roleDAO.updateRole(roles);
    }
}
