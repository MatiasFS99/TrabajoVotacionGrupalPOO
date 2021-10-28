import java.util.Map;

public class VentanaGraficosDistrito {
    public VentanaGraficosDistrito(String[] nombres, Double[] datos){
        Ventana v = new Ventana("Graficos de Presentismo", 700, 800, false);
        GraficoTorta grafico = new GraficoTorta(nombres, datos);
        v.getContentPane().add(grafico);
        v.setVisible(true);
    }
    public VentanaGraficosDistrito(Cargo tipo, Map<PartidoPoliticoAlianza, Double> datos){
        Ventana v = new Ventana("Graficos de "+tipo.toString(), 700, 700, false);
        GraficoTorta grafico = new GraficoTorta(datos);
        v.getContentPane().add(grafico);
        v.setVisible(true);
    }

    public VentanaGraficosDistrito(Map<PartidoPoliticoAlianza, Double> datos){
        Ventana v = new Ventana("Graficos de Alianza/Partido", 700, 700, false);
        GraficoTorta grafico = new GraficoTorta(datos);
        v.getContentPane().add(grafico);
        v.setVisible(true);
    }
}
