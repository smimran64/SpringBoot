package com.emranhss.project.repository;

import com.emranhss.project.entity.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobSeekerRepo extends JpaRepository<JobSeeker, Long> {
}
