package com.laureles.jobms.controller;

import com.laureles.jobms.dto.JobWithCompanyDTO;
import com.laureles.jobms.entity.Job;
import com.laureles.jobms.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobWithCompanyDTO>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);

        return new ResponseEntity<>("Job Added!", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobWithCompanyDTO> getJobById(@PathVariable("id") Long id) {
        JobWithCompanyDTO jobWithCompanyDTO = jobService.getJobById(id);

        if (jobWithCompanyDTO != null) {
            return new ResponseEntity<>(jobWithCompanyDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable("id") Long id){

        boolean deleted = jobService.deleteJobById(id);

        if (deleted) {
            return new ResponseEntity<>("Deleted Successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable("id") Long id, @RequestBody Job updatedJob) {

        boolean updated = jobService.updateJobById(id, updatedJob);

        if (updated) {
            return new ResponseEntity<>("Updated Successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
