package com.laureles.jobms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "minSalary")
    private String minSalary;

    @Column(name = "maxSalary")
    private String maxSalary;

    @Column(name = "salary")
    private String salary;

    @Column(name = "location")
    private String location;

    private Long companyId;

}
