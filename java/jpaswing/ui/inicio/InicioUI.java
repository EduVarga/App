package jpaswing.ui.inicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class InicioUI extends JFrame {
    private JPanel panel1;
    private JButton infoButton;
    private ImageIcon pelotaIcon;
    private JLabel imageLabel;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel futLabel;
    private JLabel lifeLabel;
    private JLabel barra1Label;
    private JLabel barra2Label;
    @Autowired
    public InicioUI(){
        setTitle("INICIO");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
    }
    private void initComponents(){
        panel1 = new JPanel();
        infoButton = new JButton("Obtener Información");
        Color customColor = Color.decode("#51a331");
        imageLabel = new JLabel();
        loginButton = new JButton("Iniciar Sesión");
        registerButton = new JButton("Registrarse");
        futLabel = new JLabel("Fut");
        lifeLabel = new JLabel("Life");
        barra1Label = new JLabel("|");
        barra2Label = new JLabel("|");

        this.setLayout(null);
        panel1.setLayout(null);
        panel1.setBounds(0,0,1920,1080);
        panel1.setBackground(customColor);

        int imageWidth = 250;
        int imageHeight = 250;
        imageLabel.setBounds((1920 - imageWidth) / 2, (1080 - imageHeight) / 2, imageWidth, imageHeight);

        // Imagen central

        String rutaRelativa = "/imagenes/pelota.png";
        pelotaIcon = new ImageIcon(InicioUI.class.getResource(rutaRelativa));
        Image originalImage = pelotaIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        imageLabel.setIcon(scaledIcon);

        // Configuración de las barras

        configLabel(barra1Label, 735, 65, 100, 200);
        configLabel(barra2Label, 1185, 65, 100, 200);
        // Windows
        /*configLabel(futLabel, 800, 750, 200, 200);
        configLabel(lifeLabel, 950, 751, 200, 200);*/
        // Linux
        configLabel(futLabel, 780, 750, 200, 200);
        configLabel(lifeLabel, 950, 750, 300, 200);
        barra1Label.setFont(new Font("SansSerif", Font.PLAIN, 30));
        barra2Label.setFont(new Font("SansSerif", Font.PLAIN, 30));
        futLabel.setFont(new Font("SansSerif", Font.PLAIN, 100));
        lifeLabel.setFont(new Font("SansSerif", Font.BOLD, 100));

        // Configuración de los botones

        configButton(registerButton, 1260, 120, 200, 100);
        configButton(loginButton, 460, 120, 200, 100);
        configButton(infoButton, 810, 120, 300, 100);
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        registerButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        infoButton.setFont(new Font("SansSerif", Font.BOLD, 20));

        // Configurar botones para cambiar de ventanas

        infoButton.addActionListener(e -> openInfoWindow());
        loginButton.addActionListener(e -> openLoginWindow());
        registerButton.addActionListener(e -> openRegistrarseWindow());

        panel1.add(infoButton);
        panel1.add(imageLabel);
        panel1.add(loginButton);
        panel1.add(registerButton);
        panel1.add(futLabel);
        panel1.add(lifeLabel);
        panel1.add(barra1Label);
        panel1.add(barra2Label);

        this.add(panel1);
    }
    private void configButton(JButton button, int x, int y, int width, int height){
        button.setForeground(Color.WHITE);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        button.setBounds(x, y, width, height);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                Color customColor = Color.decode("#196A00");
                button.setForeground(customColor);
            }
            @Override
            public void mouseExited(MouseEvent e){
                button.setForeground(Color.WHITE);
            }
        });
    }
    private void configLabel(JLabel label, int x, int y, int width, int height){
        label.setForeground(Color.WHITE);
        label.setBounds(x, y, width, height);
    }
    private void openInfoWindow(){
        this.dispose();
        InformacionUI informacionUI = new InformacionUI();
        informacionUI.setVisible(true);
    }
    private void openLoginWindow(){
        this.dispose();
        LoginUI loginUI = LoginUI.getInstance();
        loginUI.setVisible(true);
    }
    private void openRegistrarseWindow(){
        this.dispose();
        RegistroUI registroUI = RegistroUI.getInstance();
        registroUI.setVisible(true);
    }
}
