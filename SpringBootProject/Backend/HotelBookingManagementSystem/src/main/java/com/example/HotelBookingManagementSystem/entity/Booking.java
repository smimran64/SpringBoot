package com.example.HotelBookingManagementSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contractPersonName;
    private String phone;
    private String checkIn;
    private String checkOut;
    private double advanceAmount;
    private double totalAmount;
    private double dueAmount;

    @ManyToOne
    @JoinColumn(name = "customerId",nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "hotelId", nullable = false)
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "roomId",nullable = false)
    private Room room;

}
