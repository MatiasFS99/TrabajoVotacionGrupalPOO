/**
 * Nombre de clase:  VentanaInfoLista
 * Genera una ventana con la informacion de los candidatos de un cargo especifico de una lista determinada
 * @version: 22/09/2016/A
 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class VentanaInfoLista {
	/**
	 * Abre una ventana con la lista de candidatos por cargo de una lista
	 * @param list Lista de la cual se desean mostrar candidatos
	 * @param cargo El cargo que se desean ver los candidatos
	 */
	public VentanaInfoLista(Lista list, Cargo cargo) {
		Ventana v = new Ventana("Informacion de la lista", 600, 600, false);
        Container cp = v.getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        JLabel titulo = new JLabel("Informacion de la lista");
        titulo.setFont(Main.ftitulo);
        
        JLabel labLista = new JLabel("");
        if(cargo.equals(Cargo.DIPUTADO)) {
        	labLista.setText("Diputados de la lista "+list.getNombre());
        } else {
        	labLista.setText("Senadores de la lista "+list.getNombre());
        }
        JList<Candidato> lista = new JList<Candidato>(filtro(list,cargo));
        JButton volver = new JButton("Volver");
        cp.add(Ventana.crearPanelMedio(titulo));
        cp.add(Ventana.crearPanelMedio(labLista));
        cp.add(Ventana.crearPanelMedio(lista));
        cp.add(Ventana.crearPanelMedio(volver));
        v.setVisible(true);
        volver.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                v.dispose();
            }
        });
	}
	/**
	 * Filtra los candidatos de otros cargos de una lista
	 * @param list Lista que se desea filtrar
	 * @param cargo Cargo del que se desean mantener los cargos
	 * @return Devuelve un array con los candidatos
	 */
	private static Candidato[] filtro(Lista list, Cargo cargo){
		List<Candidato> salida = new ArrayList<Candidato>();
		for(Candidato cand : list.getCandidatos()) {
			if(cargo.equals(cand.getCargo())) {
				salida.add(cand);
			}
		}
		int i = 0;
		Candidato[] arrSalida = new Candidato[salida.size()];
		for(Candidato cand : salida) {
			arrSalida[i] = cand;
			i++;
		}
		return arrSalida;
	}
}
