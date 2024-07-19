package com.laureles.jobms.service.impl;

import com.laureles.jobms.clients.CompanyClient;
import com.laureles.jobms.clients.ReviewClient;
import com.laureles.jobms.dto.JobDTO;
import com.laureles.jobms.entity.Job;
import com.laureles.jobms.entity.external.Company;
import com.laureles.jobms.entity.external.Review;
import com.laureles.jobms.mapper.JobMapper;
import com.laureles.jobms.repository.JobRepository;
import com.laureles.jobms.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
    private CompanyClient companyClient;
    private ReviewClient reviewClient;

    public JobServiceImpl(JobRepository jobRepository, CompanyClient companyClient, ReviewClient reviewClient) {
        this.jobRepository = jobRepository;
        this.companyClient = companyClient;
        this.reviewClient = reviewClient;
    }

    private JobDTO convertToDto(Job job) {

        // Rest Template implementation
//        Company company = restTemplate.getForObject("http://COMPANYMS:2021/api/v1/companies/" + job.getCompanyId(),
//                Company.class);

        // OpenFeign Implementation
        Company company = companyClient.getCompany(job.getCompanyId());

        // Rest Template implementation
//        ResponseEntity<List<Review>> reviewResponse = restTemplate.exchange("http://REVIEWMS:2023/api/v1/reviews?companyId=" + job.getCompanyId(),
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Review>>() {
//                });

//        List<Review> reviews = reviewResponse.getBody();

        // OpenFeign Implementation
        List<Review> reviews = reviewClient.getReviews(job.getCompanyId());


        JobDTO jobDTO = JobMapper.mapToJobWithCompanyDTO(job, company, reviews);

        return jobDTO;
    }

    @Override
    public List<JobDTO> findAll() {

        List<Job> jobs = jobRepository.findAll();
        List<JobDTO> jobDTOS = new ArrayList<>();

        return jobs.stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public JobDTO getJobById(Long id) {

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
