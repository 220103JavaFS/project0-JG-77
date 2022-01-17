package com.revature.dao;

import com.revature.models.Department;

import java.util.List;

public interface DepartmentDAO {

    List<Department> findAllDept();
    Department findByDept(int deptNum);
    boolean updateDept(Department department);
    boolean addDept(Department department);
}
