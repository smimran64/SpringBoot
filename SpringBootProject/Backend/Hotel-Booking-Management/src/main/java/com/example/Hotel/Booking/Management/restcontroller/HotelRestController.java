package com.example.Hotel.Booking.Management.restcontroller;

import com.example.Hotel.Booking.Management.entity.Hotel;
import com.example.Hotel.Booking.Management.service.HotelService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/hotel")
@CrossOrigin("*")
public class HotelRestController {

    @Autowired
    private HotelService hotelService;


    @GetMapping("/")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return ResponseEntity.ok(hotels);
    }

    @PostMapping("save")
    public ResponseEntity<Map<String, String>> saveHotel(
            @RequestPart(value = "hotel") String hotelJson,
            @RequestParam(value = "image") MultipartFile file
    ) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        Hotel hotel = objectMapper.readValue(hotelJson, Hotel.class);

        try {
            Map<String, String> response = new HashMap<>();

            response.put("Message", "Hotel saved successfully");

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {

            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("Message", "Hotel save failed");

            return new ResponseEntity<>(errorResponse, HttpStatus.OK);

        }


    }

}


