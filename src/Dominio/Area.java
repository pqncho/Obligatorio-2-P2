//Marcos Coszion(332945), Francisco Lino(347691)
package Dominio;

import java.io.*;
import java.util.*;

public class Area  implements Serializable{
    private String nombre;
    private String descripcion;
    private int presupuesto;
    private ArrayList<Empleado> listaEmpleados;
    
    public Area(String unNombre, String unaDescripcion, int unPresupuesto){
    nombre=unNombre;
    descripcion=unaDescripcion;
    presupuesto=unPresupuesto;
    listaEmpleados= new ArrayList<>();
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> unaListaEmpleados) {
        listaEmpleados = unaListaEmpleados;
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

    public double getPorcentaje(){
        double totalSalarios=0.0;
        
         if (listaEmpleados != null) {
        for (Empleado e : listaEmpleados) {
           
            totalSalarios = totalSalarios + e.getSalarioAnual();
        }
    }
         
         double porcentaje = 0.0;
    if (presupuesto > 0) {
        
        porcentaje = (totalSalarios * 100.0) / (double) presupuesto;
    }

    return porcentaje;
}
    }
    
    


