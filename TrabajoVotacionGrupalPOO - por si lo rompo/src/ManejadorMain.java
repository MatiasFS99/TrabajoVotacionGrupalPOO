import java.awt.event.*;
import javax.swing.*;
public class ManejadorMain implements ActionListener {
    private JTextField dni;

    public ManejadorMain(JTextField dni) {
        this.dni = dni;
    }

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
