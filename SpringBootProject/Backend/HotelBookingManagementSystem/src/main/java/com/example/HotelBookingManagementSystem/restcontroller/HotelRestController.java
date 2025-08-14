package com.example.HotelBookingManagementSystem.restcontroller;

import com.example.HotelBookingManagementSystem.dto.HotelDTO;
import com.example.HotelBookingManagementSystem.entity.Hotel;
import com.example.HotelBookingManagementSystem.entity.HotelAdmin;
import com.example.HotelBookingManagementSystem.entity.Location;
import com.example.HotelBookingManagementSystem.repository.HotelAdminRepository;
import com.example.HotelBookingManagementSystem.repository.HotelRepository;
import com.example.HotelBookingManagementSystem.repository.LocationRepository;
import com.example.HotelBookingManagementSystem.repository.UserRepository;
import com.example.HotelBookingManagementSystem.service.HotelService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/hotel")
public class HotelRestController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private HotelAdminRepository hotelAdminRepository;

    @Autowired
    private LocationRepository locationRepository;


    @GetMapping("/all")
    public ResponseEntity<List<HotelDTO>> getAllHotels() {
        List<HotelDTO> hotels = hotelService.getAllHotels();
        return ResponseEntity.ok(hotels);
    }


    @PostMapping("/save/")
    public ResponseEntity<?> saveHotel(
            @RequestPart("hotel") HotelDTO hotelDTO,
            @RequestPart(value = "image", required = false) MultipartFile image,
            Authentication authentication
    ) {
        try {
            // Get logged-in admin from authentication
            String username = authentication.getName();
            HotelAdmin admin = hotelAdminRepository.findByUserEmail(username)
                    .orElseThrow(() -> new RuntimeException("Admin not found"));

            // Save hotel with admin info using DTO
            hotelService.saveHotel(hotelDTO, image, admin);

            return ResponseEntity.ok(Map.of("Message", "Hotel saved successfully"));

        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("Message", e.getMessage()));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("Message", "Image upload failed", "Error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("Message", "Hotel save failed", "Error", e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> findHotelById(@PathVariable int id) {

        try {
            Hotel hotel = hotelService.findHotelById(id);
            return ResponseEntity.ok(hotel);

        } catch (RuntimeException e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }
    }

    @GetMapping("/h/searchhotel")
    public ResponseEntity<List<Hotel>> findHotelByLocationName(@RequestParam(value = "locationName") String locationName) {

        List<Hotel> hotels = hotelService.findHotelByLocationName(locationName);
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/searchByHotelAdminId")
    public ResponseEntity<List<Hotel>> findHotelByHotelAdminId(@RequestParam(value = "hotelAdminId") String hotelAdminId) {
        List<Hotel> hotels = hotelService.findHotelByAdminId(hotelAdminId);
        return ResponseEntity.ok(hotels);
    }


    @GetMapping("/h/searchhotelname")
    public ResponseEntity<Hotel> findHotelByName(@RequestParam(value = "name") String name) {

        Hotel hotels = hotelService.findHotelByName(name);
        return ResponseEntity.ok(hotels);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable int id) {
        try {
            hotelService.deleteHotel(id);
            return ResponseEntity.ok("Hotel deleted successfully");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Hotel> updateHotel(
            @PathVariable int id,
            @RequestPart Hotel hotel,
            @RequestParam(value = "image", required = true) MultipartFile file
    )

            throws IOException {
        Hotel updatedHotel = hotelService.updateHotel(id, hotel, file);
        return ResponseEntity.ok(updatedHotel);
    }

}
