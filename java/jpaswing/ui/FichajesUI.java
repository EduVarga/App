package jpaswing.ui;

import jpaswing.entity.Fichaje;
import jpaswing.repository.FichajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class FichajesUI extends JFrame {
    private static FichajesUI instance;
    private JPanel panel1;
    private JButton inicioButton;
    private JButton oficialButton;
    private JButton rumorButton;
    private JLabel oficialLabel;
    private JLabel rumorLabel;
    private JLabel jugador1Label;
    private JLabel jugador2Label;
    private JLabel jugador3Label;
    private JLabel jugador4Label;
    private JLabel jugador5Label;
    private JLabel jugador6Label;
    private Fichaje fichaje;
    private JLabel imagenLabel;
    private JLabel nombreLabel;
    private JLabel anteriorLabel;
    private JLabel actualLabel;
    private JLabel precioLabel;
    private JLabel flechaLabel;
    private FichajeRepository fichajeRepository;
    private ImageIcon imagenIcon;
    @Autowired
    public FichajesUI(FichajeRepository fichajeRepository){
        this.fichajeRepository = fichajeRepository;
        initComponents();
        instance = this;
    }
    public static FichajesUI getInstance(){return instance;}
    private void initComponents(){
        setTitle("FICHAJES");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        panel1 = new JPanel();
        inicioButton = new JButton("INICIO");
        Color customColor = Color.decode("#51a331");
        Color customColor2 = Color.decode("#E3E3E3");
        oficialButton = new JButton("OFICIAL");
        rumorButton = new JButton("RUMOR");
        oficialLabel = new JLabel();
        rumorLabel = new JLabel();
        jugador1Label = new JLabel();
        jugadorLabelConfig(jugador1Label);
        jugador2Label = new JLabel();
        jugadorLabelConfig(jugador2Label);
        jugador3Label = new JLabel();
        jugadorLabelConfig(jugador3Label);
        jugador4Label = new JLabel();
        jugadorLabelConfig(jugador4Label);
        jugador5Label = new JLabel();
        jugadorLabelConfig(jugador5Label);
        jugador6Label = new JLabel();
        jugadorLabelConfig(jugador6Label);

        //

        oficialLabel.setLayout(null);
        rumorLabel.setLayout(null);
        jugador1Label.setLayout(null);
        jugador2Label.setLayout(null);
        jugador3Label.setLayout(null);
        jugador4Label.setLayout(null);
        jugador5Label.setLayout(null);
        jugador6Label.setLayout(null);
        oficialLabel.add(jugador1Label);
        jugador1Label.setBounds(260,0, 1000,160);
        updateData(jugador1Label, 1);
        oficialLabel.add(jugador2Label);
        jugador2Label.setBounds(260, 210, 1000, 160);
        updateData(jugador2Label, 2);
        oficialLabel.add(jugador3Label);
        jugador3Label.setBounds(260, 420, 1000, 160);
        updateData(jugador3Label, 3);
        rumorLabel.add(jugador4Label);
        jugador4Label.setBounds(260,0, 1000,160);
        updateData(jugador4Label, 4);
        rumorLabel.add(jugador5Label);
        jugador5Label.setBounds(260,210, 1000,160);
        updateData(jugador5Label, 5);
        rumorLabel.add(jugador6Label);
        jugador6Label.setBounds(260,420, 1000,160);
        updateData(jugador6Label, 6);

        //

        this.setLayout(null);
        panel1.setLayout(null);
        panel1.setBackground(customColor);

        oficialLabel.setBackground(customColor2);
        oficialLabel.setOpaque(true);
        rumorLabel.setBackground(customColor2);
        rumorLabel.setOpaque(true);

        panel1.setBounds(0,0,1920,1080);
        oficialButton.setBounds(600, 250, 200, 100);
        rumorButton.setBounds(1120, 250, 200, 100);
        oficialLabel.setBounds(200, 400, 1520, 580);
        rumorLabel.setBounds(200, 400, 1520, 580);
        rumorLabel.setVisible(false);

        // Botones

        inicioButton.setBounds(300, 100, 200, 100);
        inicioButton.addActionListener(e -> openPantallaPrimeraWindow());
        oficialButton.addActionListener(e -> showFichajesOficiales());
        rumorButton.addActionListener(e -> showFichajesRumor());

        panel1.add(inicioButton);
        panel1.add(oficialButton);
        panel1.add(rumorButton);
        panel1.add(oficialLabel);
        panel1.add(rumorLabel);
        this.add(panel1);

    }
    private void updateData(JLabel jugadorLabel, int id){
        fichaje = fichajeRepository.findById(id);

        String rutaRelativa2 = String.valueOf(fichaje.getFoto());
        imagenLabel = new JLabel();
        getImages(rutaRelativa2, 100, 100, imagenLabel);
        imagenLabel.setBounds(30, 30, 100, 100);

        nombreLabel = new JLabel(fichaje.getNombre());
        nombreLabel.setBounds(160, 30, 200, 100);

        String rutaRelativa3 = String.valueOf(fichaje.getAnterior());
        anteriorLabel = new JLabel();
        getImages(rutaRelativa3, 100, 100, anteriorLabel);
        anteriorLabel.setBounds(740, 30, 100, 100);

        String rutaRelativa4 = String.valueOf(fichaje.getActual());
        actualLabel = new JLabel();
        getImages(rutaRelativa4, 100, 100, actualLabel);
        actualLabel.setBounds(870, 30, 100, 100);

        if (fichaje.getPrecio() != null){
            precioLabel = new JLabel(fichaje.getPrecio());
            jugadorLabel.add(precioLabel);
            precioLabel.setBounds(500, 30, 100, 100);
        }

        String rutaRelativa1 = "/imagenes/flecha.jpg";
        flechaLabel = new JLabel();
        getImages(rutaRelativa1, 30, 30, flechaLabel);
        flechaLabel.setBounds(840, 65, 30, 30);

        jugadorLabel.add(imagenLabel);
        jugadorLabel.add(nombreLabel);
        jugadorLabel.add(anteriorLabel);
        jugadorLabel.add(actualLabel);
        jugadorLabel.add(flechaLabel);
    }
    private void getImages(String rutaRelativa, int width, int height, JLabel label){
        imagenIcon = new ImageIcon(FichajesUI.class.getResource(rutaRelativa));
        Image originalImage = imagenIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        label.setIcon(scaledIcon);
    }
    private void openPantallaPrimeraWindow(){
        this.dispose();
        PantallaPrimeraUI pantallaPrimeraUI = PantallaPrimeraUI.getInstance();
        pantallaPrimeraUI.setVisible(true);
    }
    private void showFichajesOficiales(){
        rumorLabel.setVisible(false);
        oficialLabel.setVisible(true);
    }
    private void showFichajesRumor(){
        oficialLabel.setVisible(false);
        rumorLabel.setVisible(true);
    }
    private void jugadorLabelConfig(JLabel jugadorLabel){
        jugadorLabel.setBackground(Color.WHITE);
        jugadorLabel.setOpaque(true);
    }
}
