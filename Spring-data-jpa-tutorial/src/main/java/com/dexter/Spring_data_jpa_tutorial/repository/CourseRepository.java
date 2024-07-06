package com.dexter.Spring_data_jpa_tutorial.repository;


import com.dexter.Spring_data_jpa_tutorial.Entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course , Long> {

    Page<Course> findByTitleContaining(String title, Pageable pageable);
}
