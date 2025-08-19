package com.example.HotelBookingManagementSystem.repository;


import com.example.HotelBookingManagementSystem.entity.Admin;
import com.example.HotelBookingManagementSystem.entity.HotelAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByUserId(Long id);


    Optional<Admin> findByEmail(String email);
}
