package com.revature.dao;

import com.revature.models.Department;
import com.revature.models.Employee;
import com.revature.models.Roles;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImp implements EmployeeDAO{

    private RoleDAO roleDAO = new RoleDAOImp();
    private DepartmentDAO departmentDAO = new DepartmentDAOImp();

    @Override
    public List<Employee> findAllEmp() {
        try (Connection connect = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM employees;";

            Statement statement = connect.createStatement();

            ResultSet result = statement.executeQuery(sql);
            List<Employee> employeeList = new ArrayList<>();

            while(result.next()){
                Employee employee = new Employee();
                employee.setEmployeeID(result.getInt("empl_id"));
                employee.setFirstName(result.getString("first_name"));
                employee.setLastName(result.getString("last_name"));
                employee.setUserName(result.getString("username"));
                employee.setEmpPassword(result.getString("emp_password"));
                employee.setHoursWorked(result.getInt("hours_worked"));
                String employeeRole = result.getString("emp_role");
                if(employeeRole!= null){ //since role comes from another table, retrieve info from roleDAO
                    Roles roles = roleDAO.findByRole(employeeRole);
                    employee.setEmpRole(roles);
                }

                int employeeDept = result.getInt("dept_num");
                String empDeptString = String.valueOf(employeeDept); //int is converted to string object
                if(empDeptString != null){ //get dept number from departments table
                    Department department = departmentDAO.findByDept(employeeDept);
                    employee.setDepNum(department);
                }

                employeeList.add(employee);
            }
            return employeeList;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<Employee>();
    }

    @Override
    public Employee findEmp(int id) {
        try (Connection connect = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM employees WHERE empl_id = "+id+";"; //no prepared statement --> no injection risk with integer id

            Statement statement = connect.createStatement();

            ResultSet result = statement.executeQuery(sql);

            Employee employee = new Employee();

            while (result.next()){
                employee.setEmployeeID(result.getInt("empl_id"));
                employee.setFirstName(result.getString("first_name"));
                employee.setLastName(result.getString("last_name"));
                employee.setUserName(result.getString("username"));
                employee.setEmpPassword(result.getString("emp_password"));
                employee.setHoursWorked(result.getInt("hours_worked"));
                String employeeRole = result.getString("emp_role");
                    if(employeeRole!= null){ //since role comes from another table, retrieve info from roleDAO
                        Roles roles = roleDAO.findByRole(employeeRole);
                        employee.setEmpRole(roles);
                    }

                int employeeDept = result.getInt("dept_num");
                String empDeptString = String.valueOf(employeeDept);
                    if(empDeptString != null){
                        Department department = departmentDAO.findByDept(employeeDept);
                        employee.setDepNum(department);
                    }

            }
            return employee;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return new Employee();
    }

    @Override
    public boolean addEmp(Employee employee) {
        try (Connection connect = ConnectionUtil.getConnection()){
            //add new employees
            String sql = "INSERT INTO employees (first_name, last_name, username, emp_password, hours_worked,"+
            "dept_num, emp_role ) VALUES (?,?,?,?,?,?,?);";

            PreparedStatement statement = connect.prepareStatement(sql);

            int count = 0;
            statement.setString(++count, employee.getFirstName());
            statement.setString(++count, employee.getLastName());
            statement.setString(++count, employee.getUserName());
            statement.setString(++count, employee.getEmpPassword());
            statement.setInt(++count, employee.getHoursWorked());

            Department department = new Department(); //new department object to access getter method
            statement.setInt(++count, department.getDepNum());

            Roles roles = new Roles(); //new roles object to access getter method
            statement.setString(++count, roles.getEmpRole());

            statement.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateEmp(Employee employee) {
        try (Connection connect = ConnectionUtil.getConnection()){
            //add new employees
            String sql = "UPDATE employees SET first_name = ?, last_name = ?, username = ?, emp_password = ?, hours_worked = ?,"+
                    "dept_num = ?, emp_role = ?  WHERE username = ?;";

            PreparedStatement statement = connect.prepareStatement(sql);

            int count = 0;
            statement.setString(++count, employee.getFirstName());
            statement.setString(++count, employee.getLastName());
            statement.setString(++count, employee.getUserName());
            statement.setString(++count, employee.getEmpPassword());
            statement.setInt(++count, employee.getHoursWorked());

            Department department = new Department(); //new department object to access getter method
            statement.setInt(++count, department.getDepNum());

            Roles roles = new Roles(); //new roles object to access getter method
            statement.setString(++count, roles.getEmpRole());

            statement.setString(++count, employee.getUserName());

            statement.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean terminateEmp(int id) {
        try (Connection connect = ConnectionUtil.getConnection()){
            String sql = "DELETE FROM employees WHERE empl_id = "+id+";";

            Statement statement = connect.createStatement();

            ResultSet result = statement.executeQuery(sql);

            result.close(); //Releases this result object's database and JDBC resources
            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Employee verifyPassword(String username, String password) {
        try (Connection connect = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM employees WHERE (username = ?) AND (emp_password = ?);";

            PreparedStatement statement = connect.prepareStatement(sql);

            ResultSet result = statement.executeQuery(sql);

            Employee employee = new Employee();

            while (result.next()) {
                //employee.setUserName()
                employee.setUserName(result.getString("username"));
                employee.setEmpPassword(result.getString("emp_password"));
//                result.getString("username");
//                result.getString("emp_password");
            }

            return employee;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Employee();
    }


}
