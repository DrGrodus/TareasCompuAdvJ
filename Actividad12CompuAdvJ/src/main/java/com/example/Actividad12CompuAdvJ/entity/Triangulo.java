/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Actividad12CompuAdvJ.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author eber
 */
@Entity
@Data
public class Triangulo {

    @Id
    private Long id;
    
    @Column()
    private Double base;
    
    @Column()
    private Double altura;
    
}
