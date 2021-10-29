/**
 * Nombre de clase:  VentanaMainAdmin
 * Genera una ventana con opcion para ver el estado actual de las elecciones o finalizarlas
 * @version: 22/09/2016/A
 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class VentanaMainAdmin {
	/**
	 * Abre una ventana con las opciones para ver el estado de las elecciones o finalizarlas
	 */
    public VentanaMainAdmin(){
        Ventana v = new Ventana("Administrador", 600, 600, false);
        Container cp = v.getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        JLabel titulo = new JLabel("Administrador de Sistema");
        titulo.setFont(Main.ftitulo);
        JButton verDistritos = new JButton("Ver Distritos");
        JButton volver = new JButton("Cerrar");
        JCheckBox checkTerminar = new JCheckBox("Seguro Terminar elecciones");
        JButton terminar = new JButton("Terminar Elecciones");
        terminar.setEnabled(false);
        cp.add(titulo);
        cp.add(Ventana.crearPanelMedio(verDistritos));
        if(Main.Abierto){
            cp.add(Ventana.crearPanelMedio(checkTerminar, terminar));
        }

        cp.add(Ventana.crearPanelMedio(volver));
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

        verDistritos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new VentanaDistritoAdmin();
            }
        });

        volver.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                v.dispose();
            }
        });
    }
}
