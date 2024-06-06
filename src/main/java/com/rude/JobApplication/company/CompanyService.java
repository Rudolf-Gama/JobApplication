package com.rude.JobApplication.company;

import java.util.List;

public interface CompanyService {
     boolean updateCompany(Long id, Company updated);

    List<Company> getAllCompanies();

    void createcompany(Company comp);

    boolean deletecompany(Long id);

    Company findcompanybyid(Long id);
}
