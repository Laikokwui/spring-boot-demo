package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDao;
import com.example.demo.model.Customer;

@Service
public class CustomerService {
    private final CustomerDao customerDao;

    @Autowired
    public CustomerService(@Qualifier("mongo") CustomerDao customerDao){
        this.customerDao = customerDao;
    }

    public int addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }
}
