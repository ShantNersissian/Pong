import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Pong extends JFrame {
    public Pong() {
        setLocationRelativeTo(null);
        setTitle("Pong");
        getContentPane().setBackground(Color.BLACK);
        setExtendedState(MAXIMIZED_BOTH); 
        setVisible(true);
        JLabel label = new JLabel();
        Border border = BorderFactory.createLineBorder(Color.WHITE);
        add(label);
        label.setBorder(border);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}