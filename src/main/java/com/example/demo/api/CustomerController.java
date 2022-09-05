package com.example.demo.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.CustomerRepository;

@RestController
@RequestMapping(value = "/")
public class CustomerController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
}
