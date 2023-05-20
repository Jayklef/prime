package com.jayklef.prime.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;
import java.util.Date;

@Entity
@Data
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 70)
    private String firstname;
    private String lastname;
    private String email;
    private String telephone;
    private Date dateOfBirth;
    private String address;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;
}
