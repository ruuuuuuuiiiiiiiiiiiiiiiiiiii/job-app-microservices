package com.laureles.reviewms.service;

import com.laureles.reviewms.entity.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);

    Review getReviewById(Long reviewId);

    boolean createReview(Long companyId, Review review);

    boolean updateReviewById(Long reviewId, Review updatedReview);

    boolean deleteReviewById(Long reviewId);
}
