package com.example.demo.model;

import java.util.UUID;

public class Customer {
    private final UUID id;
    private final String name;
    private final String address;
    private final String phone;

    public Customer(UUID id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
