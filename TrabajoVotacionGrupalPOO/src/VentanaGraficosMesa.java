
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.Map;

/**
 * Nombre de clase:  VentanaGraficosMesa
 * Genera una ventana con graficos de una mesa en especifico
 * @version: 28/10/2021/A
 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias
 */

public class VentanaGraficosMesa {
	/**
	 * Abre una ventana con un selector para los graficos de los datos de una mesa
	 * @param mesa Mesa a seleccionar
	 */
    public VentanaGraficosMesa(MesaElectoral mesa){
        try{
            Ventana v = new Ventana("Resultados de mesa actuales", 600, 600, false);
            Container cp = v.getContentPane();
            cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
            JLabel titulo = new JLabel("Estadisticas de mesa Nro: "+mesa.toString());
            titulo.setFont(Main.ftitulo);
            if(vacio(mesa.getVotosDiputados())){
                throw new Exception();
            }
            JButton grafDip = new JButton("Grafica Diputados");
            JButton grafSen = new JButton("Grafica Senadores");
            JButton volver = new JButton("Volver");
            cp.add(titulo);
            cp.add(Ventana.crearPanelMedio(grafDip));
            cp.add(Ventana.crearPanelMedio(grafSen));
            cp.add(Ventana.crearPanelMedio(volver));
            v.setVisible(true);
            grafDip.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    Double[] datos = new Double[mesa.getVotosDiputados().size()];
                    Iterator<Integer> it = mesa.getVotosDiputados().keySet().iterator();
                    int i=0;
                    while(it.hasNext()){
                        datos[i] = mesa.getVotosDiputados().get(it.next())+0.0;
                        i++;
                    }
                    new VentanaGraficosDistrito(CamaraElectoral.nombresPartidos(mesa.getVotosDiputados()), datos);
                }
            });
            grafSen.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    Double[] datos = new Double[mesa.getVotosSenadores().size()];
                    Iterator<Integer> it = mesa.getVotosSenadores().keySet().iterator();
                    int i=0;
                    while(it.hasNext()){
                        datos[i] = mesa.getVotosSenadores().get(it.next())+0.0;
                        i++;
                    }
                    new VentanaGraficosDistrito(CamaraElectoral.nombresPartidos(mesa.getVotosSenadores()), datos);
                }
            });
            volver.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    v.dispose();
                }
            });
        }
        catch(Exception err){
            JOptionPane.showMessageDialog(null,"Aun no se realizo ningun voto en esta mesa por lo que no hay info que mostrar");
        }
    }
    /**
     * Chequea que los datos de un mapa de tipo<numeroLista,votos> no este vacio
     * @param votos mapa con los datos de lista-cantidad de votos
     * @return devuelve si en el total hay o no votos como un booleano
     */
    private static boolean vacio(Map<Integer,Integer> votos){
        Iterator<Integer> it = votos.keySet().iterator();
        int i = 0;
        Integer tmpartido = null;
        while(it.hasNext()){
            tmpartido = it.next();
            i += votos.get(tmpartido);
        }
        return i==0;
    }
}
