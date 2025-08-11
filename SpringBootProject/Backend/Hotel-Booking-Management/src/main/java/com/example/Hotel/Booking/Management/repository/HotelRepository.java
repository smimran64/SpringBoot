package com.example.Hotel.Booking.Management.repository;

import com.example.Hotel.Booking.Management.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {


    @Query("select h from  Hotel h where h.location.name= :locationName")
    List<Hotel> findHotelByLocationName(@Param("locationName") String locationName);


    Optional<Hotel>findByName(String name);

}
