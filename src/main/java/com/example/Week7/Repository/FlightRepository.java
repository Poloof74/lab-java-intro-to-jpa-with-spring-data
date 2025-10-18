package com.example.Week7.Repository;

import com.example.Week7.Flight.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<FlightEntity, Long> {

    FlightEntity findByFlightNumber(String flightNumber);

}