package com.example.demo.service;

import com.example.demo.dao.CustomerDao;
import com.example.demo.model.Customer;

public class CustomerService {
    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao){
        this.customerDao = customerDao;
    }

    public int addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }
}
