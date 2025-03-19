package com.travelBooking.flight_service.services;

import com.travelBooking.flight_service.model.Flight;
import com.travelBooking.flight_service.model.Flight; // Corrected import
import com.travelBooking.flight_service.repository.FlightRepository; // Corrected import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }
    public Flight updateFlight(String id, Flight updatedFlight) {
        Optional<Flight> existingFlight = flightRepository.findById(id);
        if (existingFlight.isPresent()) {
            updatedFlight.setId(id); // Retain the same ID for the update
            return flightRepository.save(updatedFlight);
        } else {
            throw new RuntimeException("Flight not found with id: " + id);
        }
}}
