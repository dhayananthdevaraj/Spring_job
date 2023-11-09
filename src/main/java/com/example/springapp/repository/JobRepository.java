package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Job;
import java.util.List;


@Repository
public interface JobRepository extends JpaRepository<Job, Long>{

    Job findByJobTitle(String jobTitle);

    @Query("SELECT j FROM Job j WHERE j.department = :department")
    List<Job> findJobsByDepartmentName(@Param("department") String department);

    @Query("SELECT j FROM Job j WHERE j.location = :location")
    List<Job> findJobsByLocationName(@Param("location") String location);

    @Query("SELECT j FROM Job j WHERE j.department = :department AND j.location = :location")
    List<Job> findJobsByDepartmentAndLocation(@Param("department") String department, @Param("location") String location);

    @Query("SELECT j FROM Job j WHERE j.jobTitle = :jobTitle AND j.location = :location")
    List<Job> findJobsByJobTitleAndLocation(@Param("jobTitle") String jobTitle, @Param("location") String location);

     @Query("SELECT j FROM Job j WHERE j.jobTitle = :jobTitle AND j.department = :department AND j.location = :location")
    List<Job> findJobsByJobTitleAndDepartmentAndLocation(@Param("jobTitle") String jobTitle,@Param("department") String department, @Param("location") String location);
    
}
