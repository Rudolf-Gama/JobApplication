package com.rude.JobApplication.company.impl;

import com.rude.JobApplication.company.Company;
import com.rude.JobApplication.company.CompanyRepository;
import com.rude.JobApplication.company.CompanyService;
import com.rude.JobApplication.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Companyserviceimpl implements CompanyService {

   CompanyRepository companyRepository;

    public Companyserviceimpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public boolean updateCompany(Long id, Company updated) {
        Optional<Company> companyOptional=companyRepository.findById(id);
        if(companyOptional.isPresent())
        {
            Company company=companyOptional.get();
            company.setName(updated.getName());
            company.setDescription(updated.getDescription());
            company.setJobs(updated.getJobs());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public List<Company> getAllCompanies() {
       return companyRepository.findAll();
    }

    @Override
    public void createcompany(Company comp) {
         companyRepository.save(comp);
    }

    @Override
    public boolean deletecompany(Long id) {
        try {
            companyRepository.deleteById(id);
            return true;
        }
        catch (Exception e)
        {        return false;
        }
    }

    @Override
    public Company findcompanybyid(Long id) {
       return companyRepository.findById(id).orElse(null);
    }


}
