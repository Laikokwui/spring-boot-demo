package com.example.demo.dao;

import com.example.demo.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FakeCustomerDataAccessService {
    private static List<Customer> DB = new ArrayList<>();

    @Override
    public int insertCustomer(UUID id, Customer customer) {
        DB.add(new Customer(id, customer.getName(), customer.getAddress(), customer.getPhone()));
        return 1;
    }
}
