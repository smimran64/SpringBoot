package com.example.HotelBookingManagementSystem.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "amenities")
public class HotelAmenities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean freeWifi;
    private boolean freeParking;
    private boolean swimmingPool;
    private boolean gym;
    private boolean restaurant;
    private boolean roomService;
    private boolean airConditioning;
    private boolean laundryService;
    private boolean wheelchairAccessible;
    private boolean healthServices;
    private boolean playGround;
    private boolean airportSuttle;
    private boolean breakFast;

    @OneToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;


//    @OneToMany
//    @JoinColumn(name = "hotel_id")
//    private Hotel hotel;




}
