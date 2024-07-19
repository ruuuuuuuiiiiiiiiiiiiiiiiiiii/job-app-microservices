package com.laureles.jobms.clients;

import com.laureles.jobms.entity.external.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "REVIEWMS")
public interface ReviewClient {

    @GetMapping("/api/v1/reviews")
    List<Review> getReviews(@RequestParam("companyId") Long companyId);

}
