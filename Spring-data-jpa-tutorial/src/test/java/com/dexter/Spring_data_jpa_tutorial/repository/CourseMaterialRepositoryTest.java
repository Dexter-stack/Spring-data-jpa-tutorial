package com.dexter.Spring_data_jpa_tutorial.repository;

import com.dexter.Spring_data_jpa_tutorial.Entity.Course;
import com.dexter.Spring_data_jpa_tutorial.Entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){

        Course course =  Course.builder()
                .title("CHE 311")
                .credit(12)
                .build();
        CourseMaterial courseMaterial =  CourseMaterial.builder()
                .course(course)
                .url("aws.com")
                .build();
        courseMaterialRepository.save(courseMaterial);


    }

    @Test
    public void printAllCoursesMaterial(){

        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("Materials : "+courseMaterials);
    }

}