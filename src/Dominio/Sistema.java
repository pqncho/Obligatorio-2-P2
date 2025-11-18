//Marcos Coszion(332945), Francisco Lino(347691)
package Dominio;
import Interfaz.*;
import java.util.*;

public class Sistema extends Observable{
   private ArrayList<Area> listaAreas;
   private ArrayList<Empleado> listaEmpleados;
   private ArrayList<Manager> listaManagers;
   private ArrayList<MovimientosArea> listaMovArea;
    
    public Sistema(){
        listaAreas= new ArrayList<>();
        listaEmpleados= new ArrayList<>();
        listaManagers = new ArrayList<>();
        listaMovArea= new ArrayList<>();
    }

    public ArrayList<MovimientosArea> getListaMovArea() {
        return listaMovArea;
    }
    
    public void agregarMovArea(MovimientosArea unMovArea){
        listaMovArea.add(unMovArea);
        setChanged();
       notifyObservers("MovArea");
    }
    
   
   public void agregarArea(Area unArea){
       listaAreas.add(unArea);
       setChanged();
       notifyObservers("areas");
   }
   public void agregarEmpleado(Empleado unEmpleado){
       listaEmpleados.add(unEmpleado);
       setChanged();
       notifyObservers("empleados");
   }
    public void agregarManagers(Manager unManager){
       listaManagers.add(unManager);
       setChanged();
       notifyObservers("managers");
   }
    
    public void cargarDatosPorDefecto(){
    listaAreas.add(new Area("Personal","Reclutamiento de personal, promociones, gestión de cargos",100000));
    listaAreas.add(new Area("RRHH","Relacionamiento en la empresa, organigrama, gestión de equipos",80000));
    listaAreas.add(new Area("Seguridad","Seguridad física, vigilancia, seguridad informática, protocolos y políticas de seguridad",120000));
    listaAreas.add(new Area("Comunicaciones","Comunicaciones internas, reglas y protocolos, comunicaciones con proveedores y clientes",20000));
    listaAreas.add(new Area("Marketing","Acciones planificadas, publicidad en medios masivos, publicidad en redes, gestión de redes",95000));
    ordenarAreasPorNombre();
    listaManagers.add(new Manager("Ana Martínez","4.568.369-1","099 123 456",10));
    listaManagers.add(new Manager("Ricardo Morales","3.214.589-3","094 121 212",4));
    listaManagers.add(new Manager("Laura Torales","3.589.257-5","099 654 321",1));
    listaManagers.add(new Manager("Juan Pablo Zapata","4.555.197-7","099 202 020",5));
    ordenarManagersPorAntiguedad();
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
    
    
    public void ordenarManagersPorAntiguedad(){
    
         Comparator<Manager> comp = new Comparator<Manager>() {
        @Override
        public int compare(Manager m1, Manager m2) {
            int resultado = 0;

            if (m1.getAntiguedad() < m2.getAntiguedad()) {
                resultado = -1;
            }

            if (m1.getAntiguedad() > m2.getAntiguedad()) {
                resultado = 1;
            }

            return resultado;
        }
    };

    Collections.sort(listaManagers, comp);
    }
    public void ordenarAreasPorPorcentaje(){
    Comparator<Area> comp = new Comparator<Area>() {
        @Override
        public int compare(Area a1, Area a2) {
            int resultado = 0;
            double p1 = a1.getPorcentaje();
            double p2 = a2.getPorcentaje();

            if (p1 < p2) {
               
                resultado = 1;
            }

            if (p1 > p2) {
                resultado = -1;
            }

           
            return resultado;
        }
    };

    Collections.sort(listaAreas, comp);
        
    }
    
    public void ordenarAreasPorNombre(){
    
        Comparator<Area> comp = new Comparator<Area>() {
        @Override
        public int compare(Area a1, Area a2) {
            int resultado = 0;

            if (a1.getNombre().compareToIgnoreCase(a2.getNombre()) < 0) {
                resultado = -1;
            }

            if (a1.getNombre().compareToIgnoreCase(a2.getNombre()) > 0) {
                resultado = 1;
            }

            
            return resultado;
        }
    };

    Collections.sort(listaAreas, comp);
        
    }
    
    public void ordenarEmpleadosPorSalario(){
        Comparator<Empleado> comp = new Comparator<Empleado>() {
        @Override
        public int compare(Empleado e1, Empleado e2) {
            int resultado = 0;

            if (e1.getSalarioMensual() < e2.getSalarioMensual()) {
                resultado = 1;
            }

            if (e1.getSalarioMensual() > e2.getSalarioMensual()) {
                resultado = -1;
            }

            return resultado;
        }
    };

    Collections.sort(listaEmpleados, comp);

    }
}
