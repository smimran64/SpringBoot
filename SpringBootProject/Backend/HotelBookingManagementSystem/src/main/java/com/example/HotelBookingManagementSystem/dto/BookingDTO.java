package com.example.HotelBookingManagementSystem.dto;

public class BookingDTO {
        private Long id;
        private String contractPersonName;
        private String phone;
        private String checkIn;
        private String checkOut;
        private double advanceAmount;
        private double totalAmount;
        private double dueAmount;
        private int numberOfRooms;

        private CustomerDTO customerdto;
        private HotelDTO hoteldto;
        private RoomDTO roomdto;


        public BookingDTO() {
        }

        public BookingDTO(Long id, String contractPersonName, String phone, String checkIn, String checkOut, double advanceAmount, double totalAmount, double dueAmount, int numberOfRooms, CustomerDTO customerdto, HotelDTO hoteldto, RoomDTO roomdto) {
                this.id = id;
                this.contractPersonName = contractPersonName;
                this.phone = phone;
                this.checkIn = checkIn;
                this.checkOut = checkOut;
                this.advanceAmount = advanceAmount;
                this.totalAmount = totalAmount;
                this.dueAmount = dueAmount;
                this.numberOfRooms = numberOfRooms;
                this.customerdto = customerdto;
                this.hoteldto = hoteldto;
                this.roomdto = roomdto;
        }


        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getContractPersonName() {
                return contractPersonName;
        }

        public void setContractPersonName(String contractPersonName) {
                this.contractPersonName = contractPersonName;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getCheckIn() {
                return checkIn;
        }

        public void setCheckIn(String checkIn) {
                this.checkIn = checkIn;
        }

        public String getCheckOut() {
                return checkOut;
        }

        public void setCheckOut(String checkOut) {
                this.checkOut = checkOut;
        }

        public double getAdvanceAmount() {
                return advanceAmount;
        }

        public void setAdvanceAmount(double advanceAmount) {
                this.advanceAmount = advanceAmount;
        }

        public double getTotalAmount() {
                return totalAmount;
        }

        public void setTotalAmount(double totalAmount) {
                this.totalAmount = totalAmount;
        }

        public double getDueAmount() {
                return dueAmount;
        }

        public void setDueAmount(double dueAmount) {
                this.dueAmount = dueAmount;
        }

        public int getNumberOfRooms() {
                return numberOfRooms;
        }

        public void setNumberOfRooms(int numberOfRooms) {
                this.numberOfRooms = numberOfRooms;
        }

        public CustomerDTO getCustomerdto() {
                return customerdto;
        }

        public void setCustomerdto(CustomerDTO customerdto) {
                this.customerdto = customerdto;
        }

        public HotelDTO getHoteldto() {
                return hoteldto;
        }

        public void setHoteldto(HotelDTO hoteldto) {
                this.hoteldto = hoteldto;
        }

        public RoomDTO getRoomdto() {
                return roomdto;
        }

        public void setRoomdto(RoomDTO roomdto) {
                this.roomdto = roomdto;
        }
}
