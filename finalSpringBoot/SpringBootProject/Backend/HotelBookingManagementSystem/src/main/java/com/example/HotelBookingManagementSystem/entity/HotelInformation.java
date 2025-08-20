package com.example.HotelBookingManagementSystem.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "hotelInfo")
public class HotelInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String ownerInfo;

    @Column(length = 1000)
    private String description;

    @Column(length = 1000)
    private String hotelPolicy;

    @OneToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;
}
