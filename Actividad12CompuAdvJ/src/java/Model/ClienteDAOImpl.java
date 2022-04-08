/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import org.springframework.stereotype.Repository;

/**
 *
 * @author eber
 */
@Repository("clienteDao")
public class ClienteDAOImpl implements interfaces.ClienteDAO {

    //@Override
    public Cliente createNewCliente(String nombre, String direccion, String telefono) {
        Cliente cliente = new Cliente();
        cliente.setDireccion(direccion);
        cliente.setNombre(nombre);
        cliente.setTelefono(telefono);
        return cliente;
    }

    //@Override
    public Cliente getCliente(int id) {
        Cliente cliente = new Cliente();
        cliente.setId(1);
        return cliente;
    }
    
}
