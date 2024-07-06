package com.dexter.Spring_data_jpa_tutorial.repository;


import com.dexter.Spring_data_jpa_tutorial.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course , Long> {

}
