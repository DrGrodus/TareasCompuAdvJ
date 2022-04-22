/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demospringboot.repositories;

import com.example.demospringboot.entity.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

/**
 *
 * @author eber
 */
//@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    List<Customer> findByLastName(String lastName);
//
//    Customer findById(long id);
}
