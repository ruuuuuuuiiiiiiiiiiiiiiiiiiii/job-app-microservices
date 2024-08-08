package com.laureles.reviewms.messaging;

import com.laureles.reviewms.dto.ReviewMessage;
import com.laureles.reviewms.entity.Review;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ReviewMessageProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(Review review) {
        ReviewMessage reviewMessage = new ReviewMessage();
        reviewMessage.setId(review.getId());
        reviewMessage.setTitle(review.getReviewTitle());
        reviewMessage.setDescription(review.getReviewContent());
        reviewMessage.setRating(review.getRating());
        reviewMessage.setCompanyId(review.getCompanyId());
        rabbitTemplate.convertAndSend("companyRatingQueue", reviewMessage);
    }
}
