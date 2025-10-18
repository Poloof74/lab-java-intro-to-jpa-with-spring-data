package com.example.Week7.Repository;

import com.example.Week7.Customer.CustomerEntity;
import com.example.Week7.Data.CustomerStatus;
import jakarta.persistence.EnumType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    CustomerEntity findByName(String name);
    CustomerEntity getCustomerEntitiesBy(EnumType status);
CustomerEntity findByStatus(CustomerStatus status);
    

}
