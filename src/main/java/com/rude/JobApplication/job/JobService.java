package com.rude.JobApplication.job;

import java.util.List;

public interface JobService {

    boolean updateById(Long id, Job updated);

    List<Job> findall();
void createjob(Job job);

    Job getJobById(Long id);

    boolean deleteById(Long id);
}
