package com.jayklef.prime.service;

import com.jayklef.prime.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudents();

    void saveStudent(Student student);

    Student findById(Integer id);

    void deleteById(Integer id);

   // void updateStudent(Integer id, Student existingStudent);

    Student updateStudent(Integer id);


}
