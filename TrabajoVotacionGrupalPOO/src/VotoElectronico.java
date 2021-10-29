
/**
 *
 * Nombre de clase: VotoElectronico
 *
 * Esta comprueba los datos de los electores para permitirles votar
 *
 *
  * @version: 28/10/2021/A
 *
 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias
 *
 */
public class VotoElectronico {

    /**
     *
     * funcion estatica para la comprobacion de datos del elector
     *
     * @param dni El parámetro dni define el dni a ser comprobado para que
     * permita votar
     *
     *@return Respuesta si el elector no voto, voto, o no existe elector con ese dni
     */
    public static int ComprobarDatos(int dni) {
        for (ElectorInscripto elector : Main.electores) {
            if (elector.equals(dni)) {
                if (!elector.getVoto()) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }
        return 3;
    }

    /**
     *
     * funcion estatica para retornar los datos del elector que va a votar
     *
     * @param dni El parámetro dni define el dni a ser comparado hasta encontrar
     * los datos de la persona
     *
     * @return los datos del elector en caso de estar registrado para votar
     */
    public static ElectorInscripto getPersonaActual(int dni) {
        for (ElectorInscripto elector : Main.electores) {
            if (elector.equals(dni)) {
                return elector;
            }
        }
        return null;
    }

}
