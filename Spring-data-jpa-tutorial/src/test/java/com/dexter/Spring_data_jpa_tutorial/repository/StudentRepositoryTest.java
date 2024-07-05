package com.dexter.Spring_data_jpa_tutorial.repository;

import com.dexter.Spring_data_jpa_tutorial.Entity.Guardian;
import com.dexter.Spring_data_jpa_tutorial.Entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @BeforeEach
    void setUp() {
    }

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public  void saveStudent(){

        Student  student =  Student.builder()
                .emailId("dextertech39@gmail.com")
                .firstName("sulaimon")
                .lastName("Muhammed")
               // .guardianName("Muritala")
               // .guardianMobile("08100891337")
               // .guardianEmail("muhtohasulaimon@gmail.com")
                .build();
        studentRepository.save(student);

    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian =  Guardian.builder()
                .email("joh@gmail.com")
                .mobile("08100891337")
                .name("Muhammed Ajibade")
                .build();
        Student student =  Student.builder()
                .emailId("dextetec@gmail.com")
                .firstName("sulaimon")
                .lastName("Muhammed")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList =  studentRepository.findAll();
        System.out.println("studentList = " + studentList);

    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("sulaimon");
        System.out.println("Students = " +students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("sul");
        System.out.println("Students = " +students);
    }


    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =  studentRepository.findByGuardianName("Muhammed");
        System.out.println("students = " +students);
    }

    @Test
    public void printStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress(
                "dextertech39@gmail.com"
        );
        System.out.println("Student = "+student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress(){
        String student = studentRepository.getStudentFirstNameByEmailAddress(
                "dextertech39@gmail.com"
        );
        System.out.println("Student = "+student);
    }

    @Test
    public void printStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative(
                "dextertech39@gmail.com"
        );
        System.out.println("Student = "+student);
    }


}