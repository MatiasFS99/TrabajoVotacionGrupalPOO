import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class VentanaInfoDistritoAdmin {
    public VentanaInfoDistritoAdmin(Distrito distrito){
        try{
            Ventana v = new Ventana("Informe Distrito", 600, 600, false);
            Container cp = v.getContentPane();
            cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
            JLabel titulo = new JLabel("Informacion de Distrito: "+distrito.getNombre());
            titulo.setFont(Main.ftitulo);
            JLabel porcentajeResultados = new JLabel("Los resultados fueron");
            GraficoTorta graficoPartidos = new GraficoTorta(distrito.totalGeneralDeVotacionListaVotoBlanco());
            if(distrito.totalVotosEnBlanco()==0&distrito.totalPorcentajeDeVotacion()==0&(distrito.totalVotantes()-distrito.totalVotosEnBlanco())==0){
                throw new Exception();
            }
            JLabel porcentajeBlancoAusencia = new JLabel("Porcentaje voto/ausencia/blanco");
            GraficoTorta graficoBlancoAusencia = new GraficoTorta(new String[]{"Blanco","Ausencia","Otro"}, new int[]{distrito.totalVotosEnBlanco(),distrito.totalPorcentajeDeVotacion(),(distrito.totalVotantes()-distrito.totalVotosEnBlanco())});
            JButton volver = new JButton("Volver");
            volver.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    v.dispose();
                }
            });
            cp.add(titulo);
            cp.add(porcentajeResultados);
            cp.add(graficoPartidos);
            cp.add(porcentajeBlancoAusencia);
            cp.add(graficoBlancoAusencia);
            cp.add(Ventana.crearPanelMedio(volver));
            v.setVisible(true);
        }
        catch(Exception err){
            JOptionPane.showMessageDialog(null,"Aun no se realizo ningun voto en el distrito por lo que no hay info que mostrar");
        }
    }
}
