package com.example.Week7.Service;

import com.example.Week7.BookingFlight.FlightBookingEntity;
import com.example.Week7.Customer.CustomerEntity;
import com.example.Week7.Flight.FlightEntity;
import com.example.Week7.GlobalExceptionHandler.GlobalExceptionHandler;
import com.example.Week7.Repository.CustomerRepository;
import com.example.Week7.Repository.FlightBookingRepository;
import com.example.Week7.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FlightBookingService {

    private final FlightBookingRepository flightBookingRepository;
    private final CustomerRepository customerRepository;
    private final FlightRepository flightRepository;

    @Autowired
    public FlightBookingService(FlightBookingRepository flightBookingRepository,
                                CustomerRepository customerRepository,
                                FlightRepository flightRepository) {
        this.flightBookingRepository = flightBookingRepository;
        this.customerRepository = customerRepository;
        this.flightRepository = flightRepository;
    }


    public FlightBookingEntity saveBooking(Long customerId, Long flightId) {
        CustomerEntity customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new GlobalExceptionHandler.ResourceNotFoundException("Customer not found with ID: " + customerId));
        FlightEntity flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new GlobalExceptionHandler.ResourceNotFoundException("Flight not found with ID: " + flightId));

        FlightBookingEntity booking = new FlightBookingEntity(customerId, flightId);
        return flightBookingRepository.save(booking);
    }


    public List<FlightBookingEntity> getAllBookings() {
        return flightBookingRepository.findAll();
    }


    public FlightBookingEntity getBookingById(Long id) {
        return flightBookingRepository.findById(id)
                .orElseThrow(() -> new GlobalExceptionHandler.ResourceNotFoundException("Booking not found with ID: " + id));
    }


    public void deleteBookingById(Long id) {
        if (!flightBookingRepository.existsById(id)) {
            throw new GlobalExceptionHandler.ResourceNotFoundException("Booking not found with ID: " + id);
        }
        flightBookingRepository.deleteById(id);
    }
}
