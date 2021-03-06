package com.revature.dao;

import com.revature.models.Department;
import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImp implements DepartmentDAO{

    @Override
    public List<Department> findAllDept() {
        try (Connection connect = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM departments;";

            Statement statement = connect.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<Department> deptList = new ArrayList<>();

            while(result.next()){
                Department department = new Department();
                //getting a integer from result
                department.setDepNum(result.getInt("dept_num")); //changed getString to getInt for integer value
                department.setDeptName(result.getString("dept_name"));

                deptList.add(department);
            }

            return deptList;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<Department>();
    }

    @Override
    public Department findByDept(int deptNum) {
        try (Connection connect = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM departments WHERE dept_num = ?;"; //? used for prepared statement

            PreparedStatement statement = connect.prepareStatement(sql);

            statement.setInt(1, deptNum);

            ResultSet result = statement.executeQuery();

            Department department = new Department();

            if(result.next()){
                //getting a string from result
                department.setDepNum(result.getInt("dept_num"));
                department.setDeptName(result.getString("dept_name"));//getting Int from table & setting value in dept object
            }

            return department;

        } catch (SQLException e){
            e.printStackTrace();
        }
        return new Department();
    }

    @Override
    public boolean updateDept(Department department) {
        try (Connection connect = ConnectionUtil.getConnection()){
            //update department # for  employee by selecting specific username
            String sql = "UPDATE departments SET dept_num = ?, dept_name = ? WHERE dept_num = ?;";

            PreparedStatement statement = connect.prepareStatement(sql);

            statement.setInt(1, department.getDepNum());
            statement.setString(2, department.getDeptName());
            statement.setInt(3, department.getDepNum());

            statement.execute();
            return  true;

        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addDept(Department department) {
        try (Connection connect = ConnectionUtil.getConnection()){

            //add new department #
            String sql = "INSERT INTO departments (dept_num, dept_name) VALUES (?,?);";

            PreparedStatement statement = connect.prepareStatement(sql);

            statement.setInt(1, department.getDepNum());
            statement.setString(2, department.getDeptName());

            statement.execute();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
