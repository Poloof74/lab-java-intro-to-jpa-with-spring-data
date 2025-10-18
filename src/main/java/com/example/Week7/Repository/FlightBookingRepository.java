package com.example.Week7.Repository;

import com.example.Week7.BookingFlight.FlightBookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookingRepository extends JpaRepository<FlightBookingEntity, Long> {

FlightBookingEntity findByCustomerId(Long customerId);
}
