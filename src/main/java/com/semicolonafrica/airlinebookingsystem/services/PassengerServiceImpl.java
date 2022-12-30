package com.semicolonafrica.airlinebookingsystem.services;

import com.semicolonafrica.airlinebookingsystem.data.model.Airplane;
import com.semicolonafrica.airlinebookingsystem.data.model.BookingEnquiry;
import com.semicolonafrica.airlinebookingsystem.data.model.Passenger;
import com.semicolonafrica.airlinebookingsystem.data.model.Ticket;
import com.semicolonafrica.airlinebookingsystem.data.repositories.AirplaneDataBase;
import com.semicolonafrica.airlinebookingsystem.data.repositories.PassengerDataBase;
import com.semicolonafrica.airlinebookingsystem.exception.PassengerAlreadyRegisteredException;

import java.util.Map;
import java.util.Objects;

public class PassengerServiceImpl implements PassengerService{
    PassengerDataBase passengerDataBase = PassengerDataBase.getInstance();
    AirplaneDataBase planeDataBase = AirplaneDataBase.getInstance();



    @Override
    public void registerPassenger(Passenger newPassenger) throws PassengerAlreadyRegisteredException {
        if(passengerDataBase.getPassengers().containsValue(newPassenger)){
            throw new PassengerAlreadyRegisteredException("Passenger already registered");
        }
        passengerDataBase.save(newPassenger);
    }


    @Override
    public void login(String email, String password) {
        Map<String, Passenger> allPassengers = passengerDataBase.getPassengers();
        Passenger passenger = allPassengers.get(email);
        if(Objects.equals(passenger.getPassword(), password)){
            passenger.setIsActive(true);
        }
    }

    @Override
    public void logout(String email) {
        Passenger thisPassenger = passengerDataBase.searchPassenger(email);
        thisPassenger.setIsActive(false);
    }

    @Override
    public void clearPassenger() {
        passengerDataBase.getPassengers().clear();
    }

    @Override
    public Airplane airlineBookingEnquiries(BookingEnquiry newBooker) {
        Passenger foundPassenger = passengerDataBase.searchPassenger(newBooker.getPassengerEmail());
        foundPassenger.setBookingEnquiries(newBooker);
        Airplane airplane = planeDataBase.searchFlight(newBooker);
        return airplane;
    }

    @Override
    public Ticket bookAirline(BookingEnquiry newBooker) {
        Passenger foundPassenger = passengerDataBase.searchPassenger(newBooker.getPassengerEmail());
        if (foundPassenger!=null) {
            Airplane airplane = planeDataBase.searchFlight(newBooker);
            airplane.setSeats();
            Ticket ticket = new Ticket(foundPassenger.getFirstName() + " " + foundPassenger.getLastName(),
                    foundPassenger.getEmail(), foundPassenger.getPhoneNumber(), newBooker.getBookingEnquiryDescription(),Airplane.getSeats(),
                    newBooker.getDepartureDate(), airplane.getTimeOfFLight(), airplane.getTimeOfLanding());
            foundPassenger.addTickets(ticket);

            return ticket;
        }
        else
            return null;
    }
}
