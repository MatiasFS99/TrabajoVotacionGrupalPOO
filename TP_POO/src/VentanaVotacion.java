import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

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
        JLabel labNombApel = new JLabel("Nombre y apellido: "+input.getNombre()+" "+input.getApellido());
        JLabel labDni = new JLabel("DNI: "+input.getDni());
        JLabel labDiputados = new JLabel("Lista de Diputados a votar: ");
        JComboBox<Lista> diputados = new JComboBox<Lista>();
        for (Lista list : Main.listas) {
            if(Objects.nonNull(mesa.getVotosDiputados().get(list.getNroDeLista()))){
                diputados.addItem(list);
            }
        }
        JLabel labSenadores = new JLabel("Lista de Diputados a votar: ");
        JComboBox<Lista> senadores = new JComboBox<Lista>();
        for (Lista list : Main.listas) {
            if(Objects.nonNull(mesa.getVotosSenadores().get(list.getNroDeLista()))){
                senadores.addItem(list);
            }
        }
        JButton votar = new JButton("Votar");
        JButton cancelar = new JButton("Cancelar");
        votar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                mesa.Votar(input, ((Lista)diputados.getSelectedItem()).getNroDeLista(), ((Lista)senadores.getSelectedItem()).getNroDeLista());
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
        panel.add((Ventana.crearPanelMedio(labSenadores,senadores)));
        panel.add(Box.createVerticalGlue());
        panel.add(Box.createVerticalGlue());
        panel.add((Ventana.crearPanelMedio(labDiputados,diputados)));
        panel.add(Box.createVerticalGlue());

        cp.add(titulo,BorderLayout.NORTH);
        cp.add(panel, BorderLayout.CENTER);
        cp.add((Ventana.crearPanelMedio(cancelar, votar)), BorderLayout.SOUTH);
        v.setVisible(true);
    }

}
