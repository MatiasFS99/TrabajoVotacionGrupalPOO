import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class VentanaDistritoAdmin {
    public VentanaDistritoAdmin(){
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
        JCheckBox checkTerminar = new JCheckBox("Seguro Terminar elecciones");
        JButton terminar = new JButton("Terminar Elecciones");
        terminar.setEnabled(false);
        JLabel labDip = new JLabel("Puestos libres diputados:");
        JTextField puestosDipLibres = new JTextField(5);
        puestosDipLibres.setEditable(false);
        JLabel labSen = new JLabel("Puestos libres senadores:");
        JTextField puestosSenLibres = new JTextField(5);
        puestosSenLibres.setEditable(false);
        JLabel labTotVot = new JLabel("Total de Votantes:");
        JTextField totVotantes = new JTextField(5);
        totVotantes.setEditable(false);
        JLabel labTotBlancoSen = new JLabel("Total de votos en blanco:");
        JTextField totVotosBlancoSen = new JTextField(5);
        totVotosBlancoSen.setEditable(false);
        JLabel labTotBlancoDip = new JLabel("Total de votos en blanco:");
        JTextField totVotosBlancoDip = new JTextField(5);
        totVotosBlancoDip.setEditable(false);
        JButton masInfo = new JButton("Mas Informacion Sobre el Distrito");
        JButton secciones = new JButton("Secciones del distrito");
        JButton volver = new JButton("Volver");
        puestosDipLibres.setText(Integer.toString(((Distrito)distritos.getSelectedItem()).getCantPLibresDip()));
        puestosSenLibres.setText(Integer.toString(((Distrito)distritos.getSelectedItem()).getCantPLibresSen()));
        totVotantes.setText(Integer.toString(((Distrito)distritos.getSelectedItem()).totalVotantes()));
        totVotosBlancoSen.setText(Integer.toString(((Distrito)distritos.getSelectedItem()).totalVotosEnBlancoSenadores()));
        totVotosBlancoDip.setText(Integer.toString(((Distrito)distritos.getSelectedItem()).totalVotosEnBlancoDiputados()));

        cp.add(titulo);
        cp.add(Ventana.crearPanelMedio(labDistritos, distritos));
        cp.add(Ventana.crearPanelMedio(labDip, puestosDipLibres));
        cp.add(Ventana.crearPanelMedio(labSen, puestosSenLibres));
        cp.add(Ventana.crearPanelMedio(labTotVot, totVotantes));
        cp.add(Ventana.crearPanelMedio(labTotBlancoSen, totVotosBlancoSen));
        cp.add(Ventana.crearPanelMedio(labTotBlancoDip, totVotosBlancoDip));
        cp.add(Ventana.crearPanelMedio(masInfo));
        cp.add(Ventana.crearPanelMedio(secciones));
        cp.add(Ventana.crearPanelMedio(volver));
        if(Main.Abierto){
            cp.add(Ventana.crearPanelMedio(checkTerminar, terminar));
        }
        v.setVisible(true);

        checkTerminar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(checkTerminar.isSelected()){
                    terminar.setEnabled(true);
                } else {
                    terminar.setEnabled(false);
                }
            }
        });
        terminar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(Main.Abierto){
                    new VentanaTerminarAdmin();
                } else {
                    JOptionPane.showMessageDialog(null, "Elecciones ya terminadas", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    terminar.setEnabled(false);
                    checkTerminar.setEnabled(false);
                }
            }
        });
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
                totVotosBlancoSen.setText(Integer.toString(((Distrito)distritos.getSelectedItem()).totalVotosEnBlancoSenadores()));
                totVotosBlancoDip.setText(Integer.toString(((Distrito)distritos.getSelectedItem()).totalVotosEnBlancoDiputados()));
            }
        });
        secciones.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new VentanaAdminSeccion((Distrito)(distritos.getSelectedItem()));
            }
        });
    }
}