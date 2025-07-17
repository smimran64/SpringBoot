package com.emranhss.project.restcontroller;


import com.emranhss.project.dto.CountryResponseDTO;
import com.emranhss.project.entity.Country;
import com.emranhss.project.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryRestController {


    @Autowired
    private CountryService countryService;

    @GetMapping("")
    public ResponseEntity<List<CountryResponseDTO>> getCountries(){

        List<CountryResponseDTO> dtoList = countryService.getAllCountryDTOs();
        return ResponseEntity.ok(dtoList);



    }

    public ResponseEntity<Country> createCountry(@RequestBody Country country){

        Country saved = countryService.saveCountry(country);
        return ResponseEntity.ok(saved);
    }


}
