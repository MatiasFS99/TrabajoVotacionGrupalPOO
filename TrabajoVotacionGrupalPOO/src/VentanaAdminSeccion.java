import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Nombre de clase:  VentanaAdminSeccion
 * Genera una ventana con la informacion de las secciones de un distrito especifico
 * @version: 22/09/2016/A
 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias
 */

public class VentanaAdminSeccion {
	/**
	 * Abre una ventana con el listado de secciones de un distrito especifico
	 * @param dist El distrito del que se quieren ver las secciones
	 */
    public VentanaAdminSeccion(Distrito dist){
        Ventana v = new Ventana("admin Seccion", 600, 600, false);
        Container cp = v.getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        JLabel titulo = new JLabel("Secciones electorales de '"+dist.getNombre()+"'");
        titulo.setFont(Main.ftitulo);
        JLabel labSecciones = new JLabel("Seleccione la seccion");
        JComboBox<Seccion> secciones = new JComboBox<Seccion>();
        for (Seccion secc : dist.getSecciones()){
            secciones.addItem(secc);
        }
        JLabel labDepCom = new JLabel();
        JTextField depCom = new JTextField(20);
        depCom.setEditable(false);
        JButton circuitos = new JButton("circuitos de la seccion");
        JButton volver = new JButton("Volver");
        if(((Seccion)secciones.getSelectedItem()).esProvincia()){
            labDepCom.setText("Departamento de:");
            depCom.setText(((Seccion)secciones.getSelectedItem()).getNombreProvincia());
        } else {
            labDepCom.setText("Comuna Nro: ");
            depCom.setText(Integer.toString(((Seccion)secciones.getSelectedItem()).getComunaBSAS()));
        }
        
        cp.add(titulo);
        cp.add(Ventana.crearPanelMedio(labSecciones, secciones));
        cp.add(Ventana.crearPanelMedio(labDepCom, depCom));
        cp.add(Ventana.crearPanelMedio(circuitos));
        cp.add(Ventana.crearPanelMedio(volver));
        v.setVisible(true);
        secciones.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(((Seccion)secciones.getSelectedItem()).esProvincia()){
                    labDepCom.setText("Departamento de:");
                    depCom.setText(((Seccion)secciones.getSelectedItem()).getNombreProvincia());
                } else {
                    labDepCom.setText("Comuna Nro: ");
                    depCom.setText(Integer.toString(((Seccion)secciones.getSelectedItem()).getComunaBSAS()));
                }
            }
        });
        circuitos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new VentanaAdminCircuito(((Seccion)secciones.getSelectedItem()));
            }
        });
        volver.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                v.dispose();
            }
        });
    }
}
