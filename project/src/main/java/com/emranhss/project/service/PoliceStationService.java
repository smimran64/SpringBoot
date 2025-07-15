package com.emranhss.project.service;


import com.emranhss.project.entity.PoliceStation;
import com.emranhss.project.repository.IPoliceStationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoliceStationService {


    @Autowired
    private IPoliceStationRepo iPoliceStationRepo;

public void saveOrUpdate(PoliceStation ps){
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
