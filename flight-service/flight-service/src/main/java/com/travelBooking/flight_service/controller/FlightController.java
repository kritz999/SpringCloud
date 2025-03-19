package com.travelBooking.flight_service.controller;

import com.travelBooking.flight_service.model.Flight; // Corrected import
import com.travelBooking.flight_service.services.FlightService; // Corrected import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @PostMapping
    public Flight saveFlight(@RequestBody Flight flight) {
        return flightService.saveFlight(flight);
    }
    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable String id, @RequestBody Flight updatedFlight) {
        return flightService.updateFlight(id, updatedFlight);
    }
}
