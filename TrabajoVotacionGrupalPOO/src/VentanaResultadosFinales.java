import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class VentanaResultadosFinales {
    public VentanaResultadosFinales(){
        Ventana v = new Ventana("Resultados finales", 700, 700, true);
        Container cp = v.getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        JLabel labAsistencia = new JLabel("El total de asistencia fue: ");
        JTextField asistencia = new JTextField(6);
        asistencia.setText(asistencia());
        asistencia.setEditable(false);
        
        JLabel labPartidos = new JLabel("Partidos que pasaron");
        JList<String> partidos = new JList<String>(pasan());

        JLabel labDistrito = new JLabel("Ver Distrito");
        JComboBox<Distrito> distrito = new JComboBox<Distrito>();
        for (Distrito dist : Main.distritos) {
            distrito.addItem(dist);
        }
        JLabel labDips = new JLabel("Lista que gano diputados: ");
        JTextField dips = new JTextField(30);
        dips.setEditable(false);
        JLabel labSen = new JLabel("Lista que gano Senadores: ");
        JTextField sen = new JTextField(30);
        sen.setEditable(false);

        dips.setText(((Distrito)distrito.getSelectedItem()).ganadorDiputados().getNombre());
        sen.setText(((Distrito)distrito.getSelectedItem()).ganadorSenadores().getNombre());

        cp.add(Ventana.crearPanelMedio(labAsistencia, asistencia));
        cp.add(labPartidos);
        cp.add(Ventana.crearPanelMedio(partidos));
        cp.add(Ventana.crearPanelMedio(labDistrito, distrito));
        cp.add(Ventana.crearPanelMedio(labDips,dips));
        cp.add(Ventana.crearPanelMedio(labSen,sen));

        distrito.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dips.setText(((Distrito)distrito.getSelectedItem()).ganadorDiputados().getNombre());
                sen.setText(((Distrito)distrito.getSelectedItem()).ganadorSenadores().getNombre());
            }
        });
        v.setVisible(true);
    }

    private static String[] pasan(){
        List<String> salida = new ArrayList<String>();
        int totalVotos = 0;
        PartidoPoliticoAlianza tmp;
        Map<PartidoPoliticoAlianza,Double> lista = new HashMap<PartidoPoliticoAlianza,Double>();
        for (Distrito dist : Main.distritos) {
            totalVotos += dist.totalVotantes();
            Iterator<PartidoPoliticoAlianza> it = dist.totalVotosPartidoAlianza().keySet().iterator();
            while(it.hasNext()){
                tmp = it.next();
                if(Objects.nonNull(lista.get(tmp))){
                    lista.replace(tmp,(lista.get(tmp) + dist.totalVotosPartidoAlianza().get(tmp)));
                } else {
                    lista.put(tmp, dist.totalVotosPartidoAlianza().get(tmp));
                }
            }
        }
        Iterator<PartidoPoliticoAlianza> it = lista.keySet().iterator();
        while(it.hasNext()){
            tmp = it.next();
            if(lista.get(tmp)>((totalVotos/100)*1.5) & !tmp.getNombre().equals("Blanco")){
                salida.add(tmp.getNombre());
            }
        }
        String[] arrSalida = new String[lista.size()];
        int i = 0;
        for (String nombre : salida) {
            arrSalida[i] = nombre;
            i++;
        }
        return arrSalida;
    }

    private static String asistencia(){
        Double tot = 0.0;
        for (Distrito dist : Main.distritos) {
            tot += dist.totalPorcentajeDeVotacion();
        }
        tot = tot/Main.distritos.size();
        return tot+"%";
    }
}
