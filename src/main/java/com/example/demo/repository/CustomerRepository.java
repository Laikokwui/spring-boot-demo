package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    @Query("{name:'?0'}")
    Customer findCustomer(String name);

    @Query(value="{name:'?0'}", fields="{'phone' : 1, 'address' : 1}")
    List<Customer> findAll();
    
    public long count();
}
