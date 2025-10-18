package com.example.Week7.Service;

import com.example.Week7.Flight.FlightEntity;
import com.example.Week7.GlobalExceptionHandler.GlobalExceptionHandler;
import com.example.Week7.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


    public FlightEntity saveFlight(FlightEntity flight) {
        return flightRepository.save(flight);
    }


    public List<FlightEntity> getAllFlights() {
        return flightRepository.findAll();
    }


    public FlightEntity getFlightById(Long id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new GlobalExceptionHandler.ResourceNotFoundException("Flight not found with ID: " + id));
    }


    public void deleteFlightById(Long id) {
        if (!flightRepository.existsById(id)) {
            throw new GlobalExceptionHandler.ResourceNotFoundException("Flight not found with ID: " + id);
        }
        flightRepository.deleteById(id);
    }
}
