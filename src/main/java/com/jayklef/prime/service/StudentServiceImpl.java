package com.jayklef.prime.service;

import com.jayklef.prime.entity.Student;
import com.jayklef.prime.exception.StudentNotFoundException;
import com.jayklef.prime.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findById(Integer id) {

        Optional<Student> productOptional = studentRepository.findById(id);

        if (productOptional.isPresent()){
            return studentRepository.findById(id).get();
        }
        throw new StudentNotFoundException("product with ID not found");
    }

    @Override
    public void deleteById(Integer id) {

        Optional<Student> productOptional = studentRepository.findById(id);

        if (productOptional.isPresent()){
             studentRepository.deleteById(id);
        }
        throw new StudentNotFoundException("product with ID " + id + " has been deleted ");
    }

 /*   @Override
    public void updateStudent(Integer id, Student existingStudent) {
        Student optionalStudent = studentRepository.findById(id).get();

        if (Objects.nonNull(existingStudent.getFirstname()) &&
                !"".equalsIgnoreCase(existingStudent.getFirstname())){
            optionalStudent.setFirstname(existingStudent.getFirstname());
        }

        if (Objects.nonNull(student.getEmail()) &&
                !"".equalsIgnoreCase(student.getEmail())){
            studentInDb.setEmail(student.getEmail());
        }

        if (Objects.nonNull(student.getTelephone()) &&
                !"".equalsIgnoreCase(student.getTelephone())){
            studentInDb.setTelephone(student.getTelephone());
        }

        if (Objects.nonNull(student.getDateOfBirth()) &&
                !"".equalsIgnoreCase(student.getDateOfBirth())){
            studentInDb.setDateOfBirth(student.getDateOfBirth());
        }

        if (Objects.nonNull(student.getAddress()) &&
                !"".equalsIgnoreCase(student.getAddress())){
            studentInDb.setAddress(student.getAddress());
        }

        if (Objects.nonNull(student.getDepartment()) &&
                !"".equalsIgnoreCase(student.getDepartment().toString())){
            studentInDb.setDepartment(student.getDepartment());
        }
        existingStudent.setFirstname(existingStudent.getFirstname());
        existingStudent.setLastname(existingStudent.getLastname());
        existingStudent.setEmail(existingStudent.getEmail());
        existingStudent.setTelephone(existingStudent.getTelephone());
        existingStudent.setDateOfBirth(existingStudent.getDateOfBirth());
        existingStudent.setAddress(existingStudent.getAddress());


        studentRepository.save(existingStudent);
    }  */

    @Override
    public Student updateStudent(Integer id) {
        Student studentInDb = studentRepository.findById(id).get();

      /*  if (Objects.nonNull(student.getFirstname()) &&
        !"".equalsIgnoreCase(student.getFirstname())){
            studentInDb.setFirstname(student.getFirstname());
        }

        if (Objects.nonNull(student.getEmail()) &&
                !"".equalsIgnoreCase(student.getEmail())){
            studentInDb.setEmail(student.getEmail());
        }

        if (Objects.nonNull(student.getTelephone()) &&
                !"".equalsIgnoreCase(student.getTelephone())){
            studentInDb.setTelephone(student.getTelephone());
        }

        if (Objects.nonNull(student.getDateOfBirth()) &&
                !"".equalsIgnoreCase(student.getDateOfBirth().toString())){
            studentInDb.setDateOfBirth(student.getDateOfBirth());
        }

        if (Objects.nonNull(student.getAddress()) &&
                !"".equalsIgnoreCase(student.getAddress())){
            studentInDb.setAddress(student.getAddress());
        }

        if (Objects.nonNull(student.getDepartment()) &&
                !"".equalsIgnoreCase(student.getDepartment().toString())){
            studentInDb.setDepartment(student.getDepartment());
        }  */

        return studentRepository.save(studentInDb);
    }

}
