package com.semicolonafrica.airlinebookingsystem.data.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Passenger {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String id;
    private String address;
    private boolean isActive;
    private String password;
    private static final List<BookingEnquiry> bookingEnquiries = new ArrayList<>();
    private static final List<Ticket> tickets = new ArrayList<>();


    public Passenger(String id, String firstName, String lastName, String email, String password, String address, String phoneNumber) {
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(id, passenger.id)
                || Objects.equals(email, passenger.email)
                || Objects.equals(phoneNumber, passenger.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, phoneNumber);
    }

    public String getPassword() {
        return password;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getEmail() {
        return email;
    }


    public void setBookingEnquiries(BookingEnquiry bookingEnquiry) {
        bookingEnquiries.add(bookingEnquiry);
    }


    public void addTickets(Ticket newTicket) {
        tickets.add(newTicket);
    }
}
