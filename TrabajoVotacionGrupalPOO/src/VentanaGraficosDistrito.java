import java.util.Map;

/**
 * Nombre de clase:  VentanaAdminSeccion
 * Genera una ventana con la informacion de las secciones de un distrito especifico
 * @version: 28/10/2021/A
 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias
 */

public class VentanaGraficosDistrito {
	/**
	 * Abre una ventana mostrando un grafico de torta con los nombres y datos especificados
	 * @param nombres ingresando los nombres en un array de strings ordenado
	 * @param datos Ingresa los datos de cada nombre en el mismo orden que el array anterior
	 */
    public VentanaGraficosDistrito(String[] nombres, Double[] datos){
        Ventana v = new Ventana("Graficos de Presentismo", 700, 800, false);
        GraficoTorta grafico = new GraficoTorta(nombres, datos);
        v.getContentPane().add(grafico);
        v.setVisible(true);
    }
    /**
     * Abre una ventana mostrando un grafico de torta con los nombres y datos especificados
     * @param tipo El tipo de cargo del que se esta mostrando el cargo(diputado-senador)
     * @param datos un mapa del orden (partido, cantidad de votos) con los datos a graficar
     */
    public VentanaGraficosDistrito(Cargo tipo, Map<PartidoPoliticoAlianza, Double> datos){
        Ventana v = new Ventana("Graficos de "+tipo.toString(), 700, 700, false);
        GraficoTorta grafico = new GraficoTorta(datos);
        v.getContentPane().add(grafico);
        v.setVisible(true);
    }

    /**
     * Abre una ventana mostrando un grafico de torta con la lista de datos especificado
     * @param datos un mapa del orden (partido, cantidad de votos) con los datos a graficar
     */
    public VentanaGraficosDistrito(Map<PartidoPoliticoAlianza, Double> datos){
        Ventana v = new Ventana("Graficos de Alianza/Partido", 700, 700, false);
        GraficoTorta grafico = new GraficoTorta(datos);
        v.getContentPane().add(grafico);
        v.setVisible(true);
    }
}
