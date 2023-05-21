package com.jayklef.prime.controller;

import com.jayklef.prime.entity.Department;
import com.jayklef.prime.entity.Student;
import com.jayklef.prime.exception.DepartmentNotFoundException;
import com.jayklef.prime.exception.StudentNotFoundException;
import com.jayklef.prime.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @GetMapping("/departments")
    public String getAllDepartments(Model model){
        List<Department> departments = departmentService.findAllDepartments();
        model.addAttribute("departments", departments);
        return "departments";
    }

    @GetMapping("/departments/new")
    public String addDepartment(Model model){
        model.addAttribute("department", new Department());
        return "department_form";
    }

    @PostMapping("/departments/save")
    public String saveDepartment(Department department, RedirectAttributes attributes){
        String inform = "Dept has been successfully added";
        departmentService.saveDepartment(department);
        attributes.addFlashAttribute("message", inform);
        return "redirect:/departments";
    }

    @GetMapping("/department/update")
    public String updateDepartment(@RequestParam Integer id, Model model, RedirectAttributes attributes){
        try {
            Department department = departmentService.updateDepartment(id);
            model.addAttribute("department", department);
            model.addAttribute("pageTitle", "Edit student (ID" + id +")");
            return "editDepartment_form";

        }catch (StudentNotFoundException e){
            String inform = "Department has been save successfully";
            attributes.addFlashAttribute("message", inform);
        }

       // Department existingDepartment = departmentService.findById(id);
      //  departmentService.updateDepartment(id, existingDepartment);
        return "redirect:/departments";
    }

  /*  @PostMapping("/departments/update")
    public String updateDepartment(@RequestParam Integer id, Model model){
       Department department = departmentService.updateDepartment(id);
       model.addAttribute("department", department);
        return "redirect:/departments";
    } */

    @GetMapping("/departments/delete/{id}")
    public String showDeleteForm(@PathVariable("id") Integer id, RedirectAttributes attributes){
        try {
            departmentService.deleteById(id);
            attributes.addFlashAttribute("message", "Department with id has been deleted successfully");
        }catch (DepartmentNotFoundException e){
            attributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/departments";
    }
}
