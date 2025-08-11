package com.example.HotelBookingManagementSystem.service;


import com.example.HotelBookingManagementSystem.repository.HotelRepository;
import com.example.HotelBookingManagementSystem.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private LocationRepository locationRepository;
}
