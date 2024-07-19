package com.laureles.jobms.service.impl;

import com.laureles.jobms.dto.JobWithCompanyDTO;
import com.laureles.jobms.entity.Job;
import com.laureles.jobms.entity.external.Company;
import com.laureles.jobms.mapper.JobMapper;
import com.laureles.jobms.repository.JobRepository;
import com.laureles.jobms.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {
    private JobRepository jobRepository;

    @Autowired
    RestTemplate restTemplate;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    private JobWithCompanyDTO convertToDto(Job job) {

        Company company = restTemplate.getForObject("http://COMPANYMS:2021/api/v1/companies/" + job.getCompanyId(),
                Company.class);

        JobWithCompanyDTO jobWithCompanyDTO = JobMapper.mapToJobWithCompanyDTO(job, company);

        return jobWithCompanyDTO;
    }

    @Override
    public List<JobWithCompanyDTO> findAll() {

        List<Job> jobs = jobRepository.findAll();
        List<JobWithCompanyDTO> jobWithCompanyDTOS = new ArrayList<>();

        return jobs.stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public JobWithCompanyDTO getJobById(Long id) {

        Job job = jobRepository.findById(id).orElse(null);

        return convertToDto(job);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);

        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setSalary(updatedJob.getSalary());
            job.setLocation(updatedJob.getLocation());

            jobRepository.save(job);

            return true;
        }
        return false;
    }
}
