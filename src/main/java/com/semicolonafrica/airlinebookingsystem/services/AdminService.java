package com.semicolonafrica.airlinebookingsystem.services;

import com.semicolonafrica.airlinebookingsystem.data.model.Airplane;
import com.semicolonafrica.airlinebookingsystem.data.model.Passenger;
import com.semicolonafrica.airlinebookingsystem.exception.UserNotFoundException;

public interface AdminService {
    void deletePassenger(String email);
    Passenger searchPassenger(String email) throws UserNotFoundException;

    void addAirplane(Airplane airplane);

    void deleteAirplane(Airplane airplane);
}
