package com.dexter.Spring_data_jpa_tutorial.repository;

import com.dexter.Spring_data_jpa_tutorial.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String name);
    public List<Student> findByLastNameNotNull();
    public List<Student> findByGuardianName(String guardianName);
    public Student findByFirstNameAndLastName(String firstname, String lastName);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    public Student getStudentByEmailAddress(String EmailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    public String getStudentFirstNameByEmailAddress(String EmailId);


    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    public Student getStudentByEmailAddressNative(String emailId);



    // Native Named Param
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    public Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);


}
