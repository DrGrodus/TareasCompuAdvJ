/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springboot.controller;

import com.example.springboot.entity.Customer;
import com.example.springboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author eber
 */
@RestController
public class HelloController {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @GetMapping("/")
    public Iterable<Customer> index() {
        Iterable<Customer> customer = customerRepository.findAll();
        return customer;
    }
}
