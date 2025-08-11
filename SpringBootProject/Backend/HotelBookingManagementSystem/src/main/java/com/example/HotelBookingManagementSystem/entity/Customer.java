package com.example.HotelBookingManagementSystem.entity;


import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private String phone;
    private String address;
    private String gender;
    private Date dateOfBirth;
    private String image;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}
