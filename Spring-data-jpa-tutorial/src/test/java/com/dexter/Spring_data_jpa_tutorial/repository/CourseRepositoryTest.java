package com.dexter.Spring_data_jpa_tutorial.repository;

import com.dexter.Spring_data_jpa_tutorial.Entity.Course;
import com.dexter.Spring_data_jpa_tutorial.Entity.Student;
import com.dexter.Spring_data_jpa_tutorial.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords =  PageRequest.of(1,2);

        List<Course> courses =  courseRepository.findAll(secondPageWithTwoRecords).getContent();
        long totaElement = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
        long totalPages =  courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();
        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totaElement);

        System.out.println("courses = "+ courses);

    }

    @Test
    public void findAllBySorting(){
        Pageable sortByTitle = PageRequest.of(
                0,
                2,
                Sort.by("title")
        );

        Pageable sortByCreditDesc =  PageRequest.of(
                0,
                3,
                Sort.by("credit").descending()
        );

        Pageable sortByTitleAndCreditDesc = PageRequest.of(
                0,
                2,
                Sort.by("title")
                        .descending()
                        .and(Sort.by("credit"))
        );

        List<Course> courses =  courseRepository.findAll(sortByCreditDesc).getContent();
        System.out.println("Courses = "+ courses);
    }


@Test
    public void printFindByTitleContaining(){

        Pageable firstPagerecords =  PageRequest.of(0,10);
        List<Course> courses =  courseRepository.findByTitleContaining("B",firstPagerecords).getContent();
        System.out.println("Course = "+ courses);
    }

   @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher =  Teacher.builder()
                .firstName("Lizzy")
                .lastName("desk")
                .build();
        Student student = Student.builder()
                .firstName("Tobi")
                .lastName("siji")
                .emailId("dex@gmail.com")
                .build();
        Course course =  Course.builder()
                .title("Java")
                .credit(12)
                .teacher(teacher)

                .build();
        course.addStudents(student);
        courseRepository.save(course);
    }

}