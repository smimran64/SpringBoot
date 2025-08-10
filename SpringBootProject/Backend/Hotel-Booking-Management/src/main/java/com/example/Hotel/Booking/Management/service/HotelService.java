package com.example.Hotel.Booking.Management.service;


import com.example.Hotel.Booking.Management.entity.Hotel;
import com.example.Hotel.Booking.Management.entity.Location;
import com.example.Hotel.Booking.Management.repository.HotelRepository;
import com.example.Hotel.Booking.Management.repository.LocationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class HotelService {

    private HotelRepository hotelRepository;

    @Autowired
    private LocationRepository locationRepository;


    @Value("src/main/resources/static/images")
    private String uploadDir;



    public List<Hotel> getAllHotels() {

        return hotelRepository.findAll();
    }

    public void saveHotel(Hotel hotel, MultipartFile imageFile) throws IOException {

        if (imageFile!= null && !imageFile.isEmpty()) {
            String imageFileName = saveImage(imageFile,hotel);

            hotel.setImage(imageFileName);
        }

        Location location = locationRepository.findById(hotel.getLocation().getId())
                .orElseThrow(() -> new EntityNotFoundException("Location with id: " + hotel.getLocation().getId() + " not found!"));

        hotel.setLocation(location);

        hotelRepository.save(hotel);
    }

    public Hotel findHotelById(int id) {

        return hotelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel with id: " + id + " not found!"));
    }


    public void updateHotel(int id,Hotel updatehotel, MultipartFile imageFile) throws IOException {
       Hotel existingHotel = hotelRepository.findById(id)
               .orElseThrow(() -> new EntityNotFoundException("Hotel with id: " + id + " not found!"));

       existingHotel.setName(updatehotel.getName());
       existingHotel.setAddress(updatehotel.getAddress());
       existingHotel.setRating(updatehotel.getRating());
       existingHotel.setMaximumPrice(updatehotel.getMaximumPrice());
       existingHotel.setMinimumPrice(updatehotel.getMinimumPrice());
       existingHotel.setImage(updatehotel.getImage());

 //update locations
        Location location = locationRepository.findById(updatehotel.getLocation().getId())
                .orElseThrow(() -> new EntityNotFoundException("Location with id: " + updatehotel.getLocation().getId() + " not found!"));

        existingHotel.setLocation(location);


        //update image

        if (imageFile!= null && !imageFile.isEmpty()) {
            String fileName = saveImage(imageFile,existingHotel);

            existingHotel.setImage(fileName);
        }
    }

    public List<Hotel>findHotelByLocationName(String locationName) {
        return hotelRepository.findHotelByLocationName(locationName);
    }



    private  String saveImage(MultipartFile file, Hotel hotel) throws IOException {

        Path uploadPath = Paths.get(uploadDir+ "/hotels");

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = hotel.getName()+"_"+ UUID.randomUUID();

        Path filePath = uploadPath.resolve(fileName);

        Files.copy(file.getInputStream(), filePath);

        return fileName;


    }


}
