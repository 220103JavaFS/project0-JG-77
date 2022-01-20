package com.revature.dao;

import com.revature.models.Department;
import com.revature.models.Employee;
import com.revature.models.Roles;
import com.revature.utils.ConnectionUtil;
import org.mindrot.jbcrypt.BCrypt;

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

                String hashedPW = BCrypt.hashpw(result.getString("emp_password"), BCrypt.gensalt());

                employee.setEmpPassword(hashedPW); //hash password to protect info
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

                String hashedPW = BCrypt.hashpw(result.getString("emp_password"), BCrypt.gensalt());
                employee.setEmpPassword(hashedPW);
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
                    "dept_num =?, emp_role = ? WHERE username = ?;";

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

            statement.executeUpdate(sql); //executes DELETE query that returns nothing
            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public String verifyPassword(String username) {
        try (Connection connect = ConnectionUtil.getConnection()) {
            String sql = "SELECT emp_password FROM employees WHERE username = ?;";

            PreparedStatement statement = connect.prepareStatement(sql);

            statement.setString(1, username);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
               return result.getString("emp_password");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> findInRoles(String role) { //returns all employees with specific role.
        try (Connection connect = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM roles INNER JOIN employees ON roles.emp_role = employees.emp_role " +
                    "WHERE roles.emp_role = ?;";
            PreparedStatement statement = connect.prepareStatement(sql);

            statement.setString(1, role);

            ResultSet result = statement.executeQuery();

            List<Employee> employeeList = new ArrayList<>();

            while (result.next()){
                Employee employee = new Employee();
                employee.setEmployeeID(result.getInt("empl_id"));
                employee.setFirstName(result.getString("first_name"));
                employee.setLastName(result.getString("last_name"));
                employee.setUserName(result.getString("username"));

                String hashedPW = BCrypt.hashpw(result.getString("emp_password"), BCrypt.gensalt());
                employee.setEmpPassword(hashedPW);
                employee.setHoursWorked(result.getInt("hours_worked"));
                String employeeRole = result.getString("emp_role");
                if(employeeRole!= null){ //since role comes from another table, retrieve info from roleDAO
                    Roles roles = roleDAO.findByRole(employeeRole);
                    employee.setEmpRole(roles);
                }

                int employeeDept = result.getInt("dept_num");
                String empDeptString = String.valueOf(employeeDept);
                if(empDeptString != null){      //retrieve dept # from department DAO
                    Department department = departmentDAO.findByDept(employeeDept);
                    employee.setDepNum(department);
                }
                employeeList.add(employee);
            }
            return employeeList;

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Employee>();
    }

    @Override //finds all employees in same department
    public List<Employee> findInDept(int dept) {
        try (Connection connect = ConnectionUtil.getConnection()) {
            String sql = " SELECT * FROM departments INNER JOIN employees ON departments.dept_num = employees.dept_num " +
                    "WHERE employees.dept_num = ?;";
            PreparedStatement statement = connect.prepareStatement(sql);

            statement.setInt(1, dept);

            ResultSet result = statement.executeQuery();

            List<Employee> employeeList = new ArrayList<>();

            while (result.next()){
                Employee employee = new Employee();
                employee.setEmployeeID(result.getInt("empl_id"));
                employee.setFirstName(result.getString("first_name"));
                employee.setLastName(result.getString("last_name"));
                employee.setUserName(result.getString("username"));

                String hashedPW = BCrypt.hashpw(result.getString("emp_password"), BCrypt.gensalt());
                employee.setEmpPassword(hashedPW);

                employee.setHoursWorked(result.getInt("hours_worked"));
                String employeeRole = result.getString("emp_role");
                if(employeeRole!= null){ //since role comes from another table, retrieve info from roleDAO
                    Roles roles = roleDAO.findByRole(employeeRole);
                    employee.setEmpRole(roles);
                }

                int employeeDept = result.getInt("dept_num");
                String empDeptString = String.valueOf(employeeDept);
                if(empDeptString != null){      //retrieve dept # from department DAO
                    Department department = departmentDAO.findByDept(employeeDept);
                    employee.setDepNum(department);
                }
                employeeList.add(employee);
            }
            return employeeList;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Employee>();
    }

    @Override
    public int getHours(String username) { //called by addEmpHours() in service layer to get hours from employee
        try (Connection connect = ConnectionUtil.getConnection()) {
            String sql ="SELECT employees.hours_worked FROM employees WHERE username = ?;";

            PreparedStatement statement = connect.prepareStatement(sql);

            statement.setString(1, username);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                return result.getInt("hours_worked");
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean addHours(String username, int hours) { //gets aggregated hours and updates db
        try (Connection connect = ConnectionUtil.getConnection()) {
            String sql ="UPDATE employees SET hours_worked = ? WHERE username = ?;";

            PreparedStatement statement = connect.prepareStatement(sql);

            statement.setInt(1, hours);
            statement.setString(2, username);

            statement.execute();
            return  true;


        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
