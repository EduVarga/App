package jpaswing.ui;

import jpaswing.entity.Partido;
import jpaswing.repository.PartidoRepository;
import jpaswing.ui.competiciones.*;
import jpaswing.ui.inicio.InicioUI;
import jpaswing.ui.partidos.Partido1UI;
import jpaswing.ui.partidos.Partido2UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class PantallaPrimeraUI extends JFrame {
    private static PantallaPrimeraUI instance;
    private JPanel panel1;
    private JButton logoutButton;
    private JButton noticiasButton;
    private JButton fichajesButton;
    private JButton partido1button;
    private JButton partido2button;
    private JButton partido3button;
    private PartidoRepository partidoRepository;
    private Partido partido;
    private JLabel equipo1Label;
    private JLabel horaoresultadoLabel;
    private JLabel equipo2Label;
    private JComboBox competicionesBox;
    @Autowired
    public PantallaPrimeraUI(PartidoRepository partidoRepository){
        this.partidoRepository = partidoRepository;
        initComponents();
        instance = this;
    }
    public static PantallaPrimeraUI getInstance() {return instance;}
    private void initComponents(){
        setTitle("INICIO");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        Color customColor = Color.decode("#51a331");
        panel1 = new JPanel();
        logoutButton = new JButton("CERRAR SESIÓN");
        noticiasButton = new JButton("NOTICIAS");
        fichajesButton = new JButton("FICHAJES");

        partido1button = new JButton();
        partido2button = new JButton();
        partido3button = new JButton();

        this.setLayout(null);
        panel1.setLayout(null);

        panel1.setBackground(customColor);
        panel1.setBounds(0, 0, 1920, 1080);

        // Botones

        logoutButton.setBounds(300, 100, 200, 100);
        logoutButton.addActionListener(e -> openInicioWindow());
        noticiasButton.setBounds(600, 100, 200, 100);
        noticiasButton.addActionListener(e -> openNoticiasWindow());
        fichajesButton.setBounds(900, 100, 200, 100);
        fichajesButton.addActionListener(e -> openFichajesWindow());

        // Partidos

        partido1button.setLayout(null);
        updateData(1);
        saveResults(partido1button);
        partido1button.setBounds(460, 400, 1000, 100);

        partido2button.setLayout(null);
        updateData(2);
        partido2button.setBounds(460, 600, 1000, 100);
        saveResults(partido2button);

        partido3button.setLayout(null);
        updateData(3);
        partido3button.setBounds(460, 800, 1000, 100);
        saveResults(partido3button);

        panel1.add(partido1button);
        panel1.add(partido2button);
        panel1.add(partido3button);

        // Panel de Competiciones

        String[] competicionesString = {"Eurocopa", "Laliga", "Serie A", "Premier League", "Bundesliga"};
        /*competicionesBox = new JComboBox<>(competicionesString);
        competicionesBox.setBounds(1200, 100, 200, 100);
        competicionesBox.addActionListener(e -> openCompeticionWindow());*/

        //panel1.add(competicionesBox);

        // Botones de partidos

        partido1button.addActionListener(e -> openPartido1Window());
        partido2button.addActionListener(e -> openPartido2Window());
        //partido3button.addActionListener(e -> openPartido3Window());

        panel1.add(logoutButton);
        panel1.add(noticiasButton);
        panel1.add(fichajesButton);

        this.add(panel1);
    }
    private void openPartido1Window(){
        this.dispose();
        Partido1UI partido1UI = Partido1UI.getInstance();
        partido1UI.setVisible(true);
    }
    private void openPartido2Window(){
        this.dispose();
        Partido2UI partido2UI = Partido2UI.getInstance();
        partido2UI.setVisible(true);
    }
    /*private void openPartido3Window(){
        this.dispose();
        Partido3UI partido3UI = new Partido3UI();
        partido3UI.setVisible(true);
    }*/
    private void openCompeticionWindow(){
        if (competicionesBox.getSelectedIndex() == 0){
            this.dispose();
            EurocopaUI eurocopaUI = new EurocopaUI();
            eurocopaUI.setVisible(true);
        }else if (competicionesBox.getSelectedIndex() == 1){
            this.dispose();
            LaligaUI laligaUI = new LaligaUI();
            laligaUI.setVisible(true);
        }else if (competicionesBox.getSelectedIndex() == 2){
            this.dispose();
            SerieAUI serieAUI = new SerieAUI();
            serieAUI.setVisible(true);
        }else if (competicionesBox.getSelectedIndex() == 3){
            this.dispose();
            PremierLeagueUI premierLeagueUI = new PremierLeagueUI();
            premierLeagueUI.setVisible(true);
        }else if (competicionesBox.getSelectedIndex() == 4){
            this.dispose();
            BundesligaUI bundesligaUI = new BundesligaUI();
            bundesligaUI.setVisible(true);
        }
    }
    private void updateData(int id){
        partido = partidoRepository.findById(id);
        equipo1Label = new JLabel(partido.getEqlocal());
        if (partido.getResultado() != null){
            horaoresultadoLabel = new JLabel(partido.getResultado());
        }else{
            horaoresultadoLabel = new JLabel(partido.getHora());
        }
        equipo2Label = new JLabel(partido.getEqvisitante());
        equipo1Label.setBounds(50,0, 200, 100);
        equipo2Label.setBounds(800, 0, 200, 100);
        horaoresultadoLabel.setBounds(450, 0, 100, 100);
    }
    private void saveResults(JButton partido){
        partido.add(equipo1Label);
        partido.add(equipo2Label);
        partido.add(horaoresultadoLabel);
    }
    private void openInicioWindow(){
        this.dispose();
        InicioUI inicioUI = new InicioUI();
        inicioUI.setVisible(true);
    }
    private void openNoticiasWindow(){
        this.dispose();
        NoticiasUI noticiasUI = NoticiasUI.getInstance();
        noticiasUI.setVisible(true);
    }
    private void openFichajesWindow(){
        this.dispose();
        FichajesUI fichajesUI = FichajesUI.getInstance();
        fichajesUI.setVisible(true);
    }
}
