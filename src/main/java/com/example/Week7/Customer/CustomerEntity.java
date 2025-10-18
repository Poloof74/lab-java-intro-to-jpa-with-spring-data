package com.example.Week7.Customer;
import com.example.Week7.Data.CustomerStatus;
import jakarta.persistence.*;


@Entity
@Table(name = "customers")
public class CustomerEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String name;

    @Column( nullable = false)
    private Long CustomerId;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CustomerStatus status;


    @Column(name = "TotalCustomerMileage", nullable = false)
    private Integer TotalCustomerMileage;



    public CustomerEntity() {
    }

    public CustomerEntity(String name, CustomerStatus status, Integer TotalCustomerMileage) {
        this.name = name;
        this.status = status;
        this.TotalCustomerMileage = TotalCustomerMileage;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    public Integer TotalCustomerMileage() {
        return TotalCustomerMileage;
    }

    public void TotalCustomerMileage(Integer TotalCustomerMileage) {
        this.TotalCustomerMileage = TotalCustomerMileage;
    }


}



