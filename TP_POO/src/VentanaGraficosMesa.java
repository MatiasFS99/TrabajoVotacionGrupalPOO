import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.Map;

public class VentanaGraficosMesa {
    public VentanaGraficosMesa(MesaElectoral mesa){
        try{
            Ventana v = new Ventana("Resultados de mesa actuales", 600, 600, false);
            Container cp = v.getContentPane();
            cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
            JLabel titulo = new JLabel("Estadisticas de mesa Nro: "+mesa.toString());
            titulo.setFont(Main.ftitulo);
            JLabel porcentajeResultados = new JLabel("Los resultados fueron");
            if(vacio(mesa.getVotos())){
                throw new Exception();
            }
            GraficoTorta graficoPartidos = new GraficoTorta(mesa.getVotos());
            JButton volver = new JButton("Volver");
            volver.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    v.dispose();
                }
            });
            cp.add(titulo);
            cp.add(porcentajeResultados);
            cp.add(graficoPartidos);
            cp.add(Ventana.crearPanelMedio(volver));
            v.setVisible(true);
        }
        catch(Exception err){
            JOptionPane.showMessageDialog(null,"Aun no se realizo ningun voto en esta mesa por lo que no hay info que mostrar");
        }
    }
    private static boolean vacio(Map<PartidoPoliticoAlianza,Integer> votos){
        Iterator<PartidoPoliticoAlianza> it = votos.keySet().iterator();
        int i = 0;
        PartidoPoliticoAlianza tmpartido = null;
        while(it.hasNext()){
            tmpartido = it.next();
            i += votos.get(tmpartido);
        }
        return i==0;
    }
}
