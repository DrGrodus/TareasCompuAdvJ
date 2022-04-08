/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eber
 */
@Service
public class ClienteManagerImpl implements interfaces.ClienteManager {
    
    @Autowired
    Cliente clienteDAO;

    @Override
    public Cliente createNewCliente(String nombre, String direccion, String telefono) {
        return clienteDAO.createNewCliente(nombre, direccion, telefono);
    }

    @Override
    public Cliente getCliente(int id) {
        return clienteDAO.getCliente(id);
    }
    
     
}
