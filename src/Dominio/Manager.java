//Marcos Coszion(332945), Francisco Lino(347691)
package Dominio;

public class Manager {
    private String nombre;
    private String cedula;
    private String celular;
    private int antiguedad;  
    
    public Manager(String unNombre, String unaCedula, String unCelular, int unaAntiguedad){
    nombre=unNombre;
    cedula=unaCedula;
    celular=unCelular;
    antiguedad=unaAntiguedad;
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

    public void setCi(String unaCi) {
        cedula = unaCi;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String unCelular) {
        celular = unCelular;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int unaAntiguedad) {
        antiguedad = unaAntiguedad;
    }
    
    
}
