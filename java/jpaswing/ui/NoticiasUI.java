package jpaswing.ui;

import jpaswing.entity.Noticia;
import jpaswing.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class NoticiasUI extends JFrame {
    private static NoticiasUI instance;
    private JPanel panel1;
    private JButton noticia1Button;
    private JButton noticia2Button;
    private JButton noticia3Button;
    private JButton inicioButton;
    private JLabel imagenLabel;
    private JLabel titularLabel;
    private JLabel cortaLabel;
    private ImageIcon imageIcon;
    private Noticia noticia;
    private NoticiaRepository noticiaRepository;
    @Autowired
    public NoticiasUI(NoticiaRepository noticiaRepository){
        this.noticiaRepository = noticiaRepository;
        initComponents();
        instance = this;
    }
    public static NoticiasUI getInstance(){return instance;}
    private void initComponents(){
        setTitle("NOTICIAS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        panel1 = new JPanel();
        inicioButton = new JButton("INICIO");
        Color customColor = Color.decode("#51a331");
        noticia1Button = new JButton();
        noticia1Button.setLayout(null);
        noticia2Button = new JButton();
        noticia2Button.setLayout(null);
        noticia3Button = new JButton();
        noticia3Button.setLayout(null);

        this.setLayout(null);
        panel1.setLayout(null);
        panel1.setBackground(customColor);
        noticia1Button.setBackground(Color.WHITE);
        noticia2Button.setBackground(Color.WHITE);
        noticia3Button.setBackground(Color.WHITE);

        panel1.setBounds(0,0,1920,1080);
        noticia1Button.setBounds(150, 300, 500, 580);
        noticia2Button.setBounds(710, 300, 500, 580);
        noticia3Button.setBounds(1270, 300, 500, 580);

        configureNew(1, noticia1Button);
        configureNew(2, noticia2Button);
        configureNew(3, noticia3Button);

        // Botones

        inicioButton.setBounds(300, 100, 200, 100);
        inicioButton.addActionListener(e -> openPantallaPrimeraWindow());

        //noticia1Button.addActionListener(e -> showCompleteNew());

        panel1.add(inicioButton);
        panel1.add(noticia1Button);
        panel1.add(noticia2Button);
        panel1.add(noticia3Button);
        this.add(panel1);

    }
    private void showCompleteNew(){
        noticia2Button.setVisible(false);
        noticia3Button.setVisible(false);
        noticia1Button.setBounds(150, 300, 1620, 680);
        
    }
    private void configureNew(int id, JButton boton){
        noticia = noticiaRepository.findById(id);

        String rutaRelativa = String.valueOf(noticia.getImagen());
        imagenLabel = new JLabel();
        imageIcon = new ImageIcon(NoticiasUI.class.getResource(rutaRelativa));
        Image originalImage = imageIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        imagenLabel.setIcon(scaledIcon);
        imagenLabel.setBounds(100, 50, 300, 200);

        titularLabel = new JLabel(noticia.getTitular());
        titularLabel.setBounds(100, 300, 300, 100);

        cortaLabel = new JLabel(noticia.getCorta());
        cortaLabel.setBounds(100, 400, 300, 150);

        boton.add(imagenLabel);
        boton.add(titularLabel);
        boton.add(cortaLabel);
    }
    private void openPantallaPrimeraWindow(){
        this.dispose();
        PantallaPrimeraUI pantallaPrimeraUI = PantallaPrimeraUI.getInstance();
        pantallaPrimeraUI.setVisible(true);
    }
}
