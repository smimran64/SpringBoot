package com.example.HotelBookingManagementSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String rating;
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locationId")
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_Admin_Id")
    private HotelAdmin hotelAdmin;



}
