package com.laureles.companyms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "companyDescription")
    private String companyDescription;

    @Column(name = "companyLocation")
    private String companyLocation;

    @Column(name = "companyRating")
    private Double companyRating;

}
