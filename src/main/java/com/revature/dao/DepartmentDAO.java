package com.revature.dao;

import com.revature.models.Department;

import java.util.List;

public interface DepartmentDAO {

    public List<Department> findAllDept();
    public Department findByDept(int deptNum);
    public boolean updateDept(Department department);
    public boolean addDept(Department department);
}
