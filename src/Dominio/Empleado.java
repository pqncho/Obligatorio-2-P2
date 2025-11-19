//Marcos Coszion(332945), Francisco Lino(347691)
package Dominio;

import java.io.*;
public class Empleado implements Serializable{
   private String nombre;
   private String cedula;
   private String celular;
   private String curriculum;
   private int salarioMensual;
   private Manager manager;
   private Area area;
   private int mesDeEntrada;

   
   public Empleado (String unNombre, String unaCedula, String unCelular, String unCurriculum, int unSalarioMensual, Manager unManager,Area unArea){
    nombre=unNombre;
    cedula=unaCedula;
    celular=unCelular;
    curriculum=unCurriculum;
    salarioMensual=unSalarioMensual;
    manager=unManager;
    area=unArea;
    mesDeEntrada=1;
       
       
   }

     @Override
    public String toString() {
        return  nombre + " (" + salarioMensual + ")";
    }
   
   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String unNombre) {
        nombre = unNombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String unaCedula) {
        cedula = unaCedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String unCelular) {
        celular = unCelular;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String unCurriculum) {
        curriculum = unCurriculum;
    }

    public int getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(int unSalarioMensual) {
        salarioMensual = unSalarioMensual;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager unManager) {
        manager = unManager;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area unArea) {
        area = unArea;
    }

    public int getMesDeEntrada() {
        return mesDeEntrada;
    }

    public void setMesDeEntrada(int mesDeEntrada) {
        this.mesDeEntrada = mesDeEntrada;
    }
    
    

        public int SalarioAnualRes() {
            int salarioAnualRes= getSalarioMensual() * (13-this.mesDeEntrada);
    return salarioAnualRes;
}
    
   
}
