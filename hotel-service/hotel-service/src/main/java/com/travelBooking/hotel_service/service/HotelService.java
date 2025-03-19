package com.travelBooking.hotel_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.travelBooking.hotel_service.model.Hotel;
import com.travelBooking.hotel_service.repository.HotelRepository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Optional<Hotel> getHotelById(String id) {
        return hotelRepository.findById(id);
    }

    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(String id, Hotel hotel) {
        hotel.setId(id);
        return hotelRepository.save(hotel);
    }

    public void deleteHotel(String id) {
        hotelRepository.deleteById(id);
    }

    // Example of calling another microservice (Flight Service) from this Hotel Service
    public String getFlightDetailsFromFlightService(String flightId) {
        String flightServiceUrl = "http://localhost:8081/api/flights/" + flightId; // URL of your Flight Service
        return restTemplate().getForObject(flightServiceUrl, String.class);
    }
}
