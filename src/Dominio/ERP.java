//Marcos Coszion(332945), Francisco Lino(347691)
package Dominio;
import Interfaz.*;

public class ERP {
   static Sistema sistema= new Sistema();
    
     public static void main(String[] args) {
        
        VentanaMenu ventanaMenu= new VentanaMenu(sistema);
        ventanaMenu.setVisible(true);
      
        
        javax.swing.SwingUtilities.invokeLater(() -> {
            VentanaSplash splash = new VentanaSplash();
            splash.setVisible(true);

            
            new Thread(() -> {
                try {
                    Thread.sleep(4000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                splash.dispose(); 
                VentanaInicio ventanaInicio= new VentanaInicio();
            }).start();
        });
        
        
    }
}

     