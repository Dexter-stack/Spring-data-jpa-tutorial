package com.dexter.Spring_data_jpa_tutorial.repository;

import com.dexter.Spring_data_jpa_tutorial.Entity.Course;
import com.dexter.Spring_data_jpa_tutorial.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {


    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    public void saveTeacher(){

        Course courseBME = Course.builder()
                .title("BME401")
                .credit(12)
                .build();
        Course courseCHE = Course.builder()
                .title("CHE501")
                .credit(11)
                .build();
        Course courseMEE = Course.builder()
                .title("MEE401")
                .credit(13)
                .build();
        Teacher teacher =  Teacher.builder()
                .firstName("John")
                .lastName("Wick")
//                .courses(List.of(courseBME,courseCHE,courseMEE))
                .build();
        teacherRepository.save(teacher);
    }


}