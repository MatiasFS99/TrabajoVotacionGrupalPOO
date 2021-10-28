import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Distrito {
    private String nombre;
    private int CantPLibresDip;
    private int CantPLibresSen;
    private List<Seccion> secciones;

    public Distrito(String nombre, int CantPLibresDip, int CantPLibresSen, List<Seccion> seccciones) {
        this.nombre = nombre;
        this.CantPLibresDip = CantPLibresDip;
        this.CantPLibresSen = CantPLibresSen;
        this.secciones = seccciones;
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

    public Double procentajeAusencia(){
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
        return porcentaje/i;
    }
    public int totalVotosEnBlancoDiputados(){
        int total = 0;
        for (Seccion seccion : this.secciones) {
            for (Circuito circuito : seccion.getCircuitos()){
                for (MesaElectoral mesa : circuito.getMesas()){
                    total += mesa.conteoVotosBlancoDiputados();
                }
            }
        }
        return total;
    }

    public int totalVotosEnBlancoSenadores(){
        int total = 0;
        for (Seccion seccion : this.secciones) {
            for (Circuito circuito : seccion.getCircuitos()){
                for (MesaElectoral mesa : circuito.getMesas()){
                    total += mesa.conteoVotosBlancoSenadores();
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

    public Map<PartidoPoliticoAlianza,Double> totalVotosPartidoAlianza(){
        int tmp = -10;
        Lista tmpList = null;
        Map<PartidoPoliticoAlianza,Double> listado = new HashMap<PartidoPoliticoAlianza,Double>();
        for (Seccion seccion : secciones) {
            for (Circuito circuito : seccion.getCircuitos()) {
                for (MesaElectoral mesa : circuito.getMesas()) {
                    Iterator<Integer> it = mesa.getVotosDiputados().keySet().iterator();
                    while(it.hasNext()){
                        tmp = it.next();
                        tmpList = CamaraElectoral.buscarLista(tmp);
                        if(Objects.nonNull(listado.get(tmpList.getPartido()))){
                            listado.replace(tmpList.getPartido(), (listado.get(tmpList.getPartido())+(mesa.getVotosDiputados().get(tmp)/2)));
                        }else{
                            listado.put(tmpList.getPartido(), Double.valueOf(mesa.getVotosDiputados().get(tmp)/2));
                        }
                    }

                    it = mesa.getVotosSenadores().keySet().iterator();
                    while(it.hasNext()){
                        tmp = it.next();
                        tmpList = CamaraElectoral.buscarLista(tmp);
                        if(Objects.nonNull(listado.get(tmpList.getPartido()))){
                            listado.replace(tmpList.getPartido(), (listado.get(tmpList.getPartido())+(mesa.getVotosSenadores().get(tmp)/2)));
                        }else{
                            listado.put(tmpList.getPartido(), Double.valueOf(mesa.getVotosSenadores().get(tmp)/2));
                        }
                    }
                }
            }
        }
        return listado;
    }

    public Lista ganadorDiputados(){
        int tmp = -10;
        int max = -1;
        Lista tmpList = null;
        Map<Integer,Integer> resultados = new HashMap<Integer,Integer>();
        for (Seccion seccion : secciones) {
            for (Circuito circuito : seccion.getCircuitos()) {
                for (MesaElectoral mesa : circuito.getMesas()) {
                    Iterator<Integer> it = mesa.getVotosDiputados().keySet().iterator();
                    it = mesa.getVotosDiputados().keySet().iterator();
                    while(it.hasNext()){
                        tmp = it.next();
                        if(Objects.nonNull(resultados.get(tmp))){
                            resultados.replace(tmp, (resultados.get(tmp)+mesa.getVotosDiputados().get(tmp)) );
                        } else {
                            resultados.put(tmp, mesa.getVotosDiputados().get(tmp));
                        }
                    }
                }
            }
        }
        Iterator<Integer> it = resultados.keySet().iterator();
        while(it.hasNext()){
            tmp = it.next();
            if(!(tmp==-1)){
                if(resultados.get(tmp)>max){
                    max = resultados.get(tmp);
                    tmpList = CamaraElectoral.buscarLista(tmp);
                }
            }
        }
        return tmpList;
    }

    public Lista ganadorSenadores(){
        int tmp = -10;
        int max = -1;
        Lista tmpList = null;
        Map<Integer,Integer> resultados = new HashMap<Integer,Integer>();
        for (Seccion seccion : secciones) {
            for (Circuito circuito : seccion.getCircuitos()) {
                for (MesaElectoral mesa : circuito.getMesas()) {
                    Iterator<Integer> it = mesa.getVotosSenadores().keySet().iterator();
                    it = mesa.getVotosSenadores().keySet().iterator();
                    while(it.hasNext()){
                        tmp = it.next();
                        if(Objects.nonNull(resultados.get(tmp))){
                            resultados.replace(tmp, (resultados.get(tmp)+mesa.getVotosSenadores().get(tmp)) );
                        } else {
                            resultados.put(tmp, mesa.getVotosSenadores().get(tmp));
                        }
                    }
                }
            }
        }
        Iterator<Integer> it = resultados.keySet().iterator();
        while(it.hasNext()){
            tmp = it.next();
            if(!(tmp==-1)){
                if(resultados.get(tmp)>max){
                    max = resultados.get(tmp);
                    tmpList = CamaraElectoral.buscarLista(tmp);
                }
            }
        }
        return tmpList;
    }

    public Map<PartidoPoliticoAlianza,Double> totalVotosSenadores(){
        int tmp = -10;
        Lista tmpList = null;
        Map<PartidoPoliticoAlianza,Double> listado = new HashMap<PartidoPoliticoAlianza,Double>();
        for (Seccion seccion : secciones) {
            for (Circuito circuito : seccion.getCircuitos()) {
                for (MesaElectoral mesa : circuito.getMesas()) {
                    Iterator<Integer> it = mesa.getVotosDiputados().keySet().iterator();
                    it = mesa.getVotosSenadores().keySet().iterator();
                    while(it.hasNext()){
                        tmp = it.next();
                        tmpList = CamaraElectoral.buscarLista(tmp);
                        if(Objects.nonNull(listado.get(tmpList.getPartido()))){
                            listado.replace(tmpList.getPartido(), (listado.get(tmpList.getPartido())+mesa.getVotosSenadores().get(tmp)));
                        }else{
                            listado.put(tmpList.getPartido(), Double.valueOf(mesa.getVotosSenadores().get(tmp)));
                        }
                    }
                }
            }
        }
        return listado;
    }

    public Map<PartidoPoliticoAlianza,Double> totalVotosDiputados(){
        int tmp = -10;
        Lista tmpList = null;
        Map<PartidoPoliticoAlianza,Double> listado = new HashMap<PartidoPoliticoAlianza,Double>();
        for (Seccion seccion : secciones) {
            for (Circuito circuito : seccion.getCircuitos()) {
                for (MesaElectoral mesa : circuito.getMesas()) {
                    Iterator<Integer> it = mesa.getVotosDiputados().keySet().iterator();
                    while(it.hasNext()){
                        tmp = it.next();
                        tmpList = CamaraElectoral.buscarLista(tmp);
                        if(Objects.nonNull(listado.get(tmpList.getPartido()))){
                            listado.replace(tmpList.getPartido(), (listado.get(tmpList.getPartido())+(mesa.getVotosDiputados().get(tmp))));
                        }else{
                            listado.put(tmpList.getPartido(), Double.valueOf(mesa.getVotosDiputados().get(tmp)));
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
