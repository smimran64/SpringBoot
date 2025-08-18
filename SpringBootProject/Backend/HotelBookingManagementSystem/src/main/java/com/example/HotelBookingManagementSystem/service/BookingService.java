package com.example.HotelBookingManagementSystem.service;


import com.example.HotelBookingManagementSystem.entity.Booking;
import com.example.HotelBookingManagementSystem.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {


    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }


    public List<Booking> getBookingsByCustomerId(Long customerId) {
        return bookingRepository.findByCustomerId(customerId);
    }


    public List<Booking> getBookingsByHotelId(int hotelId) {
        return bookingRepository.findByHotelId(hotelId);
    }


    public List<Booking> getBookingsByRoomId(Long roomId) {
        return bookingRepository.findByRoomId(roomId);
    }


    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }


    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }


}
