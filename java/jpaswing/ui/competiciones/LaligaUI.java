package jpaswing.ui.competiciones;

import jpaswing.ui.PantallaPrimeraUI;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class LaligaUI extends JFrame {
    private JPanel panel1;
    private JButton inicioButton;
    public LaligaUI(){
        setTitle("EUROCOPA");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        initcomponents();
    }
    private void initcomponents(){
        panel1 = new JPanel();
        Color customColor = Color.decode("#51a331");
        inicioButton = new JButton("INICIO");

        this.setLayout(null);
        panel1.setLayout(null);

        panel1.setBackground(customColor);
        panel1.setBounds(0,0,1920,1080);

        inicioButton.setBounds(300, 100, 200, 100);
        inicioButton.addActionListener(e -> openPantallaPrimera());

        panel1.add(inicioButton);

        this.add(panel1);
    }
    private void openPantallaPrimera(){
        this.dispose();
        PantallaPrimeraUI pantallaPrimeraUI = PantallaPrimeraUI.getInstance();
        pantallaPrimeraUI.setVisible(true);
    }
}
