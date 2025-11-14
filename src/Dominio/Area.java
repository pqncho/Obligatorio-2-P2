//Marcos Coszion(332945), Francisco Lino(347691)
package Dominio;

import java.util.*;

public class Area {
    private String nombre;
    private String descripcion;
    private int presupuesto;
    private ArrayList<Empleado> listaEmpleados;
    
    public Area(String unNombre, String unaDescripcion, int unPresupuesto){
    nombre=unNombre;
    descripcion=unaDescripcion;
    presupuesto=unPresupuesto;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        listaEmpleados = listaEmpleados;
    }
    
    
    
    
    public String getNombre(){
    return nombre;
    }
    
    public void setNombre(String unNombre){
        nombre=unNombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String unaDescripcion){
        descripcion=unaDescripcion;
    }
    
     public int getPresupuesto(){
        return presupuesto;
    }
    
    public void setPresupuesto(int unPresupuesto){
        presupuesto=unPresupuesto;
    }

    @Override
    public String toString() {
        return nombre;
    }

    
    
    
}

