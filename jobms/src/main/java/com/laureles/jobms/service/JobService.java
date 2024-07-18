package com.laureles.jobms.service;

import com.laureles.jobms.dto.JobWithCompanyDTO;
import com.laureles.jobms.entity.Job;

import java.util.List;

public interface JobService {
    List<JobWithCompanyDTO> findAll();
    void createJob(Job job);
    Job getJobById(Long id);
    boolean deleteJobById(Long id);
    boolean updateJobById(Long id, Job job);
}
