package com.laureles.companyms.service.impl;

import com.laureles.companyms.entity.Company;
import com.laureles.companyms.repository.CompanyRepository;
import com.laureles.companyms.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean createCompany(Company company) {
        try {
            companyRepository.save(company);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateCompanyById(Company updatedCompany, Long id) {
        Optional<Company> jobOptional = companyRepository.findById(id);

        if (jobOptional.isPresent()) {
            Company company = jobOptional.get();
            company.setCompanyName(updatedCompany.getCompanyName());
            company.setCompanyDescription(updatedCompany.getCompanyDescription());
            company.setCompanyLocation(updatedCompany.getCompanyLocation());

            companyRepository.save(company);

            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        try {
            if (companyRepository.existsById(id)) {
                companyRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
