package com.jayklef.prime.controller;

import com.jayklef.prime.entity.Department;
import com.jayklef.prime.entity.Student;
import com.jayklef.prime.exception.StudentNotFoundException;
import com.jayklef.prime.service.DepartmentService;
import com.jayklef.prime.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/students")
    public String getAllUsers(Model model){
        List<Student> students = studentService.findAllStudents();
        model.addAttribute("students", students);

        return "students";
    }

    @GetMapping("/student")
    public String getStudent(@PathVariable("id") Integer id, Model model){
         Student student = studentService.findById(id);
         model.addAttribute("student", student);
         return "student";
    }

    @GetMapping("/students/new")
    public String addStudent(Model model){
        List<Department> departments = departmentService.findAllDepartments();

        model.addAttribute("student", new Student());
        model.addAttribute("departments", departments);
        model.addAttribute("pageTitle", "Add New Student");
        return "student_form";
    }

    @PostMapping("/students/save")
    public String saveStudent(Student student, RedirectAttributes attributes){
        String inform = "Student has been save successfully";
        studentService.saveStudent(student);
        attributes.addFlashAttribute("message", inform);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes attributes){
        try {
            Student student = studentService.updateStudent(id);
            model.addAttribute("student", student);
            model.addAttribute("pageTitle", "Edit student (ID" + id +")");
            return "editStudent_form";
        }catch (StudentNotFoundException e){
            String inform = "Student has been save successfully";
            attributes.addFlashAttribute("message", inform);
        }
/*
        Student existingStudent = studentService.findById(id);
        studentService.updateStudent(existingStudent);    */
        return "redirect:/students";
    }

    @PutMapping("/students/update/{id}")
    public String updateStudent(@PathVariable("id") Integer id){
        studentService.updateStudent(id);
        return "redirect:/students";
    }

 /*   @GetMapping("/students/view")
    public String showViewForm(@PathVariable("id") Integer id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
            return "viewStudent_form";
    } */

    @GetMapping("/students/delete/{id}")
    public String showDeleteForm(@PathVariable("id") Integer id, RedirectAttributes attributes){
        try {
          studentService.deleteById(id);
          attributes.addFlashAttribute("message", "The Id " + id + " has been deleted ");
        }catch (StudentNotFoundException e){
            attributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/students";
    }


}
