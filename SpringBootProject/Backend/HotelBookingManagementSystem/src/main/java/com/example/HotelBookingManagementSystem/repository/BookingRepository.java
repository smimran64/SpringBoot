package com.example.HotelBookingManagementSystem.repository;

import com.example.HotelBookingManagementSystem.entity.Booking;
import com.example.HotelBookingManagementSystem.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {



    List<Booking> findByCustomerId(Long customerId);

    List<Booking> findByHotelId(int hotelId);


    List<Booking> findByRoomId(Long roomId);
}
