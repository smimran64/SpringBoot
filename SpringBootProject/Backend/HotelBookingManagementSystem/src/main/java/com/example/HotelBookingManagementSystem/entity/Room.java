package com.example.HotelBookingManagementSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomType;
    private int totalRooms;
    private String adults;
    private String children;
    private Double price;
    private int availableRooms;
    private int bookedRooms;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

}
