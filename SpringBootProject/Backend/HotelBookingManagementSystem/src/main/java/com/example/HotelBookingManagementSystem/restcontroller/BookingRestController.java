package com.example.HotelBookingManagementSystem.restcontroller;


import com.example.HotelBookingManagementSystem.entity.Booking;
import com.example.HotelBookingManagementSystem.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingRestController {

    private final BookingService bookingService;

    public BookingRestController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }


    @GetMapping("/customer/{customerId}")
    public List<Booking> getBookingsByCustomer(@PathVariable Long customerId) {
        return bookingService.getBookingsByCustomerId(customerId);
    }


    @GetMapping("/hotel/{hotelId}")
    public List<Booking> getBookingsByHotel(@PathVariable int hotelId) {
        return bookingService.getBookingsByHotelId(hotelId);
    }


    @GetMapping("/room/{roomId}")
    public List<Booking> getBookingsByRoom(@PathVariable Long roomId) {
        return bookingService.getBookingsByRoomId(roomId);
    }


    @PostMapping("/save")
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }


    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }
}
