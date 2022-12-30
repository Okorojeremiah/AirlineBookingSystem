package com.semicolonafrica.airlinebookingsystem.services;

import com.semicolonafrica.airlinebookingsystem.data.model.Airplane;
import com.semicolonafrica.airlinebookingsystem.data.model.Passenger;
import com.semicolonafrica.airlinebookingsystem.data.repositories.AirplaneDataBase;
import com.semicolonafrica.airlinebookingsystem.data.repositories.PassengerDataBase;
import com.semicolonafrica.airlinebookingsystem.exception.UserNotFoundException;

public class AdminServiceImpl implements AdminService{
    PassengerDataBase passengerDataBase = PassengerDataBase.getInstance();
    AirplaneDataBase planeDataBase = AirplaneDataBase.getInstance();


    @Override
    public void deletePassenger(String email) {
        passengerDataBase.deletePassenger(email);
    }

    @Override
    public Passenger searchPassenger(String email) throws UserNotFoundException {
        Passenger foundPassenger = passengerDataBase.searchPassenger(email);
        if(foundPassenger == null){
            throw new UserNotFoundException("Passenger with the email not found");
        }
        return foundPassenger;
    }

    @Override
    public void addAirplane(Airplane airplane) {
        planeDataBase.save(airplane);
    }

    @Override
    public void deleteAirplane(Airplane airplane) {
        Airplane foundAirplane = planeDataBase.searchAirplane(airplane.getAirPlaneId());
        planeDataBase.deleteAirplane(foundAirplane.getAirPlaneId());

    }
}
