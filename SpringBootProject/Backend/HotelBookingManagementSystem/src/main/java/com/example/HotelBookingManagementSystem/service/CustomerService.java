package com.example.HotelBookingManagementSystem.service;

import com.example.HotelBookingManagementSystem.entity.Customer;
import com.example.HotelBookingManagementSystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer>getAll(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getById(Long id){
        return customerRepository.findById(id);
    }

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteById(Long id){
        customerRepository.deleteById(id);

    }



//    public Customer getProfileByUserId(Long id){
//        return customerRepository.findByUserId(id)
//                .orElseThrow()-> new RuntimeException("Customer Not Found");
//    }
}
