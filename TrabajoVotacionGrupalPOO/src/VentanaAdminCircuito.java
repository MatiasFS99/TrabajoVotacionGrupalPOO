import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Nombre de clase:  VentanaAdminCircuito
 * Genera una ventana con la informacion de los circuitos de una Seccion especificada
 * @version: 28/10/2021/A
 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias
 */

public class VentanaAdminCircuito {
	/**
	 * Abre una ventana con los circuitos de una seccion especificada
	 * @param sec seccion de la que se quieren ver los circuitos
	 */
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
