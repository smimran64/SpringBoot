package com.example.HotelBookingManagementSystem.repository;

import com.example.HotelBookingManagementSystem.entity.HotelAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelAdminRepository extends JpaRepository<HotelAdmin, Integer> {

}
