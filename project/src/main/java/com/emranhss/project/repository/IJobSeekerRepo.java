package com.emranhss.project.repository;

import com.emranhss.project.entity.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IJobSeekerRepo extends JpaRepository<JobSeeker, Long> {


    Optional<JobSeeker> findByUserId(int userId);
}
