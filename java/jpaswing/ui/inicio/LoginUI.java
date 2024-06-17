package jpaswing.ui.inicio;

import jpaswing.entity.Usuario;
import jpaswing.repository.UsuarioRepository;
import jpaswing.ui.PantallaPrimeraUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class LoginUI extends JFrame {
    private static LoginUI instance;
    private JPanel panel1;
    private JLabel usuarioLabel;
    private JLabel contrasenaLabel;
    private JTextField usuarioCorreoField;
    private JPasswordField contrasenaField;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private UsuarioRepository usuarioRepository;
    @Autowired
    public LoginUI(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
        initComponents();
        instance = this;
    }
    public static LoginUI getInstance(){
        return instance;
    }
    private void initComponents(){
        setTitle("INICIAR SESIÓN");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        Color customColor = Color.decode("#51a331");
        panel1 = new JPanel();
        usuarioLabel = new JLabel("Usuario: ");
        contrasenaLabel = new JLabel("Contraseña: ");
        usuarioCorreoField = new JTextField();
        contrasenaField = new JPasswordField();
        aceptarButton = new JButton("ACEPTAR");
        cancelarButton = new JButton("CANCELAR");

        this.setLayout(null);
        panel1.setLayout(null);

        panel1.setBackground(customColor);
        panel1.setBounds(0,0,1920,1080);

        // Datos

        usuarioLabel.setBounds(300, 200, 200, 100);
        contrasenaLabel.setBounds(300, 300, 200, 100);
        usuarioCorreoField.setBounds(500, 200, 200, 100);
        contrasenaField.setBounds(500, 300, 200, 100);

        // Botones

        aceptarButton.setBounds(500, 400, 200, 100);
        cancelarButton.setBounds(300, 400, 200, 100);
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprobarLogin();
            }
        });
        cancelarButton.addActionListener(e -> openHomeWindow());

        panel1.add(usuarioLabel);
        panel1.add(contrasenaLabel);
        panel1.add(usuarioCorreoField);
        panel1.add(contrasenaField);
        panel1.add(aceptarButton);
        panel1.add(cancelarButton);

        this.add(panel1);
    }
    private void openHomeWindow(){
        this.dispose();
        InicioUI inicioUI = new InicioUI();
        inicioUI.setVisible(true);
    }
    private void comprobarLogin(){
        String usuarioOCorreo = usuarioCorreoField.getText();
        String contrasena = new String(contrasenaField.getPassword());

        Usuario usuario = usuarioRepository.findByUsuarioAndContrasena(usuarioOCorreo, contrasena);

        if (usuario == null){
            JOptionPane.showMessageDialog(LoginUI.this, "Inicio de sesión incorrecto. Introduce los datos de nuevo");
            usuarioCorreoField.setText("");
            contrasenaField.setText("");
        }else{
            openPrimeraPantallaWindow();
            usuarioCorreoField.setText("");
            contrasenaField.setText("");
        }
    }
    private void openPrimeraPantallaWindow(){
        this.dispose();
        PantallaPrimeraUI pantallaPrimeraUI = PantallaPrimeraUI.getInstance();
        pantallaPrimeraUI.setVisible(true);
    }
}
