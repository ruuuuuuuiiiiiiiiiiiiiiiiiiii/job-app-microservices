package com.laureles.companyms.controller;

import com.laureles.companyms.service.CompanyService;
import com.laureles.companyms.entity.Company;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("id") Long id) {
        Company company = companyService.getCompanyById(id);

        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company) {

        boolean isCreated = companyService.createCompany(company);

        if (isCreated) {
            return new ResponseEntity<>("Created Successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanyById(@RequestBody Company updatedCompany, @PathVariable("id") Long id) {


        boolean isUpdated = companyService.updateCompanyById(updatedCompany, id);

        if (isUpdated) {
            return new ResponseEntity<>("Updated Successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable("id") Long id) {

        boolean isDeleted = companyService.deleteCompanyById(id);

        if (isDeleted) {
            return new ResponseEntity<>("Deleted Successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Company Not Found!", HttpStatus.NOT_FOUND);
        }
    }




}
