package com.laureles.jobms.repository;

import com.laureles.jobms.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
