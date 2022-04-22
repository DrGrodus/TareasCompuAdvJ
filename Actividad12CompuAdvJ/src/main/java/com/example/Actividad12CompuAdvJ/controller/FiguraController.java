/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Actividad12CompuAdvJ.controller;

import com.example.Actividad12CompuAdvJ.dto.TrianguloDTO;
import com.example.Actividad12CompuAdvJ.entity.Triangulo;
import com.example.Actividad12CompuAdvJ.servicio.FiguraService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eber
 */
@RestController()
@RequestMapping("figura")
public class FiguraController {

    @Autowired
    FiguraService figuraService;
    
    @GetMapping()
    public List<TrianguloDTO> getTriangulos() {
        Triangulo triangulo = new Triangulo();
        triangulo.setAltura(Math.random()*100);
        triangulo.setBase(Math.random()*100);
        triangulo.setArea((triangulo.getBase()*triangulo.getAltura())/2);
        triangulo.setPerimetro(triangulo.getBase()*3);
        figuraService.guardarTriangulo(triangulo);
        return (List<TrianguloDTO>) figuraService.getTriangulos();
    }
}
