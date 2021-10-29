import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**

 * Nombre de clase: MesaElectoral 

 * Esta clase lleva registro y verificacion de los electores y estadisticas de votos
 * en la mesa correspondiente

 * @version: 28/10/2021/A

 * @autores: Caraballo Ian, Craco Iv�n, Serantes Matias

 */


public class MesaElectoral {
    private ElectorInscripto presidente;
    private ElectorInscripto suplenteDePresidente;
    private List<ElectorInscripto> electores;
    private Map<Integer,Integer> votosDiputados = new HashMap<Integer,Integer>();
    private Map<Integer,Integer> votosSenadores = new HashMap<Integer,Integer>();
    private int votosFaltantes;
    private int numeroDeMesa;
    
    
    /**
     * Constructor para la Mesa Electoral
     * @param electores lista de electores
     * @param listas lista de partidos
     * Electores define la lista de ElectorInscripto y listas agrega
     * candidatos a la Lista.
     * Se establece votosFaltantes como la cantidad de electores en la lista electores.
     */
    
    public MesaElectoral(List<ElectorInscripto> electores, List<Lista> listas) {
        this.electores = electores;
        ObtenerAutoridades();
        this.votosFaltantes = electores.size();
        agregarCandidatos(listas);
    }
    
    /**
     * Constructor para la Mesa Electoral
     * @param electores
     * electores define la lista de ElectorInscripto.
     * Se establece votosFaltantes como la cantidad de electores en la lista electores.
     */    
    public MesaElectoral(List<ElectorInscripto> electores) {
        this.electores = electores;
        ObtenerAutoridades();
        this.votosFaltantes = electores.size();
    }
    
    /**
     * Obtiene las autoridades de mesa
     * @void
     */    
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

    /**
     * Recorre el List listas y agrega en el Map de votosDiputados y
     * en el Map de votosSenadores el n�mero de cada lista.
     * @void
     * @param listas
     */      
    public void agregarCandidatos(List<Lista> listas){
        for (Lista lista : listas) {
            this.votosDiputados.put(lista.getNroDeLista(), 0);
            this.votosSenadores.put(lista.getNroDeLista(), 0);
        }
    }
    
    /**
     * Agrega el n�mero de lista de la lista pasada por par�metro
     * al Map de votosDiputados y
     * al Map de votosSenadores.
     * @void
     * @param lista
     */      
    public void agregarCandidatos(Lista lista){
        this.votosDiputados.put(lista.getNroDeLista(), 0);
        this.votosSenadores.put(lista.getNroDeLista(), 0);
    }
    
    /**
     * Devuelve al presidente de la mesa
     * @return ElectorInscripto Presidente de la mesa
     */      
    public ElectorInscripto getPresidente() {
        return this.presidente;
    }

    /**
     * Asigna Un ElectorInscripto como presidente
     * @param presidente Elector a ser asignado como presidente
     */    
    public void setPresidente(ElectorInscripto presidente) {
        this.presidente = presidente;
    }
    
    
    /**
     * Devuelve al Suplente de presidente de la mesa
     * @return ElectorInscripto Suplente de presidente de la mesa
     */    
    public ElectorInscripto getSuplenteDePresidente() {
        return this.suplenteDePresidente;
    }

    /**
     * Asigna Un ElectorInscripto como Suplente de presidente presidente
     * @param suplenteDePresidente Elector a ser asignado como suplente de presidente
     */         
    public void setSuplenteDePresidente(ElectorInscripto suplenteDePresidente) {
        this.suplenteDePresidente = suplenteDePresidente;
    }
    
    
    /**Devuelve una lista con los electores
     * @return List ElectorInscripto lista de los electores
     */    
    public List<ElectorInscripto> getElectores() {
        return this.electores;
    }

    /**Asigna una lista como la lista de electores de la mesa
     * @param electores Lista de electores a asignar
     */        
    public void setElectores(List<ElectorInscripto> electores) {
        this.electores = electores;
    }

    /**
     * Agrega un elector a la lista de electores
     * @param elector Elector a agregar
     */        
    public void setElectores(ElectorInscripto elector) {
        this.electores.add(elector);
    }
    
    
    /**
     * Verifica si el elector pasado por par�metro vot�.
     * @param elector Elector a revisar
     * @return boolean Voto o no voto como booleano
     */ 
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
    
    
    /**
     * Retorna un entero que es el resultado de recorrer el Map de votosDiputados
     * con un iterador y almacenarlo en una variable.
     * @return int cantidad de votos realizados
     */ 
    public int conteoVotantes(){
        int total = 0;
        Iterator<Integer> it = votosDiputados.keySet().iterator();
        while(it.hasNext()){
            Integer list = it.next();
            total += votosDiputados.get(list);
        }
        return total;
    }

    /**
     * Devuelve un mapa con los votos de diputados por numero de lista
     * @return Map Mapa con los votos de diputados por numero de lista
     */    
    public Map<Integer,Integer> getVotosDiputados(){
        return this.votosDiputados;
    }
    
    /**
     * Devuelve un mapa con los votos de senadores por numero de lista
     * @return Map Mapa con los votos de senadores por numero de lista
     */      
    public Map<Integer,Integer> getVotosSenadores(){
        return this.votosSenadores;
    }
       
    /**
     * Retorna un entero de votos en blanco a Senadores
     * @return int cantidad de votos en blanco senadores
     */ 
    public int conteoVotosBlancoSenadores(){
        return votosSenadores.get(-1);
    }
        
    /**
     * Retrona un entero de votos en blanco a Diputados
     * @return int cantidad de votos en blanco diputados
     */ 
    public int conteoVotosBlancoDiputados(){
        return votosDiputados.get(-1);
    }
       
    /**
     * Retorna la cantidad de votos faltantes en la mesa
     * @return Integer cantidad de votos faltantes en la mesa
     */ 
    public int getVotosFaltantes(){
        return this.votosFaltantes;
    }
      
    /**
     * Retorna el porcentaje de ausencia de electores
     * @return Double Porcentaje de electores que aun no votaron
     */ 
    public Double getPorcentajeAusencia(){
        return Double.valueOf((this.votosFaltantes*100)/electores.size());
    }
    
    /**
     * Retorna el total de electores.
     * @return int Total de electores asignados a la mesa
     */     
    public int getTotalVotantes(){
        return this.electores.size();
    }
    
    
    /**
     * M�todo que permite al elector llevar a cabo la votaci�n,
     * cuenta el voto y marca al usuario que vot�.
     * @param votante Elector que va a votar
     * @param diputado lista a la que voto para diputados
     * @param senador lista a la que voto para senadores
     */ 
    public void Votar(ElectorInscripto votante, Integer diputado, Integer senador){
        this.votosDiputados.replace(diputado, votosDiputados.get(diputado)+1);
        this.votosSenadores.replace(senador, votosDiputados.get(senador)+1);
        votante.setVoto();
        this.votosFaltantes -= 1;
    }
    
    
    /**
     * Asigna el numero de mesa
     * @param numero el numero a asignar a la mesa
     */           
    public void setNumeroMesa(int numero){
        this.numeroDeMesa = numero;
    }
    
    /**
     * Retorna String del n�mero de mesa
     * @return String numero de la mesa
     */        
    public String toString(){
        return Integer.toString(numeroDeMesa);
    }
}