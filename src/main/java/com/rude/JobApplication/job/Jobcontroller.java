package com.rude.JobApplication.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@RequestMapping(value ="/jobs")
@RestController
public class Jobcontroller {
 private JobService jobService;

    public Jobcontroller(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findall(){
       return   ResponseEntity.ok(jobService.findall());
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createjob(@RequestBody Job job){
           jobService.createjob(job);
        return new ResponseEntity<>("Job added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
     Job job=jobService.getJobById(id);
     if(job!=null)
     return new ResponseEntity<>(job, HttpStatus.FOUND);
     else
         return new ResponseEntity<>(job,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        boolean deleted = jobService.deleteById(id);
        if(deleted)
            return new ResponseEntity<>("job deleted successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Not deleted",HttpStatus.NOT_FOUND);
    }

   // @PutMapping("/jobs/{id}")
    @RequestMapping(value = "/jobs/{id}",method = RequestMethod.PUT)
    public ResponseEntity<String> updateById(@PathVariable Long id,@RequestBody Job updated) {
        boolean update=jobService.updateById(id,updated);
        if(update)
            return new ResponseEntity<>("updated",HttpStatus.OK);
        return new ResponseEntity<>("Not updated",HttpStatus.BAD_REQUEST);
    }
}
