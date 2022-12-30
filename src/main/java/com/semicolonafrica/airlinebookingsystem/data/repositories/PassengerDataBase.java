package com.semicolonafrica.airlinebookingsystem.data.repositories;

import com.semicolonafrica.airlinebookingsystem.data.model.Airplane;
import com.semicolonafrica.airlinebookingsystem.data.model.BookingEnquiry;
import com.semicolonafrica.airlinebookingsystem.data.model.Passenger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassengerDataBase {
    private final Map<String, Passenger> passengers = new HashMap<>();

    private static PassengerDataBase instance = null;


    public static PassengerDataBase getInstance(){
        if (instance == null){
            instance = new PassengerDataBase();
        }
        return instance;
    }


    public void save(Passenger passenger) {
        passengers.put(passenger.getEmail(), passenger);
    }

    public int getSize() {
        return passengers.size();
    }

    public Map<String, Passenger> getPassengers() {
        return passengers;
    }

    public Passenger searchPassenger(String email) {
        return passengers.get(email);
    }


    public void deletePassenger(String email) {
        passengers.remove(email,passengers.get(email));
    }
}
