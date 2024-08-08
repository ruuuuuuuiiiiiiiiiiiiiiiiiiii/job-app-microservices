package com.laureles.reviewms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reviewTitle")
    private String reviewTitle;

    @Column(name = "reviewContent")
    private String reviewContent;

    @Column(name = "rating")
    private double rating;

    private Long companyId;

}
