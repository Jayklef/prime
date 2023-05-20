package com.jayklef.prime.service;

import com.jayklef.prime.entity.Department;
import com.jayklef.prime.entity.Student;

import java.util.List;

public interface DepartmentService {
    List<Department> findAllDepartments();

    void saveDepartment(Department department);

    Department findById(Integer id);

    Department updateDepartment(Integer id);

    void deleteById(Integer id);
}
