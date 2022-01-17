package com.revature.dao;

import com.revature.models.Roles;
import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
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
        try (Connection connect = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM employees WHERE emp_role = ?;";//? used for prepared statement, prevents injection

            PreparedStatement statement = connect.prepareStatement(sql);

            statement.setString(1, roleName); // 1 = ? in sql string --> replaces ? with roleName

            ResultSet result = statement.executeQuery();

            Roles roles = new Roles();

            if(result.next()){
                //getting a string from result
                roles.setEmpRole(result.getString("emp_role")); //using setter method to store record in role object
            }

            return roles;

        } catch (SQLException e){
            e.printStackTrace();
        }
        return new Roles();
    }

    @Override
    public boolean updateRole(Roles roles) {
        try (Connection connect = ConnectionUtil.getConnection()){
            String sql = "UPDATE employees SET emp_role = ? WHERE username = ?;"; //update roles by selecting specific username

            PreparedStatement statement = connect.prepareStatement(sql);

            statement.setString(1, roles.getEmpRole());
            statement.setString(2, Employee.getUserName());

            statement.execute();
            return  true;

        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}

