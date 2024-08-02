package com.laureles.jobms.clients;

import com.laureles.jobms.entity.external.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COMPANYMS",
        url = "${company-service.url}")
public interface CompanyClient {

    @GetMapping("/api/v1/companies/{id}")
    Company getCompany(@PathVariable("id") Long companyId);
}
