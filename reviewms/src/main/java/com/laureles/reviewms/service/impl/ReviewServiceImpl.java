package com.laureles.reviewms.service.impl;

import com.laureles.reviewms.entity.Review;
import com.laureles.reviewms.repository.ReviewRepository;
import com.laureles.reviewms.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;


    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);

        if (reviews != null) {
            return reviews;
        } else {
            return null;
        }
    }

    @Override
    public Review getReviewById(Long reviewId) {

        // much efficient
        Review review = reviewRepository.findById(reviewId).orElse(null);

        if (review != null) {
            return review;
        } else {
            return null;
        }

        // inefficient
//        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
//        return reviews.stream()
//                .filter(review -> review.getId().equals(reviewId))
//                .findFirst()
//                .orElse(null);
    }

    @Override
    public boolean createReview(Long companyId, Review review) {
        if (companyId != null) {
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateReviewById(Long reviewId, Review updatedReview) {
        try {
            Review review = reviewRepository.findById(reviewId).orElse(null);

            if (reviewId != null) {
                if (review != null) {
                    review.setReviewTitle(updatedReview.getReviewTitle());
                    review.setReviewContent(updatedReview.getReviewContent());
                    review.setRating(updatedReview.getRating());
                    review.setCompanyId(updatedReview.getCompanyId());

                    reviewRepository.save(review);

                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteReviewById(Long reviewId) {
        try {
            Review review = reviewRepository.findById(reviewId).orElse(null);

            if (review != null) {
                reviewRepository.delete(review);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
