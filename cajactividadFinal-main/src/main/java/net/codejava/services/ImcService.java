/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.services;

import java.util.List;
import net.codejava.entity.Imc;
import net.codejava.repositories.ImcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jajimenez
 */
@Service
@Transactional
public class ImcService {

    @Autowired
    private ImcRepository imcRepository;

    public List<Imc> listAll() {
        return imcRepository.findAll();
    }

    public void save(Imc imc) {
        imcRepository.save(imc);
    }
    
    public Imc get(long id) {
        return imcRepository.findById(id).get();
    }

}
