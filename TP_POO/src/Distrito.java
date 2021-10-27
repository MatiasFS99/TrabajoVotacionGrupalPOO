import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Distrito {
    private String nombre;
    private int CantPLibresDip;
    private int CantPLibresSen;
    private List<Seccion> secciones;
    private List<Lista> listas;

    public Distrito(String nombre, int CantPLibresDip, int CantPLibresSen, List<Seccion> seccciones, List<Lista> listas) {
        this.nombre = nombre;
        this.CantPLibresDip = CantPLibresDip;
        this.CantPLibresSen = CantPLibresSen;
        this.secciones = seccciones;
        this.listas = listas;
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantPLibresDip() {
        return this.CantPLibresDip;
    }

    public void setCantPLibresDip(int CantPLibresDip) {
        this.CantPLibresDip = CantPLibresDip;
    }

    public int getCantPLibresSen() {
        return this.CantPLibresSen;
    }

    public void setCantPLibresSen(int CantPLibresSen) {
        this.CantPLibresSen = CantPLibresSen;
    }

    public List<Seccion> getSecciones() {
        return this.secciones;
    }

    public void setSecciones(List<Seccion> secciones) {
        this.secciones = secciones;
    }

    public List<Lista> getListas() {
        return this.listas;
    }

    public void setListas(List<Lista> listas) {
        this.listas = listas;
    }

    public int totalVotantes(){
        int total = 0;
        for (Seccion seccion : this.secciones) {
            for (Circuito circuito : seccion.getCircuitos()){
                for (MesaElectoral mesa : circuito.getMesas()){
                    total += mesa.conteoVotantes();
                }
            }
        }
        return total;
    }

    public int totalVotosEnBlanco(){
        int total = 0;
        for (Seccion seccion : this.secciones) {
            for (Circuito circuito : seccion.getCircuitos()){
                for (MesaElectoral mesa : circuito.getMesas()){
                    total += mesa.conteoVotosBlanco();
                }
            }
        }
        return total;
    }

    public int totalVotosPorPartidoAlianza(PartidoPoliticoAlianza partido){
        int total = 0;
        for (Seccion seccion : this.secciones) {
            for (Circuito circuito : seccion.getCircuitos()){
                for (MesaElectoral mesa : circuito.getMesas()){
                    total += mesa.conteoVotosPartidoAlianza(partido);
                }
            }
        }
        return total;
    }

    public int totalPorcentajeDeVotacion(){
        int votos = 0;
        int total = 0;

        for (Seccion seccion : this.secciones) {
            for (Circuito circuito : seccion.getCircuitos()){
                for (MesaElectoral mesa : circuito.getMesas()){
                    total += mesa.getTotalVotantes();
                    votos += mesa.getVotosFaltantes();
                }
            }
        }
        return (total-votos);
    }

    public Map<PartidoPoliticoAlianza,Integer> totalGeneralDeVotacionListaVotoBlanco(){
        Map<PartidoPoliticoAlianza,Integer> listado = new HashMap<PartidoPoliticoAlianza,Integer>();
        for (Seccion seccion : this.secciones) {
            for (Circuito circuito : seccion.getCircuitos()){
                for (MesaElectoral mesa : circuito.getMesas()){
                    for (PartidoPoliticoAlianza partido : mesa.getPartidos()) {
                        if(Objects.nonNull(listado.get(partido))){
                            listado.replace(partido, ( listado.get(partido) + mesa.conteoVotosPartidoAlianza(partido) ) );
                        } else {
                            listado.put(partido, mesa.conteoVotosPartidoAlianza(partido));
                        }
                    }
                }
            }
        }
        return listado;
    }

    public String toString(){
        return getNombre();
    }
}
