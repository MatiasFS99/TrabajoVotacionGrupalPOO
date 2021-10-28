import java.util.List;
import java.util.Map;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.font.TextAttribute;

public class Main {
    public static List<Candidato> candidatos = GenerarDatos.candidatos();
    public static List<PartidoPoliticoAlianza> partidos = GenerarDatos.partidos();
    public static List<Lista> listas = GenerarDatos.listas();
    public static List<Persona> personas = GenerarDatos.personas();
    public static List<ElectorInscripto> electores = GenerarDatos.elector();
    public static List<MesaElectoral> mesasElectorales = GenerarDatos.mesasElectorales();
    public static List<Circuito> circuitos = GenerarDatos.circuitos();
    public static List<Seccion> secciones = GenerarDatos.secciones();
    public static List<Distrito> distritos = GenerarDatos.distritos();
    public static Boolean Abierto = true;
    

    public static Font ftitulo = new Font("TimesRoman", (Font.BOLD + Font.ITALIC), 20);
    public static Map subrrayado = ftitulo.getAttributes();
    private static void init(){
        GenerarDatos.asignarListasMesas();
        subrrayado.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        ftitulo = ftitulo.deriveFont(subrrayado);
        asignarMesas();
    }

    private static void asignarMesas(){
        for (MesaElectoral mesa : Main.mesasElectorales) {
            for (ElectorInscripto elector : mesa.getElectores()) {
                elector.setMesaAsignada(mesa);
            }
        }
        int i = 1;
        for (Circuito circuito : circuitos) {
            i=1;
            for (MesaElectoral mesa : circuito.getMesas()) {
                mesa.setNumeroMesa(i);
                i++;
            }
        }
    }

    public static void usermode(){
        
        //inicializa la fuente
        init();
        //genera la ventana
        Ventana principal = new Ventana("Sistema Unico De Voto Electronico", 600, 600, true);
        //Crea el toma el panel principal de la ventana
        Container cp = principal.getContentPane();
        cp.setLayout(new BorderLayout());
        //creo el titulo que se ve arriba en la ventana
        JLabel titulo = new JLabel("Sistema Unico de Voto Electronico");
        titulo.setHorizontalAlignment((cp.getWidth()/2)-(titulo.getWidth()/2));
        titulo.setFont(ftitulo);
        //creo el footer para la ventana
        JLabel footer = new JLabel("Este es un servicio suministrado por el estado argentino");
        footer.setHorizontalAlignment((cp.getWidth()/2)-(footer.getWidth()/2));
        //cargo las imagenes
        ImageIcon urna = new ImageIcon("imgs\\urna.png", "urna");
        JLabel Lurna = new JLabel(urna);
        ImageIcon escudo = new ImageIcon("imgs\\escudo.png", "escudo");
        JLabel Lescudo = new JLabel(escudo);
        //creo la parte central
        JLabel tituloCentro = new JLabel("Introduzca los datos");
        tituloCentro.setFont(tituloCentro.getFont().deriveFont(subrrayado));

        JButton botEnviar = new JButton("Enviar");
        JLabel labDni = new JLabel("Dni");
        JTextField Dni = new JTextField(20);
        //esto es para abrir debug
            KeyStroke combinacionDebug = KeyStroke.getKeyStroke("shift ctrl pressed SPACE");
            Action abrirDebug = new AbstractAction() {
                public void actionPerformed(ActionEvent actionEvent) {
                    if(Dni.getText().equals("Debug Mode 1235")||!Abierto){
                        new VentanaLoginDebug();
                    }
                }
            };
            InputMap inputMap = botEnviar.getInputMap();
            inputMap.put(combinacionDebug, "entrarDebug");
            ActionMap actionMap = botEnviar.getActionMap();
            actionMap.put("entrarDebug", abrirDebug);
            botEnviar.setActionMap(actionMap);
        //aca sigue normal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalStrut(35));
        panel.add(Ventana.crearPanelMedio(tituloCentro));
        panel.add(Ventana.crearPanelMedio(labDni,Dni));
        panel.add(Ventana.crearPanelMedio(botEnviar));
        botEnviar.addActionListener(new ManejadorMain(Dni));

        //aplico las partes a la ventana
        cp.add(titulo, BorderLayout.NORTH);
        cp.add(panel, BorderLayout.CENTER);
        cp.add(footer, BorderLayout.SOUTH);
        cp.add(Lurna, BorderLayout.WEST);
        cp.add(Lescudo, BorderLayout.EAST);
        principal.setVisible(true);

        botEnviar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!Abierto){
                    Dni.setEditable(false);
                    botEnviar.setEnabled(false);
                    tituloCentro.setText("las elecciones finalizaron");
                }
            }
        });
        Dni.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!Abierto){
                    Dni.setEditable(false);
                    botEnviar.setEnabled(false);
                }
            }
        });
    }

    public static void main(String[] args) {
        if(args.length==1){
            if(args[0].equals("debugmode")){
               new VentanaLoginDebug();
               usermode();
            }
            else {
                usermode();
            }
        }else{
            usermode();
        }
    }
}
