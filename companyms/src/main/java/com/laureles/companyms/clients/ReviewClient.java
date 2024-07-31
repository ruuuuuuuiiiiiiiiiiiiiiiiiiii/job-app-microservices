package com.laureles.companyms.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "REVIEWMS")
public interface ReviewClient {

    @GetMapping("/api/v1/reviews/averageRating")
    Double getAveragedRatingForCompany(@RequestParam("companyId") Long companyId);

}
