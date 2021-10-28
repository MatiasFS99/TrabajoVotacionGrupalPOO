import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MesaElectoral {
    private ElectorInscripto presidente;
    private ElectorInscripto suplenteDePresidente;
    private List<ElectorInscripto> electores;
    private Map<Integer,Integer> votosDiputados = new HashMap<Integer,Integer>();
    private Map<Integer,Integer> votosSenadores = new HashMap<Integer,Integer>();
    private int votosFaltantes;
    private int numeroDeMesa;

    public MesaElectoral(List<ElectorInscripto> electores, List<Lista> listas) {
        this.electores = electores;
        ObtenerAutoridades();
        this.votosFaltantes = electores.size();
        agregarCandidatos(listas);
    }

    public MesaElectoral(List<ElectorInscripto> electores) {
        this.electores = electores;
        ObtenerAutoridades();
        this.votosFaltantes = electores.size();
    }

    private void ObtenerAutoridades(){
        int i = 0;
        for (int j=0; j<electores.size();j++) {
            if(electores.get(j).getEdad()>=18 && electores.get(j).getEdad()<=70){
                if(i==0){
                    this.presidente = electores.get(j);
                }
                if(i==1){
                    this.suplenteDePresidente = electores.get(j);
                }
                i++;
            }
            if(i==2){
                break;
            }
        }
    }

    public void agregarCandidatos(List<Lista> listas){
        for (Lista lista : listas) {
            this.votosDiputados.put(lista.getNroDeLista(), 0);
            this.votosSenadores.put(lista.getNroDeLista(), 0);
        }
    }

    public void agregarCandidatos(Lista lista){
        this.votosDiputados.put(lista.getNroDeLista(), 0);
        this.votosSenadores.put(lista.getNroDeLista(), 0);
    }

    public ElectorInscripto getPresidente() {
        return this.presidente;
    }

    public void setPresidente(ElectorInscripto presidente) {
        this.presidente = presidente;
    }

    public ElectorInscripto getSuplenteDePresidente() {
        return this.suplenteDePresidente;
    }

    public void setSuplenteDePresidente(ElectorInscripto suplenteDePresidente) {
        this.suplenteDePresidente = suplenteDePresidente;
    }

    public List<ElectorInscripto> getElectores() {
        return this.electores;
    }

    public void setElectores(List<ElectorInscripto> electores) {
        this.electores = electores;
    }

    public void setElectores(ElectorInscripto elector) {
        this.electores.add(elector);
    }

    public Boolean verificarElector(ElectorInscripto elector){
        for (ElectorInscripto electorInscripto : electores) {
            if(electorInscripto.equals(elector)){
                if(!elector.getVoto()){
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public int conteoVotantes(){
        int total = 0;
        Iterator<Integer> it = votosDiputados.keySet().iterator();
        while(it.hasNext()){
            Integer list = it.next();
            total += votosDiputados.get(list);
        }
        return total;
    }

    public Map<Integer,Integer> getVotosDiputados(){
        return this.votosDiputados;
    }

    public Map<Integer,Integer> getVotosSenadores(){
        return this.votosSenadores;
    }

    public int conteoVotosBlancoSenadores(){
        return votosSenadores.get(-1);
    }

    public int conteoVotosBlancoDiputados(){
        return votosDiputados.get(-1);
    }

    public int getVotosFaltantes(){
        return this.votosFaltantes;
    }

    public Double getPorcentajeAusencia(){
        return Double.valueOf((this.votosFaltantes*100)/electores.size());
    }

    public int getTotalVotantes(){
        return this.electores.size();
    }

    public void Votar(ElectorInscripto votante, Integer diputado, Integer senador){
        this.votosDiputados.replace(diputado, votosDiputados.get(diputado)+1);
        this.votosSenadores.replace(senador, votosDiputados.get(senador)+1);
        votante.setVoto();
        this.votosFaltantes -= 1;
    }

    public void setNumeroMesa(int numero){
        this.numeroDeMesa = numero;
    }
    public String toString(){
        return Integer.toString(numeroDeMesa);
    }
}
