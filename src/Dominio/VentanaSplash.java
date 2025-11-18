//Marcos Coszion(332945), Francisco Lino(347691)
package Dominio;
import javax.swing.*;
import java.awt.*;

public class VentanaSplash extends JWindow {
    
    public VentanaSplash() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        setVisible(true);

        
        ImageIcon icon = new ImageIcon(getClass().getResource("/Recursos/logoERP.png"));

       
        Image img = icon.getImage().getScaledInstance(450, 300, Image.SCALE_SMOOTH);
        JLabel logo = new JLabel(new ImageIcon(img), SwingConstants.CENTER);

        panel.add(logo, BorderLayout.CENTER);
        

        getContentPane().add(panel);
        setSize(400, 300);
        setLocationRelativeTo(null);
    }
}
