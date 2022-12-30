package com.semicolonafrica.airlinebookingsystem.services;

import com.semicolonafrica.airlinebookingsystem.data.model.Airplane;
import com.semicolonafrica.airlinebookingsystem.data.model.BookingEnquiry;
import com.semicolonafrica.airlinebookingsystem.data.model.Passenger;
import com.semicolonafrica.airlinebookingsystem.data.model.Ticket;
import com.semicolonafrica.airlinebookingsystem.exception.AirlineSystemException;
import com.semicolonafrica.airlinebookingsystem.exception.PassengerAlreadyRegisteredException;

public interface PassengerService {
    void registerPassenger(Passenger passenger) throws PassengerAlreadyRegisteredException;

    void login(String email, String password);

    void logout(String email);

    void clearPassenger();

    Airplane airlineBookingEnquiries(BookingEnquiry newBookingEnquiry) throws AirlineSystemException;

    Ticket bookAirline(BookingEnquiry booker);
}
