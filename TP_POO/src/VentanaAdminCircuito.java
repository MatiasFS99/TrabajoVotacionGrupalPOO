import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class VentanaAdminCircuito {
    public VentanaAdminCircuito(Seccion sec){
        Ventana v = new Ventana("Admin Circuito", 600, 600, false);
        Container cp = v.getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        JLabel titulo = new JLabel("Circuitos Electorales de '"+sec.getNombrePartido()+"'");
        titulo.setFont(Main.ftitulo);
        JLabel labCircuitos = new JLabel("Seleccione el circulo");
        JComboBox<Circuito> circuitos = new JComboBox<Circuito>();
        for (Circuito circ : sec.getCircuitos()) {
            circuitos.addItem(circ);
        }
        JButton mesasButton = new JButton("Ver Mesas");
        JButton volver = new JButton("Volver");
        
        cp.add(titulo);
        cp.add(Ventana.crearPanelMedio(labCircuitos, circuitos));
        cp.add(Ventana.crearPanelMedio(volver,mesasButton));
        v.setVisible(true);

        mesasButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new VentanaAdminMesas((((Circuito)circuitos.getSelectedItem())));
            }
        });

        volver.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                v.dispose();
            }
        });
    }
}
