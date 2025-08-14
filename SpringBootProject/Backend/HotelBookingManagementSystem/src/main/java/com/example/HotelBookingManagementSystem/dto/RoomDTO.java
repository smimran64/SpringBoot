package com.example.HotelBookingManagementSystem.dto;

public class RoomDTO {

    private Long id;
    private String roomType;
    private String image;
    private int totalRooms;
    private int adults;
    private int children;
    private Double price;
    private int hotelId;


    public RoomDTO() {
    }

    public RoomDTO(Long id, String roomType, String image, int totalRooms, int adults, int children, Double price, int hotelId) {
        this.id = id;
        this.roomType = roomType;
        this.image = image;
        this.totalRooms = totalRooms;
        this.adults = adults;
        this.children = children;
        this.price = price;
        this.hotelId = hotelId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }
}
