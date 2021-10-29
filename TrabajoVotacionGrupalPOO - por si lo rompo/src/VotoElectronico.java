public class VotoElectronico {
    public static int ComprobarDatos(int dni){
        for (ElectorInscripto elector : Main.electores) {
            if(elector.equals(dni)){
                if(!elector.getVoto()){
                    return 1;
                } else {
                    return 2;
                }
            }
        }
        return 3;
    }

    public static ElectorInscripto getPersonaActual(int dni){
        for (ElectorInscripto elector : Main.electores) {
            if(elector.equals(dni)){
                return elector;
            }
        }
        return null;
    }

}
