//Marcos Coszion(332945), Francisco Lino(347691)
package Dominio;
import Interfaz.*;
import java.util.*;

public class Sistema {
   private ArrayList<Area> listaAreas;
   private ArrayList<Empleado> listaEmpleados;
   private ArrayList<Manager> listaManagers;
    
    public Sistema(){
    listaAreas= new ArrayList<>();
    listaEmpleados= new ArrayList<>();
    listaManagers = new ArrayList<>();
    }
   public void moverEmpleado(Empleado unEmpleado, Area areaActual,Area areaDestino, int unMes ) {
       int sueldoAReintegrar=0;

}
   
   public void agregarArea(Area unArea){
       listaAreas.add(unArea);
   }
   public void agregarEmpleado(Empleado unEmpleado){
       listaEmpleados.add(unEmpleado);
   }
    public void agregarManagers(Manager unManager){
       listaManagers.add(unManager);
   }
    
    public void cargarDatosPorDefecto(){
    listaAreas.add(new Area("Personal","Reclutamiento de personal, promociones, gestión de cargos",100000));
    listaAreas.add(new Area("RRHH","Relacionamiento en la empresa, organigrama, gestión de equipos",80000));
    listaAreas.add(new Area("Seguridad","Seguridad física, vigilancia, seguridad informática, protocolos y políticas de seguridad",120000));
    listaAreas.add(new Area("Comunicaciones","Comunicaciones internas, reglas y protocolos, comunicaciones con proveedores y clientes",20000));
    listaAreas.add(new Area("Marketing","Acciones planificadas, publicidad en medios masivos, publicidad en redes, gestión de redes",95000));
    listaManagers.add(new Manager("Ana Martínez","4.568.369-1","099 123 456",10));
    listaManagers.add(new Manager("Ricardo Morales","3.214.589-3","094 121 212",4));
    listaManagers.add(new Manager("Laura Torales","3.589.257-5","099 654 321",1));
    listaManagers.add(new Manager("Juan Pablo Zapata","4.555.197-7","099 202 020",5));
    }
    
    public ArrayList<Empleado> getListaEmpleados() { 
        return listaEmpleados;
    }
    public ArrayList<Area> getListaAreas() {
        return listaAreas;
    }
    public ArrayList<Manager> getListaManagers() { 
        return listaManagers; 
    }
}
