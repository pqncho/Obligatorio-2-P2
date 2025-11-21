//Marcos Coszion(332945), Francisco Lino(347691)
package Dominio;

import Interfaz.*;
import java.io.*;

public class ERP implements Serializable {

    static Sistema sistema = new Sistema();

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            VentanaSplash splash = new VentanaSplash();
            new Thread(() -> {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                splash.dispose();
                VentanaInicio ventanaInicio = new VentanaInicio();
            }).start();
        });
    }
}
