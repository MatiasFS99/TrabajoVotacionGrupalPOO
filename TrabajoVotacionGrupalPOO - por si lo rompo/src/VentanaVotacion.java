/**
 * Nombre de clase:  VentanaVotacion
 * Genera una ventana que permite votar a un usuario especifico
 * @version: 22/09/2016/A
 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias
 */

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

import javax.swing.*;

public class VentanaVotacion {
	/**
	 * Abre una ventana que permite votar a un usuario
	 * @param input El usuario que tiene que votar
	 */
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
        JButton botDiputados = new JButton("Diputados de la lista");
        JLabel labSenadores = new JLabel("Lista de Diputados a votar: ");
        JComboBox<Lista> senadores = new JComboBox<Lista>();
        for (Lista list : Main.listas) {
            if(Objects.nonNull(mesa.getVotosSenadores().get(list.getNroDeLista()))){
                senadores.addItem(list);
            }
        }
        JButton botSenadores = new JButton("Senadores de la lista");
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
        
        botDiputados.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Lista tmp = (Lista)diputados.getSelectedItem();
                if(!(tmp.getNroDeLista()==-1)) {
                	new VentanaInfoLista(tmp,Cargo.DIPUTADO);
                } else {
                	JOptionPane.showMessageDialog(null,"El voto en blanco no contiene candidatos");
                }
            }
        });
        
        botSenadores.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Lista tmp = (Lista)senadores.getSelectedItem();
                if(!(tmp.getNroDeLista()==-1)) {
                	new VentanaInfoLista(tmp,Cargo.SENADOR);
                } else {
                	JOptionPane.showMessageDialog(null,"El voto en blanco no contiene candidatos");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalStrut(20));
        panel.add((Ventana.crearPanelMedio(labNombApel,labDni)));
        panel.add(Box.createVerticalGlue());
        panel.add((Ventana.crearPanelMedio(labSenadores,senadores,botSenadores)));
        panel.add(Box.createVerticalGlue());
        panel.add(Box.createVerticalGlue());
        panel.add((Ventana.crearPanelMedio(labDiputados,diputados,botDiputados)));
        panel.add(Box.createVerticalGlue());

        cp.add(titulo,BorderLayout.NORTH);
        cp.add(panel, BorderLayout.CENTER);
        cp.add((Ventana.crearPanelMedio(cancelar, votar)), BorderLayout.SOUTH);
        v.setVisible(true);
    }

}
