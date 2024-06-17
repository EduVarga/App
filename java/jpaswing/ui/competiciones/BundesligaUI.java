package jpaswing.ui.competiciones;

import jpaswing.ui.PantallaPrimeraUI;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class BundesligaUI extends JFrame {
    private JPanel panel1;
    private JButton inicioButton;
    private JLabel textLabel;
    public BundesligaUI(){
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
        //textLabel = new JLabel("Servidor en mantenimiento. Inténtalo de nuevo más tarde");

        this.setLayout(null);
        panel1.setLayout(null);
        //textLabel.setLayout(null);

        panel1.setBackground(customColor);
        panel1.setBounds(0,0,1920,1080);

        inicioButton.setBounds(300, 100, 200, 100);
        inicioButton.addActionListener(e -> openPantallaPrimera());

        /*textLabel.setBackground(Color.WHITE);
        textLabel.setOpaque(true);
        textLabel.setBounds(710, 440, 500, 200);*/

        panel1.add(inicioButton);
        //panel1.add(textLabel);

        this.add(panel1);
    }
    private void openPantallaPrimera(){
        this.dispose();
        PantallaPrimeraUI pantallaPrimeraUI = PantallaPrimeraUI.getInstance();
        pantallaPrimeraUI.setVisible(true);
    }
}
