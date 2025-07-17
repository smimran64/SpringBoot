package com.emranhss.project.dto;

import com.emranhss.project.entity.Division;

import java.util.List;

public class CountryResponseDTO {


    private int id;
    private String name;
    private List<Integer> divisions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getDivisions() {
        return divisions;
    }

    public void setDivisions(List<Integer> divisions) {
        this.divisions = divisions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}