package com.example.Hotel.Booking.Management.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String roomType;
    private String image;
    private double price;
    private int area;
    private int adultNo;
    private int childNo;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotelId")
    Hotel hotel;
}
