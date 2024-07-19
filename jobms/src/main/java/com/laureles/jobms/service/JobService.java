package com.laureles.jobms.service;
import com.laureles.jobms.dto.JobDTO;
import com.laureles.jobms.entity.Job;

import java.util.List;

public interface JobService {
    List<JobDTO> findAll();
    void createJob(Job job);
    JobDTO getJobById(Long id);
    boolean deleteJobById(Long id);
    boolean updateJobById(Long id, Job job);
}
