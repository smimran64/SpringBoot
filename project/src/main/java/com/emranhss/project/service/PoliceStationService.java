package com.emranhss.project.service;


import com.emranhss.project.dto.DistrictResponseDTO;
import com.emranhss.project.entity.District;
import com.emranhss.project.entity.PoliceStation;
import com.emranhss.project.repository.IDistrictRepo;
import com.emranhss.project.repository.IPoliceStationRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoliceStationService {


    @Autowired
    private IPoliceStationRepo iPoliceStationRepo;
    @Autowired
    private IDistrictRepo districtRepo;

    @Transactional
    public void saveOrUpdate(PoliceStation ps) {
        Integer districtId = ps.getDistrict().getId();

        District d = districtRepo.findById(districtId)
                .orElseThrow(() -> new IllegalArgumentException("District not found with ID: " + districtId));

        ps.setDistrict(d);

        iPoliceStationRepo.save(ps);
    }

public List<PoliceStation>findAll(){
    return iPoliceStationRepo.findAll();
}

public Optional<PoliceStation>findById(Integer id){
    return iPoliceStationRepo.findById(id);
}
public void deleteById(Integer id){
    iPoliceStationRepo.deleteById(id);
}
}
