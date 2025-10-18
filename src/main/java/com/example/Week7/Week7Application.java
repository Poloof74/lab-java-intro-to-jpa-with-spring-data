package com.example.Week7;

import com.example.Week7.BookingFlight.FlightBookingEntity;
import com.example.Week7.Customer.CustomerEntity;
import com.example.Week7.Data.CustomerStatus;
import com.example.Week7.Flight.FlightEntity;
import com.example.Week7.Repository.CustomerRepository;
import com.example.Week7.Repository.FlightBookingRepository;
import com.example.Week7.Repository.FlightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Week7Application {

	public static void main(String[] args) {
		SpringApplication.run(Week7Application.class, args);
	}

    @Bean
    CommandLineRunner run(CustomerRepository customerRepo,
                          FlightRepository flightRepo,
                          FlightBookingRepository bookingRepo) {
        return args -> {
            CustomerEntity alice = customerRepo.save(new CustomerEntity("Alice", CustomerStatus.GOLD, 120000));
            FlightEntity flight = flightRepo.save(new FlightEntity("AB123", "Boeing 747", 300, 400));
            bookingRepo.save(new FlightBookingEntity(alice.getId(), flight.getId()));
        };
    }
}



