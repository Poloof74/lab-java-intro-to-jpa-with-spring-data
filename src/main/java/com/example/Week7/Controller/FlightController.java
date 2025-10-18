package com.example.Week7.Controller;

import com.example.Week7.Flight.FlightEntity;
import com.example.Week7.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public FlightEntity createFlight(@RequestBody FlightEntity flight) {
        return flightService.saveFlight(flight);
    }

    @GetMapping
    public List<FlightEntity> getFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public FlightEntity getFlight(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightService.deleteFlightById(id);
    }
}
