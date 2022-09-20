package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    @Query("{fullName:'?0'}")
    Customer findCustomer(String fullName);

    List<Customer> findById();

    List<Customer> findAll();

    List<Customer> findByAddressContaining(String address);
    
    public long count();
}
