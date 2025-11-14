//Marcos Coszion(332945), Francisco Lino(347691)
package Dominio;

public class Empleado {
   private String nombre;
   private String cedula;
   private int celular;
   private String curriculum;
   private int salarioMensual;
   private Manager manager;
   private Area area;

   
   public void empleado(String nombre, String cedula, int celular, String curriculum, int salarioMensual, Manager manager,Area area){
   String unNombre=nombre;
   String unaCedula=cedula;
   int unCelular=celular;
   String unCurriculum=curriculum;
   int unSalarioMensual=salarioMensual;
   Manager unManager=manager;
   Area unArea=area;
       
       
   }

     @Override
    public String toString() {
        return  nombre + " (" + cedula + ")";
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

    public int getCelular() {
        return celular;
    }

    public void setCelular(int unCelular) {
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

    
   
}
