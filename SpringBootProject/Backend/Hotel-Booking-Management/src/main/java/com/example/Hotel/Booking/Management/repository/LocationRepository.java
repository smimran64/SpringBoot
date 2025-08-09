package com.example.Hotel.Booking.Management.repository;


import com.example.Hotel.Booking.Management.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository  extends JpaRepository<Location, Integer> {
}
