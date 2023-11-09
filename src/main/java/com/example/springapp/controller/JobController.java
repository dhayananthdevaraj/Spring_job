package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Job;
import com.example.springapp.service.JobService;

@RestController
@RequestMapping("api/job")
public class JobController {
    
    @Autowired
    private JobService jobService;

    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }
    @GetMapping("/department/{department}")
    public List<Job> getJobsByDepartment(@PathVariable String department) {
        return jobService.getAllJobs(department);
    }

    @GetMapping("/location/{location}")
    public List<Job> getJobsByLocation(@PathVariable String location) {
        return jobService.getAllJobs(location);
    }

    @GetMapping("/department/{department}/location/{location}")
    public List<Job> getJobsByDepartmentAndLocation(@PathVariable String department, @PathVariable String location) {
        return jobService.findJobsByDepartmentAndLocation(department, location);
    }

    @GetMapping("/jobTitle/{jobTitle}/location/{location}")
    public List<Job> getJobsByJobTitleAndLocation(@PathVariable String jobTitle, @PathVariable String location) {
        return jobService.findJobsByJobTitleAndLocation(jobTitle, location);
    }

    @GetMapping("/jobTitle/{jobTitle}/department/{department}/location/{location}")
    public List<Job> getJobsByJobTitleAndDepartmentAndLocation(@PathVariable String jobTitle, @PathVariable String department, @PathVariable String location) {
        return jobService.findJobsByJobTitleAndDepartmentAndLocation(jobTitle, department, location);
    }


    @GetMapping("/{jobTitle}")
    public Job getJobByJobTitle(@PathVariable String jobTitle) {
        return jobService.getJobByJobTitle(jobTitle);
    }

    @PutMapping("/{id}")
    public void updateJob(@PathVariable Long id, @RequestBody Job job) {
        jobService.updateJob(job);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
    }
}
