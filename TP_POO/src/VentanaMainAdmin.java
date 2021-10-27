import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class VentanaMainAdmin {
    public VentanaMainAdmin(){
        Ventana v = new Ventana("Admin distrito", 600, 600, false);
        Container cp = v.getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        JLabel titulo = new JLabel("Distritos electorales");
        titulo.setFont(Main.ftitulo);
        JLabel labDistritos = new JLabel("Seleccione el distrito");
        JComboBox<Distrito> distritos = new JComboBox<Distrito>();
        for (Distrito dist : Main.distritos){
            distritos.addItem(dist);
        }
        JLabel labDip = new JLabel("Puestos libres diputados:");
        JTextField puestosDipLibres = new JTextField(5);
        puestosDipLibres.setEditable(false);
        JLabel labSen = new JLabel("Puestos libres senadores:");
        JTextField puestosSenLibres = new JTextField(5);
        puestosSenLibres.setEditable(false);
        JLabel labTotVot = new JLabel("Total de Votantes:");
        JTextField totVotantes = new JTextField(5);
        totVotantes.setEditable(false);
        JLabel labTotBlanco = new JLabel("Total de votos en blanco:");
        JTextField totVotosBlanco = new JTextField(5);
        totVotosBlanco.setEditable(false);
        JButton masInfo = new JButton("Mas Informacion Sobre el Distrito");
        JButton secciones = new JButton("Secciones del distrito");
        JButton volver = new JButton("Volver");
        puestosDipLibres.setText(Integer.toString(((Distrito)distritos.getSelectedItem()).getCantPLibresDip()));
        puestosSenLibres.setText(Integer.toString(((Distrito)distritos.getSelectedItem()).getCantPLibresSen()));
        totVotantes.setText(Integer.toString(((Distrito)distritos.getSelectedItem()).totalVotantes()));
        totVotosBlanco.setText(Integer.toString(((Distrito)distritos.getSelectedItem()).totalVotosEnBlanco()));
        cp.add(titulo);
        cp.add(Ventana.crearPanelMedio(labDistritos, distritos));
        cp.add(Ventana.crearPanelMedio(labDip, puestosDipLibres));
        cp.add(Ventana.crearPanelMedio(labSen, puestosSenLibres));
        cp.add(Ventana.crearPanelMedio(labTotVot, totVotantes));
        cp.add(Ventana.crearPanelMedio(labTotBlanco, totVotosBlanco));
        cp.add(Ventana.crearPanelMedio(masInfo));
        cp.add(Ventana.crearPanelMedio(secciones));
        cp.add(Ventana.crearPanelMedio(volver));
        v.setVisible(true);
        volver.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                v.dispose();
            }
        });
        masInfo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new VentanaInfoDistritoAdmin((Distrito)distritos.getSelectedItem());
            }
        });
        distritos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                puestosDipLibres.setText(Integer.toString(((Distrito)distritos.getSelectedItem()).getCantPLibresDip()));
                puestosSenLibres.setText(Integer.toString(((Distrito)distritos.getSelectedItem()).getCantPLibresSen()));
                totVotantes.setText(Integer.toString(((Distrito)distritos.getSelectedItem()).totalVotantes()));
                totVotosBlanco.setText(Integer.toString(((Distrito)distritos.getSelectedItem()).totalVotosEnBlanco()));
            }
        });
        secciones.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new VentanaAdminSeccion((Distrito)(distritos.getSelectedItem()));
            }
        });
    }
}
