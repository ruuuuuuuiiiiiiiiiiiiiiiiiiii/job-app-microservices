package com.laureles.jobms.mapper;

import com.laureles.jobms.dto.JobWithCompanyDTO;
import com.laureles.jobms.entity.Job;
import com.laureles.jobms.entity.external.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class JobMapper {

    public static JobWithCompanyDTO mapToJobWithCompanyDTO(Job job, Company company) {
        JobWithCompanyDTO jobWithCompanyDTO = new JobWithCompanyDTO();

        jobWithCompanyDTO.setId(job.getId());
        jobWithCompanyDTO.setTitle(job.getTitle());
        jobWithCompanyDTO.setDescription(job.getDescription());
        jobWithCompanyDTO.setMinSalary(job.getMinSalary());
        jobWithCompanyDTO.setMaxSalary(job.getMaxSalary());
        jobWithCompanyDTO.setSalary(job.getSalary());
        jobWithCompanyDTO.setLocation(job.getLocation());
        jobWithCompanyDTO.setCompany(company);

        return jobWithCompanyDTO;
    }
}
