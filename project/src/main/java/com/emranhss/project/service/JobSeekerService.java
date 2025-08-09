package com.emranhss.project.service;


import com.emranhss.project.entity.JobSeeker;
import com.emranhss.project.repository.IJobSeekerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerService {


    @Autowired
    private IJobSeekerRepo jobSeekerRepo;


    public List<JobSeeker> getAll() {
        return jobSeekerRepo.findAll();
    }

    public Optional<JobSeeker> getById(Long id) {
        return jobSeekerRepo.findById(id);
    }


    public JobSeeker save(JobSeeker jobSeeker) {
        return jobSeekerRepo.save(jobSeeker);
    }


    public void delete(long id) {
        jobSeekerRepo.deleteById(id);
    }

    public JobSeeker getProfileByUserId(int userId) {
        return jobSeekerRepo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Job Seeker not found"));
    }

}
