package com.emranhss.project.entity;


import jakarta.persistence.*;

@Entity
public class Experience {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String company;
    private String position;
    private String fromDate;
    private String toDate;
    private String description;

    @ManyToOne
    private JobSeeker jobSeeker;


    public Experience() {
    }


    public Experience(Long id, String company, String position, String fromDate, String toDate, String description, JobSeeker jobSeeker) {
        this.id = id;
        this.company = company;
        this.position = position;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.description = description;
        this.jobSeeker = jobSeeker;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }
}
