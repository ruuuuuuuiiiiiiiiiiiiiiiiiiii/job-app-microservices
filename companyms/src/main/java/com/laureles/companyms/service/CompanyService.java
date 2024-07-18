package com.laureles.companyms.service;

import com.laureles.companyms.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    Company getCompanyById(Long id);

    boolean createCompany(Company company);

    boolean updateCompanyById(Company updatedCompany, Long id);

    boolean deleteCompanyById(Long id);

}
