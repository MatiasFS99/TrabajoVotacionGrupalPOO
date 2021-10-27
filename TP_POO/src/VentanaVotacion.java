import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaVotacion {
    public VentanaVotacion(ElectorInscripto input){
        MesaElectoral mesa = input.getMesaAsignda();
        Ventana v = new Ventana("Votacion", 600, 600, false);
        Container cp = v.getContentPane();
        cp.setLayout(new BorderLayout());
        JLabel titulo = new JLabel("Sistema Unico de Voto Electronico");
        titulo.setHorizontalAlignment((cp.getWidth()/2)-(titulo.getWidth()/2));
        titulo.setFont(Main.ftitulo);
        JLabel labNombApel = new JLabel("Nombre y apellido: "+input.getPersona().getNombre()+" "+input.getPersona().getApellido());
        JLabel labDni = new JLabel("DNI: "+input.getPersona().getDni());
        JLabel labPartidos = new JLabel("Partido a votar: ");
        JComboBox<String> partidos = new JComboBox<String>();
        for (PartidoPoliticoAlianza part : mesa.getPartidos()) {
            partidos.addItem(part.getNombre());
        }
        JButton votar = new JButton("Votar");
        JButton cancelar = new JButton("Cancelar");
        votar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                mesa.Votar(input, partidos.getSelectedItem().toString());
                v.dispose();
            }
        });
        cancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                v.dispose();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalStrut(20));
        panel.add((Ventana.crearPanelMedio(labNombApel,labDni)));
        panel.add(Box.createVerticalGlue());
        panel.add((Ventana.crearPanelMedio(labPartidos,partidos)));
        panel.add(Box.createVerticalGlue());

        cp.add(titulo,BorderLayout.NORTH);
        cp.add(panel, BorderLayout.CENTER);
        cp.add((Ventana.crearPanelMedio(cancelar, votar)), BorderLayout.SOUTH);
        v.setVisible(true);
    }

}
