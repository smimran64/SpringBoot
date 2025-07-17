package com.emranhss.project.dto;

import com.emranhss.project.entity.District;

import java.util.List;

public class DivisionResponseDTO {

    private int id;
    private String name;
    private List<Integer>districts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getDistricts() {
        return districts;
    }

    public void setDistricts(List<Integer> districts) {
        this.districts = districts;
    }
}
