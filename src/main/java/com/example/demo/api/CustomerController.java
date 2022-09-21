package com.example.demo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@RestController
@RequestMapping("/api")
public class CustomerController {

  @Autowired
  CustomerRepository customerRepository;

  @GetMapping("/customer")
  public ResponseEntity<List<Customer>> getAllCustomers() {
    try {
      List<Customer> customers = new ArrayList<Customer>();
  
      customerRepository.findAll().forEach(customers::add);
  
      if (customers.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
  
      return new ResponseEntity<>(customers, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @GetMapping("/customer/hello")
  public String getCustomerById(@PathVariable("id") String id) {
    return "customer/index.html";
  }

  @PostMapping("/customer/create")
  public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
    try {
      Customer _customer = customerRepository.save(new Customer(customer.getId(), customer.getFullName(), customer.getAddress(), customer.getPhone()));
      return new ResponseEntity<>(_customer, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/customer/update/{id}")
  public ResponseEntity<Customer> updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer) {
    Optional<Customer> customerData = customerRepository.findById(id);

  if (customerData.isPresent()) {
    Customer _customer = customerData.get();
    _customer.setFullName(customer.getFullName());
    _customer.setAddress(customer.getAddress());
    _customer.setPhone(customer.getPhone());
    return new ResponseEntity<>(customerRepository.save(_customer), HttpStatus.OK);
  } else {
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  }

  @DeleteMapping("/customer/{id}")
  public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") String id) {
    try {
      customerRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}

