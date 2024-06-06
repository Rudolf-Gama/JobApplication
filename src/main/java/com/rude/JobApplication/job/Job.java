package com.rude.JobApplication.job;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rude.JobApplication.company.Company;
import jakarta.persistence.*;

@Entity
//@Table(name = "JobTable")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private  String name;
    private  String Description;
    private String maxSalary;
    private String minSalary;
    private String location;
    @JsonIgnore
    @ManyToOne
    private Company company;
    public Job() {
    }

    public Job(Long id, String name, String Description, String maxSalary, String minSalary, String  location){
        this.id=id;
        this.name=name;
        this.Description=Description;
        this.maxSalary=maxSalary;
        this.minSalary=minSalary;
        this.location = location;
    }

    public Job(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

