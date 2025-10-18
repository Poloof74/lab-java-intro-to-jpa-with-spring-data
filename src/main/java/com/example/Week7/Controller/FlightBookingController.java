package com.example.Week7.Controller;

import com.example.Week7.BookingFlight.FlightBookingEntity;
import com.example.Week7.Service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class FlightBookingController {

    private final FlightBookingService flightBookingService;

    @Autowired
    public FlightBookingController(FlightBookingService flightBookingService) {
        this.flightBookingService = flightBookingService;
    }

    @PostMapping
    public FlightBookingEntity createBooking(@RequestParam Long customerId, @RequestParam Long flightId) {
        return flightBookingService.saveBooking(customerId, flightId);
    }

    @GetMapping
    public List<FlightBookingEntity> getBookings() {
        return flightBookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public FlightBookingEntity getBooking(@PathVariable Long id) {
        return flightBookingService.getBookingById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        flightBookingService.deleteBookingById(id);
    }
}