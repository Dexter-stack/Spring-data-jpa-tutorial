package com.dexter.Spring_data_jpa_tutorial.repository;

import com.dexter.Spring_data_jpa_tutorial.Entity.Course;
import com.dexter.Spring_data_jpa_tutorial.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourse(){

        Course course =  Course.builder()
                .title("CHE 311")
                .credit(12)
                .build();
        courseRepository.save(course);

    }

    @Test
    public void printAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses : " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Dexter")
                .lastName("Sule")

                .build();

        Course course = Course.builder()
                .title("DSA")
                .credit(23)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

}