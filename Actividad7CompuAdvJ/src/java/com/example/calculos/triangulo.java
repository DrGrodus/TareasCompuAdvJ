/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.calculos;

/**
 *
 * @author eber
 */
public class triangulo {
    private double base;
    private double altura;
    private double perimetro;
    private double area;
    
    public triangulo(String n1, String n2){
        this.setBase(Integer.parseInt(n1));
        this.setAltura(Integer.parseInt(n2));
    }
    
    public void OperarArea(){
        double areaO = (this.getBase()*this.getAltura())/2 ;
        this.setArea(areaO);
    }
    
    public void OperarPerimetro(){
        double perimetroO = 3*(this.getBase());
        this.setPerimetro((int) perimetroO);
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(int perimetro) {
        this.perimetro = perimetro;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
