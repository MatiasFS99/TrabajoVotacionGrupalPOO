import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Nombre de clase:  VentanaTerminarAdmin
 * Genera una ventana con chequeo de seguridad para finalizar las elecciones
 * @version: 28/10/2021/A
 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias
 */

public class VentanaTerminarAdmin {
	/**
	 * Abre un login y pide confirmacion del administrador para finalizar las elecciones
	 */
    public VentanaTerminarAdmin(){
        Ventana v = new Ventana("Terminar Elecciones", 600, 600, false);
        Container cp = v.getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        JLabel subtitulo = new JLabel("Inicio sesion admin");
        subtitulo.setFont(subtitulo.getFont().deriveFont(Main.subrrayado));
        JLabel labUser = new JLabel("Usuario:");
        JTextField user = new JTextField(20);
        JLabel labPassword = new JLabel("Password:");
        JPasswordField password = new JPasswordField(20);
        JButton entrar = new JButton("Entrar");
        JButton cancelar = new JButton("Cancelar");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Ventana.crearPanelMedio(subtitulo));
        panel.add(Ventana.crearPanelMedio(labUser, user));
        panel.add(Ventana.crearPanelMedio(labPassword, password));
        panel.add(Ventana.crearPanelMedio(cancelar, entrar));
        cp.add(panel);
        v.setVisible(true);
        cancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                v.dispose();
            }
        });
        entrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int intentos = 3;
                try{
                    if(VentanaLoginDebug.comprobarCredenciales(VentanaLoginDebug.PassHash(user.getText()), VentanaLoginDebug.PassHash(String.valueOf(password.getPassword())))){
                        int reply = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea terminar las elecciones?", "Advertencia", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                        if(reply==JOptionPane.YES_OPTION){
                            int reply2 = JOptionPane.showConfirmDialog(null, "Repito, esta seguro? no se podran volver a abrir luego", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                            if(reply2==JOptionPane.YES_OPTION){
                                Main.Abierto = false;
                                JOptionPane.showMessageDialog(null,"Elecciones terminadas");
                                new VentanaResultadosFinales();
                                v.dispose();
                            }else{
                                v.dispose();
                            }
                        } else {
                            v.dispose();
                        }
                    } else {
                        intentos -= 1;
                            if(intentos>0){
                                JOptionPane.showMessageDialog(null,"credenciales incorrectas, le restan "+intentos+" antes de que se cierre la ventana");
                            } else {
                                JOptionPane.showMessageDialog(null,"credenciales incorrectas, ya no le restan intentos");
                                v.dispose();
                            }
                    }
                } catch ( Exception err){

                }
            }
        });
    }
}
