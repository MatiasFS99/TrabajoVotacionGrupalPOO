import java.awt.event.*;
import javax.swing.*;

/**

 * Nombre de clase: Manejador Main 

 * Esta clase controla que exista el dni ingresado en la ventana de usuario
 
 * y en caso de que el mismo existe le da la ventana para realizar su voto

 * si el dni no existe en el padron o ya voto le advertira al usuario

 * @version: 28/10/2021/A

 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias

 */
public class ManejadorMain implements ActionListener {
    private JTextField dni;

    /**
     * Asigna el dni ingresado a un private
     * @param dni dni ingresado
     */
    public ManejadorMain(JTextField dni) {
        this.dni = dni;
    }

    /**
     * controla los datos ingresados y abre una ventana para dar la opcion de voto o dar error
     */
    public void actionPerformed(ActionEvent e) {
        try{
            if(Main.Abierto){
                String strdni = dni.getText().replace(".", "");
                int respuesta = VotoElectronico.ComprobarDatos(Integer.parseInt(strdni));
                if(respuesta == 1){

                    new VentanaVotacion((VotoElectronico.getPersonaActual(Integer.parseInt(strdni))));
                } else {
                    if(respuesta == 2){
                        JOptionPane.showMessageDialog(null,"' Dni: '" + strdni +"' Ya voto");
                    } else {
                        if(respuesta == 3)JOptionPane.showMessageDialog(null,"' Dni: '" + strdni +"' No existe en el padron");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null,"Las Elecciones ya cerraron");
            }
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(null,"por favor revise los datos ingresados");
        }
    }
}
