package com.revature.dao;

import com.revature.models.Roles;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RoleDAOImp implements RoleDAO{
    @Override
    public List<Roles> findAllRoles() {
        //include resources block to close connection to DB after every use
        try (Connection connect = ConnectionUtil.getConnection()){

        }catch (SQLException e){
          e.printStackTrace();
        }
        return null;
    }

    @Override
    public Roles findByRole(String roleName) {
        return null;
    }

    @Override
    public boolean updateRole(Roles roles) {
        return false;
    }
}

