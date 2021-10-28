import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerarDatos {

    private static String[] LugaresPersonas = new String[]{
        "RioTercero",
        "Marcos Paz",
        "Chacarita",
        "Concordia",
        "Villa Urquiza",
        "San Salvador",
        "Devoto",
        "Rosario",
        "Saveedra",
        "Rawson",
        "Caballito",
        "Colon",
        "Mataderos"
    };

    public static List<ElectorInscripto> elector(){
        List<ElectorInscripto> salida = new ArrayList<ElectorInscripto>();
        int j=0;
        for (Persona persona : Main.personas) {
            salida.add(new ElectorInscripto(persona, new Domicilio("", "", LugaresPersonas[j]), null));
            j++;
            if(j==LugaresPersonas.length){
                j=0;
            }
        }
        return salida;
    }

    public static List<PartidoPoliticoAlianza> partidos(){
        //ninguno de los partidos existe hasta donde se, ni estan basados en ningun partido real
        List<PartidoPoliticoAlianza> salida = new ArrayList<PartidoPoliticoAlianza>();
        salida.add(new PartidoPoliticoAlianza("Frente Progresista", null));
        salida.add(new PartidoPoliticoAlianza("Unidos por el Capital", null));
        return salida;
    }

    public static void asignarListasMesas(){
        for (Seccion sec : Main.distritos.get(0).getSecciones()) {
            for (Circuito circ : sec.getCircuitos()) {
                for (MesaElectoral mesa : circ.getMesas()) {
                    mesa.agregarCandidatos(Main.listas.subList(0, 2));
                }
            }
        }
        for (Seccion sec : Main.distritos.get(1).getSecciones()) {
            for (Circuito circ : sec.getCircuitos()) {
                for (MesaElectoral mesa : circ.getMesas()) {
                    mesa.agregarCandidatos(Main.listas.subList(2,4));
                }
            }
        }
    }
    public static List<Candidato> candidatos(){
        List<Candidato> salida = new ArrayList<Candidato>();
        salida.add(new Candidato("Izan", "Real", 31350291, "26/12/1975", Cargo.SENADOR, new Domicilio("", "", "")));
        salida.add(new Candidato("Edgar", "Aviles", 33562588, "03/09/1972", Cargo.SENADOR, new Domicilio("", "", "")));
        salida.add(new Candidato("Letícia", "Dorado", 40213123, "05/03/1971", Cargo.DIPUTADO, new Domicilio("", "", "")));
        salida.add(new Candidato("Siham", "Alcazar", 44662520, "15/12/1985", Cargo.DIPUTADO, new Domicilio("", "", "")));
        salida.add(new Candidato("Jasmin", "Dupont", 44006157, "30/06/1978", Cargo.DIPUTADO, new Domicilio("", "", "")));
        salida.add(new Candidato("Lola", "Pulido", 39180217, "18/01/1990", Cargo.DIPUTADO, new Domicilio("", "", "")));
        salida.add(new Candidato("Nicole", "Ribera", 30266932, "23/11/1984", Cargo.DIPUTADO, new Domicilio("", "", "")));
        salida.add(new Candidato("Jose", "Duran", 43596024, "25/07/1973", Cargo.SENADOR, new Domicilio("", "", "")));
        salida.add(new Candidato("Miguel", "Vera", 33080472, "01/05/1978", Cargo.SENADOR, new Domicilio("", "", "")));
        salida.add(new Candidato("Manuela", "Avila", 41348694, "11/09/1987", Cargo.DIPUTADO, new Domicilio("", "", "")));
        salida.add(new Candidato("Michael", "Ureña", 41077481, "07/01/1973", Cargo.DIPUTADO, new Domicilio("", "", "")));
        salida.add(new Candidato("Jean", "Mesa", 34982920, "29/08/1984", Cargo.DIPUTADO, new Domicilio("", "", "")));
        salida.add(new Candidato("Cristobal", "Gamero", 40463208, "17/06/1973", Cargo.DIPUTADO, new Domicilio("", "", "")));
        salida.add(new Candidato("Amina", "Poveda", 30104120, "27/10/1988", Cargo.DIPUTADO, new Domicilio("", "", "")));
        salida.add(new Candidato("Chloe", "Salazar", 32740332, "01/01/1977", Cargo.SENADOR, new Domicilio("", "", "")));
        salida.add(new Candidato("Nagore", "Murcia", 32754221, "14/02/1979", Cargo.DIPUTADO, new Domicilio("", "", "")));
        salida.add(new Candidato("Toni", "Alves", 44394749, "28/09/1976", Cargo.DIPUTADO, new Domicilio("", "", "")));
        salida.add(new Candidato("Gumersindo", "Estevez", 38773648, "17/02/1974", Cargo.DIPUTADO, new Domicilio("", "", "")));
        salida.add(new Candidato("Esteban", "Amador", 35590237, "22/04/1985", Cargo.SENADOR, new Domicilio("", "", "")));
        salida.add(new Candidato("Erica", "Montilla", 41749924, "29/03/1991", Cargo.DIPUTADO, new Domicilio("", "", ""))); 
        salida.add(new Candidato("Gerardo", "Molinaro",31515613, "25/12/1968", Cargo.DIPUTADO, new Domicilio("", "", ""))); 
        salida.add(new Candidato("Ramon", "Olivera", 32585945, "16/04/1975", Cargo.DIPUTADO, new Domicilio("", "", "")));
        return salida;
    }

    public static List<Lista> listas(){
        List<Lista> salida = new ArrayList<Lista>();
        Lista l1 = new Lista("Lista Progreso", 1, Main.partidos.get(0),Main.candidatos.subList(0, 7));
        Lista l2 =new Lista("Adelante Comercio", 2, Main.partidos.get(1),Main.candidatos.subList(7, 14));
        Lista l3 =new Lista("Vamos a Progresar", 3, Main.partidos.get(0),Main.candidatos.subList(14, 19));
        Lista l4 =new Lista("Economia Fuerte", 4, Main.partidos.get(1),Main.candidatos.subList(19, 22));
        if(CamaraElectoral.incluirLista(l1)){
            salida.add(l1);
        }
        if(CamaraElectoral.incluirLista(l2)){
            salida.add(l2);
        }
        if(CamaraElectoral.incluirLista(l3)){
            salida.add(l3);
        }
        if(CamaraElectoral.incluirLista(l4)){
            salida.add(l4);
        }
        return salida;
    }

    public static List<MesaElectoral> mesasElectorales(){
        int j=0;
        List<MesaElectoral> salida = new ArrayList<MesaElectoral>();
        List<List<ElectorInscripto>> tmp = new ArrayList<List<ElectorInscripto>>();
        for(int i=0;i<LugaresPersonas.length;i++){
            tmp.add(new ArrayList<ElectorInscripto>());
        }
        for (String lugar: LugaresPersonas) {
            for (ElectorInscripto persona : Main.electores) {
                if(persona.getDomicilio().getDepartamento().equals(lugar)){
                    tmp.get(j).add(persona);
                }
            }
            salida.add(new MesaElectoral(tmp.get(j)));
            j++;
        }
        return salida;
    }

    public static List<Circuito> circuitos(){
        List<Circuito> salida = new ArrayList<Circuito>();
        String lectura = null;
        int j = 0;

        List<List<MesaElectoral>> circuitos = new ArrayList<List<MesaElectoral>>();
        for(int k=0; k<6;k++){
            circuitos.add(new ArrayList<MesaElectoral>());
        }

        for (MesaElectoral mesaElectoral : Main.mesasElectorales) {
            lectura = mesaElectoral.getElectores().get(0).getDomicilio().getDepartamento();
            if(lectura.equals(LugaresPersonas[0])||lectura.equals(LugaresPersonas[1])){
                circuitos.get(0).add(mesaElectoral);
            }
            if(lectura.equals(LugaresPersonas[2])||lectura.equals(LugaresPersonas[3])){
                circuitos.get(1).add(mesaElectoral);
            }
            if(lectura.equals(LugaresPersonas[4])||lectura.equals(LugaresPersonas[5])){
                circuitos.get(2).add(mesaElectoral);
            }
            if(lectura.equals(LugaresPersonas[6])||lectura.equals(LugaresPersonas[7])){
                circuitos.get(3).add(mesaElectoral);
            }
            if(lectura.equals(LugaresPersonas[8])||lectura.equals(LugaresPersonas[9])){
                circuitos.get(4).add(mesaElectoral);
            }
            if(lectura.equals(LugaresPersonas[10])||lectura.equals(LugaresPersonas[11])){
                circuitos.get(5).add(mesaElectoral);
            }
        }
        j=1;
        for (List<MesaElectoral> list : circuitos) {
            salida.add(new Circuito(j, list));
            j++;
            if(j==3){
                j=1;
            }
        }
        return salida;
    }

    public static List<Seccion> secciones(){
        int j = 0;
        List<Seccion> salida = new ArrayList<Seccion>();
        salida.add(new Seccion("Seccion 1", 14, Main.circuitos.subList(j, j+2)));
        j+=2;
        salida.add(new Seccion("Seccion 2", 13, Main.circuitos.subList(j, j+2)));
        j+=2;
        salida.add(new Seccion("Seccion 1", "Cordoba", Main.circuitos.subList(j, j+2)));
        return salida;
    }

    public static List<Distrito> distritos(){
        List<Distrito> salida = new ArrayList<Distrito>();
        salida.add(new Distrito("BSAS", 5, 2, Main.secciones.subList(0, 2)));
        salida.add(new Distrito("Cordoba", 3, 1, Main.secciones.subList(2, 3)));
        return salida;
    }
    
    public static List<Persona> personas(){
        List<Persona> salida = new ArrayList<Persona>();
        // salida.add(new Persona(nombre, apellido, dni, FchaNacimiento));
        salida.add(new Persona("Eduardo", "Kenway", 22023144, "15/08/1975"));
        salida.add(new Persona("Marcelo", "Gomez", 42312141, "04/05/2000"));
        salida.add(new Persona("Blanca", "Rodriguez", 31032412, "21/02/1984"));
        salida.add(new Persona("Gerardo", "Ramirez", 45412513, "22/05/2004"));
        salida.add(new Persona("Claudia", "Auditore", 25123551, "24/03/1979"));
        salida.add(new Persona("Ernesto", "Mendez", 9324123, "02/12/1938"));
        salida.add(new Persona("Everton", "Gomez", 46351513, "14/12/2003"));
        salida.add(new Persona("Melina", "Gutierrez", 47312341, "11/11/2001"));
        salida.add(new Persona("Tereza", "Calcuta", 35151245, "31/01/1954"));
        salida.add(new Persona("Juan", "Dios", 46315341, "12/01/1994"));
        salida.add(new Persona("Julio", "Casas", 46312341, "24/04/1992"));
        salida.add(new Persona("Rosa", "Flores", 42314562, "21/03/1996"));
        salida.add(new Persona("Miguel", "Angel", 20212223, "02/06/1999"));
        salida.add(new Persona("Jesus", "Rodriguez", 21222324, "06/02/2001"));
        salida.add(new Persona("Dario", "Acosta", 22232425, "16/09/1993"));
        salida.add(new Persona("Sergio", "Vilche", 23242526, "14/12/1970"));
        salida.add(new Persona("Sandra", "Vigna", 24252627, "12/11/1975"));
        salida.add(new Persona("Analia", "Gonzales", 25262728, "22/10/1969"));
        salida.add(new Persona("Anahi", "Aguayo", 26272829, "25/05/1980"));
        salida.add(new Persona("Carmen", "Hernandez", 27282930, "27/05/1981"));
        salida.add(new Persona("Luciano", "Fracis", 28293031, "28/05/1982"));
        salida.add(new Persona("Lucia", "Aguilar", 29303132, "13/11/2002"));
        salida.add(new Persona("Silvia", "Almeda", 30313233, "16/09/2001"));
        salida.add(new Persona("Morrigan", "Alonzo", 31323334, "08/10/1994"));
        salida.add(new Persona("Cassandra", "Vanegas", 32333435, "18/08/1995"));
        salida.add(new Persona("Alistar", "Venegas", 33343536, "07/12/1997"));
        salida.add(new Persona("John", "Aranda", 34353637, "07/07/1972"));
        salida.add(new Persona("Jane", "Viveros", 35363738, "04/12/1967"));
        salida.add(new Persona("James", "Espinosa", 42398641, "09/06/1987"));
        salida.add(new Persona("Kaidan", "Cordero", 42556681, "02/10/2000"));
        salida.add(new Persona("Camila", "Villegas", 40312342, "05/06/1996"));
        salida.add(new Persona("Hernan", "Espindola", 42872721, "31/05/1999"));
        salida.add(new Persona("Claudio", "Fernandez", 45676416, "02/11/2002"));
        salida.add(new Persona("Maximo", "Rodrigues", 39409168, "04/03/1984"));
        salida.add(new Persona("Isabell", "Morillo", 41152375, "12/08/1998"));
        salida.add(new Persona("Julio", "Garriga", 35170437, "14/02/1979"));
        salida.add(new Persona("Lia", "Lopez", 42528065, "16/11/2000"));
        salida.add(new Persona("Izaro", "Granados", 39970457, "11/06/1994"));
        salida.add(new Persona("Tomas", "Crespo", 34615848, "12/12/1970"));
        salida.add(new Persona("Anastasio", "Rovira", 36810217, "13/09/1950"));
        salida.add(new Persona("Silvia", "Carmona", 34273975, "15/11/1960"));
        salida.add(new Persona("Toni", "Freire", 46062822, "25/12/2004"));
        salida.add(new Persona("Maialen", "Aznar", 39392984, "21/10/1989"));
        salida.add(new Persona("Ismael", "Andrade", 47793573, "23/08/2003"));
        salida.add(new Persona("Barbara", "Zheng", 32705316, "12/04/1961"));
        salida.add(new Persona("Fidel", "Molina", 45112517, "05/05/2004"));
        salida.add(new Persona("Adam", "Oviedo", 38712016, "02/02/1982"));
        salida.add(new Persona("Bruno", "Diaz", 20134145, "19/09/1928"));
        return salida;
    }
}
