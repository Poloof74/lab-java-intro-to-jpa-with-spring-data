package com.example.Week7.BookingFlight;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;


@Entity
@Table(name = "flight_bookings")
public class FlightBookingEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "customer_id", nullable = false)
    private Long customerId;


    @Column(name = "flight_id", nullable = false)
    private Long flightId;


    public FlightBookingEntity() {}

    public FlightBookingEntity(Long customerId, Long flightId) {
        this.customerId = customerId;
        this.flightId = flightId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
}