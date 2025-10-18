package com.example.Week7.Service;

import com.example.Week7.Customer.CustomerEntity;
import com.example.Week7.GlobalExceptionHandler.GlobalExceptionHandler;
import com.example.Week7.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public CustomerEntity saveCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }


    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }


    public CustomerEntity getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new GlobalExceptionHandler.ResourceNotFoundException("Customer not found with ID: " + id));
    }


    public void deleteCustomerById(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new GlobalExceptionHandler.ResourceNotFoundException("Customer not found with ID: " + id);
        }
        customerRepository.deleteById(id);
    }
}
