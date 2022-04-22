/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Customer;
import com.example.demospringboot.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eber
 */
@RestController
public class HelloController {

    // inyeccion de dependencia customerRepository, con la entidad Customer
    @Autowired 
    private CustomerRepository customerRepository;
    
    
    @GetMapping("/")
    public String index() {
        Iterable<Customer> customer = customerRepository.findAll();
        return "Saludos de Spring Boot";
    }
}
