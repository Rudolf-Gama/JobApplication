package com.rude.JobApplication.company;

import com.rude.JobApplication.job.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
    return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<String> updateCompany(@PathVariable Long id,@RequestBody Company updated) {
        boolean update=companyService.updateCompany(id,updated);
        if(update)
            return new ResponseEntity<>("updated Company",HttpStatus.OK);
        return new ResponseEntity<>("Not updated Company",HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<String> createcompany(@RequestBody Company comp){
        companyService.createcompany(comp);
        return new ResponseEntity<>("company added successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletecompany(@PathVariable Long id) {
      boolean delete=companyService.deletecompany(id);
      if(delete)
          return new ResponseEntity<>("Company Deleted",HttpStatus.FOUND);
      else
          return new ResponseEntity<>("company not deleted",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> findcompanybyid(@PathVariable Long id) {
        Company company = companyService.findcompanybyid(id);
        if (company != null) {
            return  ResponseEntity.ok((company));
        }
        else {
            return new ResponseEntity<>(company,HttpStatus.NOT_FOUND);
        }
    }
}
