/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Actividad12CompuAdvJ.repository;

import com.example.Actividad12CompuAdvJ.entity.Triangulo;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author eber
 */
public interface FiguraRepository extends CrudRepository<Triangulo, Integer>{
    
}
