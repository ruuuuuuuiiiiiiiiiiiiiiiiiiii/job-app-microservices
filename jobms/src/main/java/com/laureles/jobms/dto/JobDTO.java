package com.laureles.jobms.dto;

import com.laureles.jobms.entity.external.Company;
import com.laureles.jobms.entity.external.Review;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JobDTO {

    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String salary;
    private String location;
    private Company company;
    private List<Review> reviews;

}
