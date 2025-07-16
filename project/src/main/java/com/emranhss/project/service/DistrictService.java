package com.emranhss.project.service;


import com.emranhss.project.dto.DistrictResponseDTO;
import com.emranhss.project.entity.District;
import com.emranhss.project.repository.IDistrictRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    @Autowired
    private IDistrictRepo districtRepo;

    public void save(District district){
        districtRepo.save(district);
    }

    public List<District>getAllDistrict(){
        return districtRepo.findAll();
    }

    public List<DistrictResponseDTO>getAllDistrictResponseDTOS(){
        List<District>districts = getAllDistrict();

        return districts.stream().map(d->{
            DistrictResponseDTO dto = new DistrictResponseDTO();
            dto.setId(d.getId());
            dto.setName(d.getName());

            // map policeStations to their ids only

            List<Integer> psIds = d.getPoliceStations().stream()
                    .map(ps -> ps.getId()).toList();

            dto.setPoliceStations(psIds);

            return dto;
        }).toList();
    }

    public District getDistrictById(int id){
        return districtRepo.findById(id).get();
    }


    public void deleteDistrictById(int id){

        districtRepo.deleteById(id);
    }

    public District getDistrictByName(String name){

        return districtRepo.findByName(name);
    }


}
