/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.codejava.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author eber
 */
@Entity
public class CuentaUsuario implements Serializable {
    
    private Long id;
    private String nombrePersona;
    private String apellido;
    
    @NotNull
    @Min(15)
    private Integer edad;
    
    private String sexo;

    @NotNull
    @Min((long) 100)
    @Max((long) 250)
    private Integer estatura;

    private String nombreUsuario;
    private String contrasena;

    public CuentaUsuario() {
    }

    public CuentaUsuario(Long id, String nombrePersona, String apellido, Integer edad, 
                        String sexo, Integer estatura, String nombreUsuario, String contrasena) {
        this.id = id;
        this.nombrePersona = nombrePersona;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
        this.estatura = estatura;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getEstatura() {
        return estatura;
    }

    public void setEstatura(Integer estatura) {
        this.estatura = estatura;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
