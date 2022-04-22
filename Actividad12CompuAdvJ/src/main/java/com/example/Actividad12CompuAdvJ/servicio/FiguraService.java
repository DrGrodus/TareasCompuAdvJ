/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Actividad12CompuAdvJ.servicio;

import com.example.Actividad12CompuAdvJ.dto.TrianguloDTO;
import com.example.Actividad12CompuAdvJ.entity.Triangulo;
import com.example.Actividad12CompuAdvJ.repository.FiguraRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eber
 */
@Service
public class FiguraService {
    
    @Autowired
    FiguraRepository figuraRepository;
    
    public Iterable<TrianguloDTO> getTriangulos() {
        List<Triangulo> lista = (List<Triangulo>) figuraRepository.findAll();
        List<TrianguloDTO> lista2 = new ArrayList();
        for(Triangulo triangulo: lista){
            lista2.add(new TrianguloDTO(triangulo));
        }
        return lista2;
    }
    
    public void guardarTriangulo(Triangulo triangulo) {
        figuraRepository.save(triangulo);
    }
}
