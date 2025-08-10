package com.emranhss.project.dto;

import com.emranhss.project.entity.Education;

public class EducationDTO {

    private Long id;
    private String level;
    private String institute;
    private String board;
    private String result;
    private String year;


    public EducationDTO(Long id, String level, String institute, String board, String result, String year) {
        this.id = id;
        this.level = level;
        this.institute = institute;
        this.board = board;
        this.result = result;
        this.year = year;
    }

    // ✅ Add this constructor to support mapping
    public EducationDTO(Education education) {
        this.id = education.getId();
        this.level = education.getLevel();
        this.institute = education.getInstitute();
        this.board = education.getBoard();
        this.result = education.getResult();
        this.year = education.getYear();
    }

    // Getters and setters...


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}





