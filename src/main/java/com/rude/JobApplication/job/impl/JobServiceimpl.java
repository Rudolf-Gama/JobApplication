package com.rude.JobApplication.job.impl;

import com.rude.JobApplication.job.Job;
import com.rude.JobApplication.job.JobRepository;
import com.rude.JobApplication.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceimpl implements JobService {
   // private List<Job> jobs = new ArrayList<>();
    private Long nextid=1L;
 JobRepository jobRepository;

    public JobServiceimpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public boolean updateById(Long id, Job updated) {
        Optional<Job> jobOptional=jobRepository.findById(id);

//        for (Job job : jobs
//        ) {
           // if (job.getId().equals(id))
        if(jobOptional.isPresent())
            {
                Job job=jobOptional.get();
                job.setName(updated.getName());
                job.setDescription(updated.getDescription());
                job.setMaxSalary(updated.getMaxSalary());
                job.setMinSalary(updated.getMinSalary());
                job.setLocation(updated.getLocation());
                jobRepository.save(job);
                return true;
            }
        return false;
    }
    @Override
    public List<Job> findall() {
        return jobRepository.findAll();
    } // return jobs;

    @Override
    public void createjob(Job job) {
        job.setId(nextid++);
        jobRepository.save(job);
    }  // jobs.add(job);

    @Override
    public Job getJobById(Long id) {
//        for (Job job:
//                jobs) {
//            if(job.getId().equals(id))
//            {
//                return job;
//            }
//        }
//        return null;
      return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
//        Iterator<Job> ite=jobs.iterator();
//        while(ite.hasNext()){
//            Job job=ite.next();
//            if(job.getId().equals(id))
//            {
//                ite.remove();
//                return true;
//            }
//        }        return false;
        try {
            jobRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}