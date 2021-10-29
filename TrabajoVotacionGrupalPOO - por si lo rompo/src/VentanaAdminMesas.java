/**
 * Nombre de clase:  VentanaAdminMesas
 * Genera una ventana con la informacion de una mesa en especifico y te deja ver graficos de las estadisticas
 * @version: 22/09/2016/A
 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class VentanaAdminMesas {
	/**
	 * Abre una ventana con las mesas de un circuito especifico
	 * @param circ El circuito del que se quieren ver las mesas
	 */
    public VentanaAdminMesas(Circuito circ){
        Ventana v = new Ventana("Admin Circuito", 600, 600, false);
        Container cp = v.getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        JLabel titulo = new JLabel("Mesas Electorales de '"+circ.getNumero()+"'");
        titulo.setFont(Main.ftitulo);
        JLabel labMesas = new JLabel("Seleccione La Mesa Electoral");
        JComboBox<MesaElectoral> mesas = new JComboBox<MesaElectoral>();
        for (MesaElectoral mesa : circ.getMesas()){
            mesas.addItem(mesa);
        }
        JLabel labUbicacion = new JLabel("Ubicacion:");
        JTextField Ubicacion = new JTextField(30);
        Ubicacion.setEditable(false);
        JLabel labPresidente = new JLabel("Presidente de mesa: ");
        JTextField presidente = new JTextField(30);
        presidente.setEditable(false);
        JLabel labVicePresidente = new JLabel("Vicepresidente de mesa: ");
        JTextField vicePresidente = new JTextField(30);
        vicePresidente.setEditable(false);
        JLabel labEstadoVotos = new JLabel("Votado/Falta Votar");
        JTextField estadoVotos = new JTextField(8);
        estadoVotos.setEditable(false);
        JButton estadisticas = new JButton("Grafico votacion");
        JButton volver = new JButton("Volver");

        cp.add(Ventana.crearPanelMedio(labMesas,mesas));
        cp.add(Ventana.crearPanelMedio(labUbicacion,Ubicacion));
        cp.add(Ventana.crearPanelMedio(labPresidente, presidente));
        cp.add(Ventana.crearPanelMedio(labVicePresidente, vicePresidente));
        cp.add(Ventana.crearPanelMedio(labEstadoVotos, estadoVotos));
        cp.add(Ventana.crearPanelMedio(estadisticas));
        cp.add(Ventana.crearPanelMedio(volver));
        v.setVisible(true);
        Ubicacion.setText(((MesaElectoral)mesas.getSelectedItem()).getPresidente().getDomicilio().getDepartamento());
        presidente.setText(((MesaElectoral)mesas.getSelectedItem()).getPresidente().toString());
        vicePresidente.setText(((MesaElectoral)mesas.getSelectedItem()).getSuplenteDePresidente().toString());
        estadoVotos.setText((((MesaElectoral)mesas.getSelectedItem()).getElectores().size()-((MesaElectoral)mesas.getSelectedItem()).getVotosFaltantes())+"/"+((MesaElectoral)mesas.getSelectedItem()).getVotosFaltantes());

        mesas.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Ubicacion.setText(((MesaElectoral)mesas.getSelectedItem()).getPresidente().getDomicilio().getDepartamento());
                presidente.setText(((MesaElectoral)mesas.getSelectedItem()).getPresidente().toString());
                vicePresidente.setText(((MesaElectoral)mesas.getSelectedItem()).getSuplenteDePresidente().toString());
                estadoVotos.setText((((MesaElectoral)mesas.getSelectedItem()).getElectores().size()-((MesaElectoral)mesas.getSelectedItem()).getVotosFaltantes())+"/"+((MesaElectoral)mesas.getSelectedItem()).getVotosFaltantes());
            }
        });
        
        estadisticas.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new VentanaGraficosMesa((MesaElectoral)mesas.getSelectedItem());
            }
        });

        volver.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                v.dispose();
            }
        });
    }
}
