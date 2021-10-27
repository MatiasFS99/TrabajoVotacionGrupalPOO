import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MesaElectoral {
    private ElectorInscripto presidente;
    private ElectorInscripto suplenteDePresidente;
    private List<ElectorInscripto> electores;
    private Map<PartidoPoliticoAlianza,Integer> votos = new HashMap<PartidoPoliticoAlianza,Integer>();
    private PartidoPoliticoAlianza blanco = new PartidoPoliticoAlianza("Blanco", null);
    private int votosFaltantes;
    private int numeroDeMesa;

    public MesaElectoral(List<ElectorInscripto> electores, List<PartidoPoliticoAlianza> partidos) {
        this.electores = electores;
        ObtenerAutoridades();
        this.votosFaltantes = electores.size();
        this.votos.put(blanco, 0);
        agregarPartidos(partidos);
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

    private void agregarPartidos(List<PartidoPoliticoAlianza> partidoPoliticoAlianzas){
        for (PartidoPoliticoAlianza partido : partidoPoliticoAlianzas) {
            votos.put(partido, 0);
        }
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
        Iterator<PartidoPoliticoAlianza> it = votos.keySet().iterator();
        while(it.hasNext()){
            PartidoPoliticoAlianza partido = it.next();
            total += votos.get(partido);
        }
        return total;
    }

    public Map<PartidoPoliticoAlianza,Integer> getVotos(){
        return this.votos;
    }

    public int conteoVotosBlanco(){
        return votos.get(blanco);
    }

    public int conteoVotosPartidoAlianza(PartidoPoliticoAlianza partido){
        return votos.get(partido);
    }

    public int getVotosFaltantes(){
        return this.votosFaltantes;
    }

    public int getTotalVotantes(){
        return this.electores.size();
    }

    public void Votar(ElectorInscripto votante, String partido){
        PartidoPoliticoAlianza voto = null;
        for (PartidoPoliticoAlianza part : getPartidos()) {
            if(partido.equals(part.getNombre())){
                voto = part;
                break;
            }
        }
        this.votos.replace(voto, this.votos.get(voto)+1);
        votante.setVoto();
        this.votosFaltantes -= 1;
    }

    public List<PartidoPoliticoAlianza> getPartidos(){
        List<PartidoPoliticoAlianza> partidos = new ArrayList<PartidoPoliticoAlianza>();
        Iterator<PartidoPoliticoAlianza> it = votos.keySet().iterator();
        while(it.hasNext()){
            partidos.add(it.next());
        }
        return partidos;
    }

    public void setNumeroMesa(int numero){
        this.numeroDeMesa = numero;
    }
    public String toString(){
        return Integer.toString(numeroDeMesa);
    }
}
