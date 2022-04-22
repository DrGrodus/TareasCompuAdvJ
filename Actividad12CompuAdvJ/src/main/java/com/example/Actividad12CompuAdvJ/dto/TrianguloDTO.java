/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Actividad12CompuAdvJ.dto;

import com.example.Actividad12CompuAdvJ.entity.Triangulo;
import lombok.Data;

/**
 *
 * @author eber
 */
@Data
public class TrianguloDTO {
    
    private Integer id;
    private Double altura;
    private Double base;
    
    public Double area() {
        return altura*base/2;
    }
    
    public TrianguloDTO() {
        
    }

    public TrianguloDTO(Triangulo triangulo) {
        this.id = triangulo.getId();
        this.altura = triangulo.getAltura();
        this.base = triangulo.getBase();
    }
    
}
