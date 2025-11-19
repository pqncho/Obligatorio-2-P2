
package Dominio;

import java.io.*;



public class MovimientosArea implements Serializable{
    private String mes;
    private Area areaOrigen;
    private Area areaDestino;
    private Empleado empleado;
           
    
    public MovimientosArea(String unMes, Area unAreaOrigen, Area unAreaDestino, Empleado unEmpleado){
        mes=unMes;
        areaOrigen=unAreaOrigen;
        areaDestino=unAreaDestino;
        empleado=unEmpleado;
    
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String unMes) {
        mes = unMes;
    }

    public Area getAreaOrigen() {
        return areaOrigen;
    }

    public void setAreaOrigen(Area unAreaOrigen) {
        areaOrigen = unAreaOrigen;
    }

    public Area getAreaDestino() {
        return areaDestino;
    }

    public void setAreaDestino(Area unAreaDestino) {
        areaDestino = unAreaDestino;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado unEmpleado) {
        empleado = unEmpleado;
    }
    
    
}
