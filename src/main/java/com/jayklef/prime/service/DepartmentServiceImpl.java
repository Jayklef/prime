package com.jayklef.prime.service;

import com.jayklef.prime.entity.Department;
import com.jayklef.prime.exception.DepartmentNotFoundException;
import com.jayklef.prime.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public void saveDepartment(Department department) {
        Department newDepartment = new Department();
        newDepartment.setName(department.getName());
        newDepartment.setTelephone(department.getTelephone());
        newDepartment.setLocation(department.getLocation());
        departmentRepository.save(newDepartment);
    }

    @Override
    public Department findById(Integer id) {
        Optional<Department> departmentOptional = departmentRepository.findById(id);

        if (departmentOptional.isPresent()){
            return departmentRepository.findById(id).get();
        }

        throw new DepartmentNotFoundException("Department with Id" + id +" not found ");
    }

    @Override
    public Department updateDepartment(Integer id) {
        Department deptInDb = departmentRepository.findById(id).get();
        //Department updatedDepartment = departmentRepository.findById(existingDepartment.getId());
    /*    if (Objects.nonNull (department.getName()) &&
        !"".equalsIgnoreCase(department.getName())){
            deptInDb.setName(department.getName());
        }

        if (Objects.nonNull(deptInDb.getTelephone()) &&
                !"".equalsIgnoreCase(deptInDb.getTelephone())){
            deptInDb.setTelephone(deptInDb.getTelephone());
        }

        if (Objects.nonNull(deptInDb.getLocation()) &&
                !"".equalsIgnoreCase(deptInDb.getLocation())){
            deptInDb.setLocation(deptInDb.getLocation());
        }  */
         return departmentRepository.save(deptInDb);
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);

        if (optionalDepartment.isPresent()){
            departmentRepository.deleteById(id);
        }

        throw new DepartmentNotFoundException("Department with not found");
    }
}
