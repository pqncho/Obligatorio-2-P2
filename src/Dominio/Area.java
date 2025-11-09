//Marcos Coszion(332945), Francisco Lino(347691)
package Dominio;

public class Area {
    private String nombre;
    private String descripcion;
    private int presupuesto;
    
    
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
}
