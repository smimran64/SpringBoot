package com.example.HotelBookingManagementSystem.service;


import com.example.HotelBookingManagementSystem.dto.HotelDTO;
import com.example.HotelBookingManagementSystem.entity.Hotel;
import com.example.HotelBookingManagementSystem.entity.HotelAdmin;
import com.example.HotelBookingManagementSystem.entity.Location;
import com.example.HotelBookingManagementSystem.repository.HotelAdminRepository;
import com.example.HotelBookingManagementSystem.repository.HotelRepository;
import com.example.HotelBookingManagementSystem.repository.LocationRepository;
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
import java.util.stream.Collectors;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private HotelAdminRepository hotelAdminRepository;

    @Value("src/main/resources/static/images")
    private String uploadDir;

    public List<HotelDTO> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream()
                .map(hotel -> new HotelDTO(
                        hotel.getId(),
                        hotel.getName(),
                        hotel.getAddress(),
                        hotel.getRating(),
                        hotel.getImage()
                ))
                .collect(Collectors.toList());
    }


    public void saveHotel(Hotel hotel, MultipartFile imageFile) throws IOException {

        if (imageFile!= null && !imageFile.isEmpty()) {
            String imageFileName = saveImage(imageFile,hotel);

            hotel.setImage(imageFileName);
        }

        Location location = locationRepository.findById(hotel.getLocation().getId())
                .orElseThrow(() -> new EntityNotFoundException("Location with id: " + hotel.getLocation().getId() + " not found!"));

        hotel.setLocation(location);

        HotelAdmin hotelAdmin = hotelAdminRepository.findById(hotel.getHotelAdmin().getId())
                        .orElseThrow(() -> new EntityNotFoundException("HotelAdmin with id: " + hotel.getHotelAdmin().getId() + " not found!"));
        hotel.setHotelAdmin(hotelAdmin);

        hotelRepository.save(hotel);
    }



    public Hotel findHotelById(int id) {

        return hotelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel with id: " + id + " not found!"));
    }


    public Hotel findHotelByName(String name) {

        return hotelRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Hotel with id: " + name + " not found!"));
    }


    public List<Hotel>findHotelByLocationName(String locationName) {
        return hotelRepository.findHotelByLocationName(locationName);
    }

    public List<Hotel> findHotelByAdminId(String HotelAdminId) {
        return hotelRepository.findHotelByHotelAdminId(HotelAdminId);
    }

    public Hotel updateHotel(int id, Hotel updatehotel, MultipartFile imageFile) throws IOException {
        Hotel existingHotel = hotelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel with id: " + id + " not found!"));

        existingHotel.setName(updatehotel.getName());
        existingHotel.setAddress(updatehotel.getAddress());
        existingHotel.setRating(updatehotel.getRating());
        existingHotel.setImage(updatehotel.getImage());

        //update locations
        Location location = locationRepository.findById(updatehotel.getLocation().getId())
                .orElseThrow(() -> new EntityNotFoundException("Location with id: " + updatehotel.getLocation().getId() + " not found!"));

        existingHotel.setLocation(location);


        HotelAdmin hotelAdmin = hotelAdminRepository.findById(updatehotel.getHotelAdmin().getId())
                .orElseThrow(() -> new EntityNotFoundException("HotelAdmin with id: " + updatehotel.getHotelAdmin().getId() + " not found!"));


        existingHotel.setHotelAdmin(hotelAdmin);
        //update image

        if (imageFile!= null && !imageFile.isEmpty()) {
            String fileName = saveImage(imageFile,existingHotel);

            existingHotel.setImage(fileName);
        }


        return hotelRepository.save(existingHotel);
    }

    public boolean deleteHotel(int id) {
        if (hotelRepository.existsById(id)) {
            hotelRepository.deleteById(id);
            return true;
        }
        return false;
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
