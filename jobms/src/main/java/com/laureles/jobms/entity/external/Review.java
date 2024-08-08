package com.laureles.jobms.entity.external;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Review {
    private Long id;
    private String reviewTitle;
    private String reviewContent;
    private double rating;

}
