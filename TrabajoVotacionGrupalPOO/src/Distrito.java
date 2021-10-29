import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * Nombre de clase: Distrito
 *
 * Esta define los distritos la cantidad de votantes, ausencias votos en blanco
 * de senadores y diputados, total porcentaje de votacion y por partidos, ganadores
 * de diputados y senadores
 *
 *
 * @version: 28/10/2021/A
 *
 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias
 *
 */

public class Distrito {

    private String nombre;
    private int CantPLibresDip;
    private int CantPLibresSen;
    private List<Seccion> secciones;

    /**
     *
     * Constructor
     *
     * @param nombre El parámetro nombre define el nombre que va a tener el
     * Distrito
     *
     * @param CantPLibresDip El parámetro CantPLibresDip define la cantidad de
     * puestos libres de diputados disponibles en el Distrito
     *
     * @param CantPLibresSen El parámetro CantPLibresSen define la cantidad de
     * puestos libres de senadores disponibles en el Distrito
     *
     * @param seccciones El parámetro seccciones define la cantidad de secciones
     * que va a tener el Distrito
     *
     */
    public Distrito(String nombre, int CantPLibresDip, int CantPLibresSen, List<Seccion> seccciones) {
        this.nombre = nombre;
        this.CantPLibresDip = CantPLibresDip;
        this.CantPLibresSen = CantPLibresSen;
        this.secciones = seccciones;
    }

    /**
     *
     * Método que devuelve el nombre
     *
     * @return el nombre
     *
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     *
     * Método que Define el Nombre de distrito
     *
     * @param nombre El parámetro nombre define el nombre que va a tener el
     * distrito
     *
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * Método que devuelve la cantidad de apuestos libres de diputados
     *
     * @return cantidad puestos libres diputados
     *
     */
    public int getCantPLibresDip() {
        return this.CantPLibresDip;
    }

    /**
     *
     * Método que Define la cantidad de apuestos libres de diputados
     *
     * @param nombre El parámetro nombre define la cantidad puestos libres
     * diputados que va a tener el distrito
     *
     */
    public void setCantPLibresDip(int CantPLibresDip) {
        this.CantPLibresDip = CantPLibresDip;
    }

    /**
     *
     * Método que devuelve la cantidad de apuestos libres de senadores
     *
     * @return cantidad puestos libres senadores
     *
     */
    public int getCantPLibresSen() {
        return this.CantPLibresSen;
    }

    /**
     *
     * Método que Define la cantidad de apuestos libres de senadores
     *
     * @param nombre El parámetro nombre define la cantidad puestos libres
     * senadores que va a tener el distrito
     *
     */
    public void setCantPLibresSen(int CantPLibresSen) {
        this.CantPLibresSen = CantPLibresSen;
    }

    /**
     *
     * Método que devuelve las secciones contenidas en el distrito
     *
     * @return las secciones contenidas en el distrito
     *
     */
    public List<Seccion> getSecciones() {
        return this.secciones;
    }

    /**
     *
     * Método que crea una nueva lista de secciones
     *
     * @param secciones El parámetro secciones define la lista de secciones a
     * asignar
     *
     */
    public void setSecciones(List<Seccion> secciones) {
        this.secciones = secciones;
    }

    /**
     *
     * funcion que reliza conteo de votantes
     *
     *
     * @return la cantidad total de votantes
     */
    public int totalVotantes() {
        int total = 0;
        for (Seccion seccion : this.secciones) {
            for (Circuito circuito : seccion.getCircuitos()) {
                for (MesaElectoral mesa : circuito.getMesas()) {
                    total += mesa.conteoVotantes();
                }
            }
        }
        return total;
    }

    /**
     *
     * funcion que reliza el porcentaje de los electores que no votaron
     *
     *
     * @return el porcentaje de votantes que no votaron
     */
    public Double procentajeAusencia() {
        int i = 0;
        Double porcentaje = 0.0;
        for (Seccion seccion : secciones) {
            for (Circuito circ : seccion.getCircuitos()) {
                for (MesaElectoral mesa : circ.getMesas()) {
                    porcentaje += mesa.getPorcentajeAusencia();
                    i++;
                }
            }
        }
        return porcentaje / i;
    }

    /**
     *
     * funcion que reliza el conteo de votos en blanco para diputados
     *
     *
     * @return total votos en blanco diputados
     */
    public int totalVotosEnBlancoDiputados() {
        int total = 0;
        for (Seccion seccion : this.secciones) {
            for (Circuito circuito : seccion.getCircuitos()) {
                for (MesaElectoral mesa : circuito.getMesas()) {
                    total += mesa.conteoVotosBlancoDiputados();
                }
            }
        }
        return total;
    }

    /**
     *
     * funcion que reliza el conteo de votos en blanco para senadores
     *
     *
     * @return total votos en blanco senadores
     */
    public int totalVotosEnBlancoSenadores() {
        int total = 0;
        for (Seccion seccion : this.secciones) {
            for (Circuito circuito : seccion.getCircuitos()) {
                for (MesaElectoral mesa : circuito.getMesas()) {
                    total += mesa.conteoVotosBlancoSenadores();
                }
            }
        }
        return total;
    }

    /**
     *
     * funcion que reliza el porcentaje de los electores que votaron
     *
     *
     * @return el total de electores que votaron
     */
    public int totalPorcentajeDeVotacion() {
        int votos = 0;
        int total = 0;

        for (Seccion seccion : this.secciones) {
            for (Circuito circuito : seccion.getCircuitos()) {
                for (MesaElectoral mesa : circuito.getMesas()) {
                    total += mesa.getTotalVotantes();
                    votos += mesa.getVotosFaltantes();
                }
            }
        }
        return (total - votos);
    }

    /**
     *
     * funcion que devuelve un mapa con los votos por partido y cantidad de
     * votos
     *
     *
     * @return mapa con los votos por partido y cantidad de votos
     */
    public Map<PartidoPoliticoAlianza, Double> totalVotosPartidoAlianza() {
        int tmp = -10;
        Lista tmpList = null;
        Map<PartidoPoliticoAlianza, Double> listado = new HashMap<PartidoPoliticoAlianza, Double>();
        for (Seccion seccion : secciones) {
            for (Circuito circuito : seccion.getCircuitos()) {
                for (MesaElectoral mesa : circuito.getMesas()) {
                    Iterator<Integer> it = mesa.getVotosDiputados().keySet().iterator();
                    while (it.hasNext()) {
                        tmp = it.next();
                        tmpList = CamaraElectoral.buscarLista(tmp);
                        if (Objects.nonNull(listado.get(tmpList.getPartido()))) {
                            listado.replace(tmpList.getPartido(), (listado.get(tmpList.getPartido()) + (mesa.getVotosDiputados().get(tmp) / 2)));
                        } else {
                            listado.put(tmpList.getPartido(), Double.valueOf(mesa.getVotosDiputados().get(tmp) / 2));
                        }
                    }

                    it = mesa.getVotosSenadores().keySet().iterator();
                    while (it.hasNext()) {
                        tmp = it.next();
                        tmpList = CamaraElectoral.buscarLista(tmp);
                        if (Objects.nonNull(listado.get(tmpList.getPartido()))) {
                            listado.replace(tmpList.getPartido(), (listado.get(tmpList.getPartido()) + (mesa.getVotosSenadores().get(tmp) / 2)));
                        } else {
                            listado.put(tmpList.getPartido(), Double.valueOf(mesa.getVotosSenadores().get(tmp) / 2));
                        }
                    }
                }
            }
        }
        return listado;
    }

    /**
     *
     * funcion que devuelve la lista ganadora de diputados
     *
     *
     * @return lista ganadora de diputados
     */
    public Lista ganadorDiputados() {
        int tmp = -10;
        int max = -1;
        Lista tmpList = null;
        Map<Integer, Integer> resultados = new HashMap<Integer, Integer>();
        for (Seccion seccion : secciones) {
            for (Circuito circuito : seccion.getCircuitos()) {
                for (MesaElectoral mesa : circuito.getMesas()) {
                    Iterator<Integer> it = mesa.getVotosDiputados().keySet().iterator();
                    it = mesa.getVotosDiputados().keySet().iterator();
                    while (it.hasNext()) {
                        tmp = it.next();
                        if (Objects.nonNull(resultados.get(tmp))) {
                            resultados.replace(tmp, (resultados.get(tmp) + mesa.getVotosDiputados().get(tmp)));
                        } else {
                            resultados.put(tmp, mesa.getVotosDiputados().get(tmp));
                        }
                    }
                }
            }
        }
        Iterator<Integer> it = resultados.keySet().iterator();
        while (it.hasNext()) {
            tmp = it.next();
            if (!(tmp == -1)) {
                if (resultados.get(tmp) > max) {
                    max = resultados.get(tmp);
                    tmpList = CamaraElectoral.buscarLista(tmp);
                }
            }
        }
        return tmpList;
    }

    /**
     *
     * funcion que devuelve la lista ganadora de senadores
     *
     *
     * @return lista ganadora de senadores
     */
    public Lista ganadorSenadores() {
        int tmp = -10;
        int max = -1;
        Lista tmpList = null;
        Map<Integer, Integer> resultados = new HashMap<Integer, Integer>();
        for (Seccion seccion : secciones) {
            for (Circuito circuito : seccion.getCircuitos()) {
                for (MesaElectoral mesa : circuito.getMesas()) {
                    Iterator<Integer> it = mesa.getVotosSenadores().keySet().iterator();
                    it = mesa.getVotosSenadores().keySet().iterator();
                    while (it.hasNext()) {
                        tmp = it.next();
                        if (Objects.nonNull(resultados.get(tmp))) {
                            resultados.replace(tmp, (resultados.get(tmp) + mesa.getVotosSenadores().get(tmp)));
                        } else {
                            resultados.put(tmp, mesa.getVotosSenadores().get(tmp));
                        }
                    }
                }
            }
        }
        Iterator<Integer> it = resultados.keySet().iterator();
        while (it.hasNext()) {
            tmp = it.next();
            if (!(tmp == -1)) {
                if (resultados.get(tmp) > max) {
                    max = resultados.get(tmp);
                    tmpList = CamaraElectoral.buscarLista(tmp);
                }
            }
        }
        return tmpList;
    }

    /**
     *
     * funcion que devuelve un mapa con los votos para senadores y cantidad de
     * votos
     *
     *
     * @return mapa con los votos para senadores y la cantidad
     */
    public Map<PartidoPoliticoAlianza, Double> totalVotosSenadores() {
        int tmp = -10;
        Lista tmpList = null;
        Map<PartidoPoliticoAlianza, Double> listado = new HashMap<PartidoPoliticoAlianza, Double>();
        for (Seccion seccion : secciones) {
            for (Circuito circuito : seccion.getCircuitos()) {
                for (MesaElectoral mesa : circuito.getMesas()) {
                    Iterator<Integer> it = mesa.getVotosDiputados().keySet().iterator();
                    it = mesa.getVotosSenadores().keySet().iterator();
                    while (it.hasNext()) {
                        tmp = it.next();
                        tmpList = CamaraElectoral.buscarLista(tmp);
                        if (Objects.nonNull(listado.get(tmpList.getPartido()))) {
                            listado.replace(tmpList.getPartido(), (listado.get(tmpList.getPartido()) + mesa.getVotosSenadores().get(tmp)));
                        } else {
                            listado.put(tmpList.getPartido(), Double.valueOf(mesa.getVotosSenadores().get(tmp)));
                        }
                    }
                }
            }
        }
        return listado;
    }

    /**
     *
     * funcion que devuelve un mapa con los votos para Diputados y cantidad de
     * votos
     *
     *
     * @return mapa con los votos para diputados y la cantidad
     */
    public Map<PartidoPoliticoAlianza, Double> totalVotosDiputados() {
        int tmp = -10;
        Lista tmpList = null;
        Map<PartidoPoliticoAlianza, Double> listado = new HashMap<PartidoPoliticoAlianza, Double>();
        for (Seccion seccion : secciones) {
            for (Circuito circuito : seccion.getCircuitos()) {
                for (MesaElectoral mesa : circuito.getMesas()) {
                    Iterator<Integer> it = mesa.getVotosDiputados().keySet().iterator();
                    while (it.hasNext()) {
                        tmp = it.next();
                        tmpList = CamaraElectoral.buscarLista(tmp);
                        if (Objects.nonNull(listado.get(tmpList.getPartido()))) {
                            listado.replace(tmpList.getPartido(), (listado.get(tmpList.getPartido()) + (mesa.getVotosDiputados().get(tmp))));
                        } else {
                            listado.put(tmpList.getPartido(), Double.valueOf(mesa.getVotosDiputados().get(tmp)));
                        }
                    }
                }
            }
        }
        return listado;
    }

    public String toString() {
        return getNombre();
    }
}
