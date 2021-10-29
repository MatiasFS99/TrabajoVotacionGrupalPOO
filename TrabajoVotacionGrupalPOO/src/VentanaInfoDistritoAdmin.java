
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Nombre de clase:  VentanaInfoDistritoAdmin
 * Genera una ventana con la informacion de las estadisticas de un distrito especifico
 * @version: 28/10/2021/A
 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias
 */

public class VentanaInfoDistritoAdmin {
	/**
	 * Abre una ventana con la informacion de un distrito especificado
	 * @param distrito El distrito del que se quieren obtener los datos
	 */
    public VentanaInfoDistritoAdmin(Distrito distrito){
        try{
            Ventana v = new Ventana("Informe Distrito", 600, 600, false);
            Container cp = v.getContentPane();
            cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
            JLabel titulo = new JLabel("Informacion de Distrito: "+distrito.getNombre());
            titulo.setFont(Main.ftitulo);
            JButton grafSenadores = new JButton("Grafica Senadores");
            JButton grafDiputados = new JButton("Grafica Diputados");
            JButton grafPartidos = new JButton("Grafica de Partidos");
            JButton grafPresentismo = new JButton("Grafica Votos Faltantes");
            if(distrito.totalVotosEnBlancoDiputados()==0&distrito.totalPorcentajeDeVotacion()==0&
            (distrito.totalVotantes()-distrito.totalVotosEnBlancoDiputados())==0&distrito.totalVotosEnBlancoSenadores()==0&
            (distrito.totalVotantes()-distrito.totalVotosEnBlancoSenadores())==0){
                throw new Exception();
            }
            JButton volver = new JButton("Volver");
            cp.add(titulo);
            cp.add(Ventana.crearPanelMedio(grafSenadores));
            cp.add(Ventana.crearPanelMedio(grafDiputados));
            cp.add(Ventana.crearPanelMedio(grafPartidos));
            cp.add(Ventana.crearPanelMedio(grafPresentismo));
            cp.add(Ventana.crearPanelMedio(volver));
            v.setVisible(true);
            grafDiputados.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    new VentanaGraficosDistrito(Cargo.DIPUTADO, distrito.totalVotosDiputados());
                }
            });

            grafSenadores.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    new VentanaGraficosDistrito(Cargo.SENADOR, distrito.totalVotosSenadores());
                }
            });

            grafPartidos.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    new VentanaGraficosDistrito(distrito.totalVotosPartidoAlianza());
                }
            });

            grafPresentismo.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    new VentanaGraficosDistrito(new String[]{"Voto","No Voto"},new Double[]{(100-distrito.procentajeAusencia()),distrito.procentajeAusencia()});
                }
            });

            volver.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    v.dispose();
                }
            });
        }
        catch(Exception err){
            JOptionPane.showMessageDialog(null,"Aun no se realizo ningun voto en el distrito por lo que no hay info que mostrar");
        }
    }
}
