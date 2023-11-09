package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Job;
import com.example.springapp.repository.JobRepository;


@Service
public class JobService {
 @Autowired
    private JobRepository jobRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public void updateJob(Job job) {
        jobRepository.save(job);
    }

    public void deleteJob(Long jobId) {
        jobRepository.deleteById(jobId);
    }

    public Job getJobByJobTitle(String jobTitle) {
        return jobRepository.findByJobTitle(jobTitle);
    }

    public List<Job> getAllJobs(String department) {
        return jobRepository.findJobsByDepartmentName(department);
    }

     public List<Job> getAllJobsBylocation(String location) {
        return jobRepository.findJobsByLocationName(location);
    }

    public List<Job> findJobsByDepartmentAndLocation(String department, String location) {
        return jobRepository.findJobsByDepartmentAndLocation(department, location);
    }

    public List<Job> findJobsByJobTitleAndLocation(String jobTitle, String location) {
        return jobRepository.findJobsByJobTitleAndLocation(jobTitle, location);
    }

    public List<Job> findJobsByJobTitleAndDepartmentAndLocation(String jobTitle, String department, String location) {
        return jobRepository.findJobsByJobTitleAndDepartmentAndLocation(jobTitle, department, location);
    }
    
}
