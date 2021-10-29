import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**

 * Nombre de clase: CamaraElectoral 

 * Esta clase incluye listas a las mesas, comprobacion de las mismas para que no tengan el mismo candidato, busqueda
 * de dichas y devolver partidos politicos


 * @version: 28/10/2021/A

 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias

 */

public class CamaraElectoral {
    /**

     * funcion estatica para la inclusion de listas

     * @param list El parámetro list define la lista que se va a incluir si es que cumple que no tenga candidatos 
     * iguales con otra y que no este ya incluida

     */
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
    /**

     * funcion estatica para la comprobacion de no tener candidatos repetidos

     * @param cand El parámetro cand define el usuario a ser comprobado para que no este en multiples listas

     */
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
    /**
     *
     * funcion estatica para la comprobacion de no tener candidatos repetidos en
     * una lista especifica
     *
     * @param cand El parámetro cand define el usuario a ser comprobado para que
     * no este en la lista especifica
     * @param lista El parámetro lista define la listaa ser comprobada 
     */
    
    public static boolean ComprobarCandidato(Candidato cand,Lista lista){
        for (Candidato candida : lista.getCandidatos()) {
            if(cand.equals(candida)){
                return true;
            }
        }
        return false;
    }
    
    /**
     *
     * funcion estatica para la busqueda de lista por numero entero
     *
     * @param num El parámetro num define numero entero para buscar y luego 
     * imprimir la lista
     
     */
    
    public static Lista buscarLista(Integer num){
        for (Lista list : Main.listas) {
            if(list.getNroDeLista()==num){
                return list;
            }
        }
        return null;
    }
    
    /**
     *
     * funcion estatica devuelve los nombres de un listado
     *
     * @param lista El parámetro num se pasa como String[]
     
     */
    
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
