package jpaswing.ui.inicio;

import jpaswing.entity.Usuario;
import jpaswing.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class RegistroUI extends JFrame {
    private static RegistroUI instance;
    private JPanel panel1;
    private JLabel nombreLabel;
    private JLabel usuarioLabel;
    private JLabel correoLabel;
    private JLabel contrasenaLabel;
    private JTextField nombreField;
    private JTextField usuarioField;
    private JTextField correoField;
    private JPasswordField contrasenaField;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private UsuarioRepository usuarioRepository;
    @Autowired
    public RegistroUI(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
        initComponents();
        instance = this;
    }
    public static RegistroUI getInstance(){
        return instance;
    }
    private void initComponents(){
        setTitle("REGISTRARSE");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        Color customColor = Color.decode("#51a331");
        panel1 = new JPanel();
        nombreLabel = new JLabel("Nombre: ");
        usuarioLabel = new JLabel("Usuario: ");
        correoLabel = new JLabel("Correo electrónico: ");
        contrasenaLabel = new JLabel("Contraseña: ");
        nombreField = new JTextField();
        usuarioField = new JTextField();
        correoField = new JTextField();
        contrasenaField = new JPasswordField();
        aceptarButton = new JButton("ACEPTAR");
        cancelarButton = new JButton("CANCELAR");

        this.setLayout(null);
        panel1.setLayout(null);

        panel1.setBackground(customColor);
        panel1.setBounds(0,0,1920,1080);

        // Datos

        nombreLabel.setBounds(400, 100, 200, 100);
        usuarioLabel.setBounds(400, 200, 200, 100);
        correoLabel.setBounds(400, 300, 200, 100);
        contrasenaLabel.setBounds(400, 400, 200, 100);
        nombreField.setBounds(600, 100, 200, 100);
        usuarioField.setBounds(600, 200, 200, 100);
        correoField.setBounds(600, 300, 200, 100);
        contrasenaField.setBounds(600, 400, 200, 100);

        // Botones

        aceptarButton.setBounds(600, 500, 200, 100);
        cancelarButton.setBounds(400, 500, 200, 100);
        cancelarButton.addActionListener(e -> openInicioWindow());
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });

        panel1.add(nombreLabel);
        panel1.add(usuarioLabel);
        panel1.add(correoLabel);
        panel1.add(contrasenaLabel);
        panel1.add(nombreField);
        panel1.add(usuarioField);
        panel1.add(correoField);
        panel1.add(contrasenaField);
        panel1.add(aceptarButton);
        panel1.add(cancelarButton);

        this.add(panel1);

    }
    private void openInicioWindow(){
        this.dispose();
        InicioUI inicioUI = new InicioUI();
        inicioUI.setVisible(true);
    }
    private void registrarUsuario(){
        String nombre = nombreField.getText();
        String usuario = usuarioField.getText();
        String correo = correoField.getText();
        String contrasena = new String(contrasenaField.getPassword());

        boolean usuarioExiste = verificarUsuarioExistente(usuario);

        if (usuarioExiste){
            JOptionPane.showMessageDialog(this, "El nombre de usuario ya existe. Inténtalo de nuevo");
            nombreField.setText("");
            usuarioField.setText("");
            correoField.setText("");
            contrasenaField.setText("");
        }else{
            insertarUsuario(nombre, usuario, correo, contrasena);
            JOptionPane.showMessageDialog(this, "Usuario creado correctamente");
            nombreField.setText("");
            usuarioField.setText("");
            correoField.setText("");
            contrasenaField.setText("");
        }

    }
    private boolean verificarUsuarioExistente(String usuario){
        Usuario usuario1 = usuarioRepository.findByUsuario(usuario);
        return usuario1 != null;
    }
    private void insertarUsuario(String nombre, String usuario, String correo, String contrasena){
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setUsuario(usuario);
        nuevoUsuario.setCorreo(correo);
        nuevoUsuario.setContrasena(contrasena);
        usuarioRepository.save(nuevoUsuario);
    }
}
