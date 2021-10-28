import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class CamaraElectoral {
    public static Boolean incluirLista(Lista list){
        boolean esta = false;
        if(Objects.nonNull(Main.listas)){
            for (Lista ciclo : Main.listas) {
                if(ciclo.equals(list) || ciclo.getNroDeLista()==list.getNroDeLista()){
                    return false;
                }
                for (Candidato candi : list.getCandidatos()) {
                    if(ComprobarCandidato(candi,ciclo)){
                        return false;
                    }
                }
            }
        }
        if(!esta){
            return true;
        }
        return false;
    }

    public static boolean ComprobarCandidato(Candidato cand){
        for (Lista list : Main.listas) {
            for (Candidato candida : list.getCandidatos()) {
                if(cand.equals(candida)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean ComprobarCandidato(Candidato cand,Lista lista){
        for (Candidato candida : lista.getCandidatos()) {
            if(cand.equals(candida)){
                return true;
            }
        }
        return false;
    }
    public static Lista buscarLista(Integer num){
        for (Lista list : Main.listas) {
            if(list.getNroDeLista()==num){
                return list;
            }
        }
        return null;
    }
    
    public static String[] nombresPartidos(Map<Integer, Integer> lista){
        String[] salida = new String[lista.size()];
        int i = 0;
        Iterator<Integer> it = lista.keySet().iterator();
        while(it.hasNext()){
            salida[i] = buscarLista(it.next()).getNombre();
            i++;
        }
        return salida;
    }
}
