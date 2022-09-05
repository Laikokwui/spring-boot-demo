package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.repository.CustomerRepository;

@SpringBootApplication
@EnableMongoRepositories
public class DemoApplication {
	
	@Autowired
    CustomerRepository CustomerRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
