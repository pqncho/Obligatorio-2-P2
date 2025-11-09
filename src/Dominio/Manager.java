//Marcos Coszion(332945), Francisco Lino(347691)
package Dominio;

public class Manager {
    private String nombre;
    private String cedula;
    private int celular;
    private int antiguedad;  

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

    public int getCelular() {
        return celular;
    }

    public void setCelular(int unCelular) {
        celular = unCelular;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int unaAntiguedad) {
        antiguedad = unaAntiguedad;
    }
    
    
}
