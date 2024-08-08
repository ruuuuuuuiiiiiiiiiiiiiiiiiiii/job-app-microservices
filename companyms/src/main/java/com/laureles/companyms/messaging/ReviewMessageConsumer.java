package com.laureles.companyms.messaging;

import com.laureles.companyms.dto.ReviewMessage;
import com.laureles.companyms.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ReviewMessageConsumer {

    private final CompanyService companyService;

    @RabbitListener(queues = "companyRatingQueue")
    public void consumeMessage(ReviewMessage reviewMessage) {
        companyService.updateCompanyRating(reviewMessage);
    }
}
