package com.example.Week7.Flight;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "flights")
public class FlightEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true)
    private String flightNumber;



    @Column(nullable = false)
    private String aircraft;


    @Column(name = "total_seats", nullable = false)
    private Integer totalSeats;


    @Column(nullable = false)
    private Integer mileage;


    public FlightEntity() {}

    public FlightEntity(String flightNumber, String aircraft, Integer totalSeats, Integer mileage) {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.totalSeats = totalSeats;
        this.mileage = mileage;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }
}