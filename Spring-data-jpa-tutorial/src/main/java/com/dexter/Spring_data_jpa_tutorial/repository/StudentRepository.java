package com.dexter.Spring_data_jpa_tutorial.repository;

import com.dexter.Spring_data_jpa_tutorial.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
