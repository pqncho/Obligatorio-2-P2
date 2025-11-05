
package Dominio;
import Interfaz.*;

public class ERP {
   static Sistema sistema= new Sistema();
    
     public static void main(String[] args) {
        VentanaPrincipal ventanaPrincipal= new VentanaPrincipal(sistema);
      
    }
}
