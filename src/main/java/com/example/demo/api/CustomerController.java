package com.example.demo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String getCustomers() {
    return "view list of Customer";
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public String createCustomer() {
    return "create Customer";
  }

  @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
  public String updateCustomer() {
    return "update Customer";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public String getCustomer() {
    return "view Customer";
  }
}

