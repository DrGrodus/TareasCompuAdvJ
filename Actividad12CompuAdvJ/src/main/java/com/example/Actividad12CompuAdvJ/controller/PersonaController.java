/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Actividad12CompuAdvJ.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eber
 */
@RestController()
public class PersonaController {
    
    @GetMapping("/")
    public String holaMundo() {
        return "Hola Mundo";
    }
}
