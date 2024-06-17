package jpaswing.ui.inicio;

import jpaswing.ui.inicio.InicioUI;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class InformacionUI extends JFrame{
    private JPanel panel1;
    private JLabel infoLabel;
    private JPanel panel2;
    private JButton returnButton;
    public InformacionUI(){
        setTitle("INFORMACIÓN");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        initComponents();
    }
    private void initComponents(){
        panel1 = new JPanel();
        // FutLife es una innovadora aplicación diseñada para los aficionados al fútbol que desean estar al tanto de los últimos resultados, próximos partidos, clasificaciones, equipos, jugadores, fichajes y mucho más. Con una interfaz intuitiva y amigable, FutLife te ofrece toda la información que necesitas sobre el mundo del fútbol en un solo lugar.
        infoLabel = new JLabel("");
        panel2 = new JPanel();
        Color customColor = Color.decode("#51a331");
        returnButton = new JButton("INICIO");

        this.setLayout(null);
        panel1.setLayout(null);
        panel2.setLayout(null);
        panel1.setBackground(customColor);
        panel1.setBounds(0,0,1920,1080);
        panel2.setBackground(Color.WHITE);
        panel2.setBounds(640, 200, 640, 680);

        // Configuración del botón

        returnButton.setBounds(100, 100, 200, 100);
        returnButton.addActionListener(e -> openHomeWindow());
        panel1.add(returnButton);

        this.add(panel1);
        this.add(panel2);
    }
    private void openHomeWindow(){
        this.dispose();
        InicioUI inicioUI = new InicioUI();
        inicioUI.setVisible(true);
    }
}
