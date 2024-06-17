package jpaswing.ui.partidos;

import jpaswing.entity.Estadio;
import jpaswing.entity.Resultado;
import jpaswing.repository.EstadioRepository;
import jpaswing.repository.ResultadoRepository;
import jpaswing.ui.PantallaPrimeraUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class Partido2UI extends JFrame {
    private static Partido2UI instance;
    private JPanel panel1;
    private JButton volverButton;
    private ResultadoRepository resultadoRepository;
    private JLabel onceInicialLabel;
    private JLabel estadioLabel;
    private JButton alineacionesButton;
    private JButton estadioButton;
    private JLabel equipo1Label;
    private JLabel equipo2Label;
    private Resultado resultado;
    private JLabel imagenLabel;
    private JLabel dorsalLabel;
    private JLabel nombreLabel;
    private ImageIcon imageIcon;
    private JLabel jugador1Label;
    private JLabel jugador2Label;
    private JLabel jugador3Label;
    private JLabel jugador4Label;
    private JLabel jugador5Label;
    private JLabel jugador6Label;
    private JLabel jugador7Label;
    private JLabel jugador8Label;
    private JLabel jugador9Label;
    private JLabel jugador10Label;
    private JLabel jugador11Label;
    private JLabel jugador12Label;
    private JLabel jugador13Label;
    private JLabel jugador14Label;
    private JLabel jugador15Label;
    private JLabel jugador16Label;
    private JLabel jugador17Label;
    private JLabel jugador18Label;
    private JLabel jugador19Label;
    private JLabel jugador20Label;
    private JLabel jugador21Label;
    private JLabel jugador22Label;
    private JLabel direccionLabel;
    private Estadio estadio;
    private EstadioRepository estadioRepository;
    @Autowired
    public Partido2UI(ResultadoRepository resultadoRepository, EstadioRepository estadioRepository){
        this.resultadoRepository = resultadoRepository;
        this.estadioRepository = estadioRepository;
        initComponents();
        instance = this;
    }
    public static Partido2UI getInstance(){return instance;}
    private void initComponents(){
        setTitle("BORUSSIA DORTMUND - REAL MADRID");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        panel1 = new JPanel();
        volverButton = new JButton("ATRÁS");
        Color customColor = Color.decode("#51a331");
        onceInicialLabel = new JLabel();
        estadioLabel = new JLabel();
        alineacionesButton = new JButton("ALINEACIONES");
        estadioButton = new JButton("ESTADIO");
        equipo1Label = new JLabel();
        equipo2Label = new JLabel();
        Color customColor2 = Color.decode("#E3E3E3");

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
        jugador7Label = new JLabel();
        jugadorLabelConfig(jugador7Label);
        jugador8Label = new JLabel();
        jugadorLabelConfig(jugador8Label);
        jugador9Label = new JLabel();
        jugadorLabelConfig(jugador9Label);
        jugador10Label = new JLabel();
        jugadorLabelConfig(jugador10Label);
        jugador11Label = new JLabel();
        jugadorLabelConfig(jugador11Label);

        jugador12Label = new JLabel();
        jugadorLabelConfig(jugador12Label);
        jugador13Label = new JLabel();
        jugadorLabelConfig(jugador13Label);
        jugador14Label = new JLabel();
        jugadorLabelConfig(jugador14Label);
        jugador15Label = new JLabel();
        jugadorLabelConfig(jugador15Label);
        jugador16Label = new JLabel();
        jugadorLabelConfig(jugador16Label);
        jugador17Label = new JLabel();
        jugadorLabelConfig(jugador17Label);
        jugador18Label = new JLabel();
        jugadorLabelConfig(jugador18Label);
        jugador19Label = new JLabel();
        jugadorLabelConfig(jugador19Label);
        jugador20Label = new JLabel();
        jugadorLabelConfig(jugador20Label);
        jugador21Label = new JLabel();
        jugadorLabelConfig(jugador21Label);
        jugador22Label = new JLabel();
        jugadorLabelConfig(jugador22Label);

        this.setLayout(null);
        panel1.setLayout(null);
        onceInicialLabel.setLayout(null);
        estadioLabel.setLayout(null);
        equipo1Label.setLayout(null);
        equipo2Label.setLayout(null);

        jugador1Label.setLayout(null);
        jugador2Label.setLayout(null);
        jugador3Label.setLayout(null);
        jugador4Label.setLayout(null);
        jugador5Label.setLayout(null);
        jugador6Label.setLayout(null);
        jugador7Label.setLayout(null);
        jugador8Label.setLayout(null);
        jugador9Label.setLayout(null);
        jugador10Label.setLayout(null);
        jugador11Label.setLayout(null);

        jugador12Label.setLayout(null);
        jugador13Label.setLayout(null);
        jugador14Label.setLayout(null);
        jugador15Label.setLayout(null);
        jugador16Label.setLayout(null);
        jugador17Label.setLayout(null);
        jugador18Label.setLayout(null);
        jugador19Label.setLayout(null);
        jugador20Label.setLayout(null);
        jugador21Label.setLayout(null);
        jugador22Label.setLayout(null);

        equipo1Label.add(jugador1Label);
        jugador1Label.setBounds(0, 0, 500, 50);
        mostrarEquipo(jugador1Label, 23);
        equipo1Label.add(jugador2Label);
        jugador2Label.setBounds(0, 50, 500, 50);
        mostrarEquipo(jugador2Label, 24);
        equipo1Label.add(jugador3Label);
        jugador3Label.setBounds(0, 100, 500, 50);
        mostrarEquipo(jugador3Label, 25);
        equipo1Label.add(jugador4Label);
        jugador4Label.setBounds(0, 150, 500, 50);
        mostrarEquipo(jugador4Label, 26);
        equipo1Label.add(jugador5Label);
        jugador5Label.setBounds(0, 200, 500, 50);
        mostrarEquipo(jugador5Label, 27);
        equipo1Label.add(jugador6Label);
        jugador6Label.setBounds(0, 250, 500, 50);
        mostrarEquipo(jugador6Label, 28);
        equipo1Label.add(jugador7Label);
        jugador7Label.setBounds(0, 300, 500, 50);
        mostrarEquipo(jugador7Label, 29);
        equipo1Label.add(jugador8Label);
        jugador8Label.setBounds(0, 350, 500, 50);
        mostrarEquipo(jugador8Label, 30);
        equipo1Label.add(jugador9Label);
        jugador9Label.setBounds(0, 400, 500, 50);
        mostrarEquipo(jugador9Label, 31);
        equipo1Label.add(jugador10Label);
        jugador10Label.setBounds(0, 450, 500, 50);
        mostrarEquipo(jugador10Label, 32);
        equipo1Label.add(jugador11Label);
        jugador11Label.setBounds(0, 500, 500, 50);
        mostrarEquipo(jugador11Label, 33);

        equipo2Label.add(jugador12Label);
        jugador12Label.setBounds(0, 0, 500, 50);
        mostrarEquipo(jugador12Label, 34);
        equipo2Label.add(jugador13Label);
        jugador13Label.setBounds(0, 50, 500, 50);
        mostrarEquipo(jugador13Label, 35);
        equipo2Label.add(jugador14Label);
        jugador14Label.setBounds(0, 100, 500, 50);
        mostrarEquipo(jugador14Label, 36);
        equipo2Label.add(jugador15Label);
        jugador15Label.setBounds(0, 150, 500, 50);
        mostrarEquipo(jugador15Label, 37);
        equipo2Label.add(jugador16Label);
        jugador16Label.setBounds(0, 200, 500, 50);
        mostrarEquipo(jugador16Label, 38);
        equipo2Label.add(jugador17Label);
        jugador17Label.setBounds(0, 250, 500, 50);
        mostrarEquipo(jugador17Label, 39);
        equipo2Label.add(jugador18Label);
        jugador18Label.setBounds(0, 300, 500, 50);
        mostrarEquipo(jugador18Label, 40);
        equipo2Label.add(jugador19Label);
        jugador19Label.setBounds(0, 350, 500, 50);
        mostrarEquipo(jugador19Label, 41);
        equipo2Label.add(jugador20Label);
        jugador20Label.setBounds(0, 400, 500, 50);
        mostrarEquipo(jugador20Label, 42);
        equipo2Label.add(jugador21Label);
        jugador21Label.setBounds(0, 450, 500, 50);
        mostrarEquipo(jugador21Label, 43);
        equipo2Label.add(jugador22Label);
        jugador22Label.setBounds(0, 500, 500, 50);
        mostrarEquipo(jugador22Label, 44);

        mostrarEstadio(2);

        equipo1Label.setOpaque(true);
        equipo2Label.setOpaque(true);

        panel1.setBackground(customColor);
        panel1.setBounds(0,0,1920,1080);

        volverButton.setBounds(300, 100, 200, 100);
        volverButton.addActionListener(e -> openPantallaPrimera());
        alineacionesButton.setBounds(600, 100, 200, 100);
        alineacionesButton.addActionListener(e -> showAlineacionesLabel());
        estadioButton.setBounds(900, 100, 200, 100);
        estadioButton.addActionListener(e -> showEstadioLabel());

        onceInicialLabel.setBackground(customColor2);
        onceInicialLabel.setOpaque(true);
        estadioLabel.setBackground(Color.WHITE);
        estadioLabel.setOpaque(true);
        onceInicialLabel.setBounds(200, 300, 1520, 650);
        estadioLabel.setBounds(200, 300, 1520, 650);
        estadioLabel.setVisible(false);
        estadioLabel.setBackground(customColor2);

        onceInicialLabel.add(equipo1Label);
        onceInicialLabel.add(equipo2Label);

        equipo1Label.setBounds(130, 50, 500, 600);
        equipo2Label.setBounds(890, 50, 500, 600);

        for (int i = 1; i <= 11; i++){
            mostrarEquipo(equipo1Label, i);
        }

        panel1.add(volverButton);
        panel1.add(onceInicialLabel);
        panel1.add(estadioLabel);
        panel1.add(alineacionesButton);
        panel1.add(estadioButton);

        this.add(panel1);
    }
    private void jugadorLabelConfig(JLabel jugadorLabel){
        jugadorLabel.setBackground(Color.WHITE);
        jugadorLabel.setOpaque(true);
    }
    private void mostrarEstadio(int id){
        estadio = estadioRepository.findById(id);

        String rutaRelativa = String.valueOf(estadio.getImagen());
        imagenLabel = new JLabel();
        getImages(rutaRelativa, 800, 550, imagenLabel);
        imagenLabel.setBounds(100, 50, 800, 550);

        nombreLabel = new JLabel(estadio.getNombre());
        nombreLabel.setBounds(1000, 200, 420, 125);

        direccionLabel = new JLabel(estadio.getDireccion());
        direccionLabel.setBounds(1000, 325, 420, 125);

        estadioLabel.add(imagenLabel);
        estadioLabel.add(nombreLabel);
        estadioLabel.add(direccionLabel);

    }
    private void mostrarEquipo(JLabel jugadorLabel, int id){
        resultado = resultadoRepository.findById(id);

        String rutaRelativa = String.valueOf(resultado.getImagen());
        imagenLabel = new JLabel();
        getImages(rutaRelativa, 50,50, imagenLabel);
        imagenLabel.setBounds(20, 0, 50, 50);

        dorsalLabel = new JLabel(Integer.toString(resultado.getDorsal()));
        dorsalLabel.setBounds(90, 0, 50, 50);

        nombreLabel = new JLabel(resultado.getNombre());
        nombreLabel.setBounds(160, 0, 420, 50);

        jugadorLabel.add(imagenLabel);
        jugadorLabel.add(dorsalLabel);
        jugadorLabel.add(nombreLabel);

    }
    private void getImages(String rutaRelativa, int width, int height, JLabel label){
        imageIcon = new ImageIcon(Partido2UI.class.getResource(rutaRelativa));
        Image originalImage = imageIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        label.setIcon(scaledIcon);
    }
    private void showAlineacionesLabel(){
        estadioLabel.setVisible(false);
        onceInicialLabel.setVisible(true);
    }
    private void showEstadioLabel(){
        onceInicialLabel.setVisible(false);
        estadioLabel.setVisible(true);
    }
    private void openPantallaPrimera(){
        this.dispose();
        PantallaPrimeraUI pantallaPrimeraUI = PantallaPrimeraUI.getInstance();
        pantallaPrimeraUI.setVisible(true);
    }
}
