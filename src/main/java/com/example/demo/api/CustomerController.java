package com.example.demo.api;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void addCustomer(Customer customer) {
        customerService.addCustomer(customer);
    }
}
