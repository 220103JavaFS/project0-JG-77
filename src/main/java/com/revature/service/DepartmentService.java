package com.revature.service;

import com.revature.dao.DepartmentDAO;
import com.revature.dao.DepartmentDAOImp;
import com.revature.models.Department;

import java.util.List;

    public class DepartmentService {
    //DeptDAO object with DAO implementation
    DepartmentDAO departmentDAO = new DepartmentDAOImp();

    public List<Department> findALLDepartments(){
        return departmentDAO.findAllDept(); //DAO method
    }

    public Department findDept(int deptNum) {
        return departmentDAO.findByDept(deptNum);
    }

    public boolean updateDepartment(Department department){
        return departmentDAO.updateDept(department);
    }

    public boolean addDepartment(Department department){
        return departmentDAO.addDept(department);
    }
}
