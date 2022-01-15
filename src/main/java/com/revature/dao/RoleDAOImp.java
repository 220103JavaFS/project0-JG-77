package com.revature.dao;

import com.revature.models.Roles;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAOImp implements RoleDAO{
    @Override
    public List<Roles> findAllRoles() {
        //include resources block to close connection to DB after every use
        try (Connection connect = ConnectionUtil.getConnection()){
        String sql = "SELECT * FROM roles;";

        Statement statement = connect.createStatement();

        ResultSet result = statement.executeQuery(sql); //sql query is turned into a statement object in form of ResultSet

        List<Roles> roleList = new ArrayList<>(); // role values get stored in a list

        while(result.next()){ //while there's records in results (roles), return values
            Roles role = new Roles();
            //getting a string from result
            role.setEmpRole(result.getString("emp_role")); //using setter method to store record in role object

            roleList.add(role);
        }

        return roleList;

        }catch (SQLException e){
          e.printStackTrace();
        }
        return new ArrayList<Roles>();
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

