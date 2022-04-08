/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 *
 * @author eber
 */
public interface ClienteManager {
    public Cliente createNewCliente(String nombre, String direccion, String telefono);
    public Cliente getCliente(int id);
}
