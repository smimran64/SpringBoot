package com.example.HotelBookingManagementSystem.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private String phone;
    private String image;

    @Enumerated(value = EnumType.STRING)
    private Role role;

}
