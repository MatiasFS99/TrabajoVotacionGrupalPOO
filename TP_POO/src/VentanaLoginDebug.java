import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class VentanaLoginDebug {
    private int intentos = 3;
    public VentanaLoginDebug(){
        
        Ventana v = new Ventana("Inicio Administrador", 600, 600, false);
        Container cp = v.getContentPane();
        cp.setLayout(new BorderLayout());
        JLabel titulo = new JLabel("Administrador De Sistema Unico de Voto Electronico");
        titulo.setHorizontalAlignment((cp.getWidth()/2)-(titulo.getWidth()/2));
        titulo.setFont(Main.ftitulo);
        
        JLabel subtitulo = new JLabel("Inicio sesion admin");
        subtitulo.setFont(subtitulo.getFont().deriveFont(Main.subrrayado));
        JLabel labUser = new JLabel("Usuario:");
        JTextField user = new JTextField(20);
        JLabel labPassword = new JLabel("Password:");
        JPasswordField password = new JPasswordField(20);
        JButton entrar = new JButton("Entrar");
        JButton cancelar = new JButton("Cancelar");
        entrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                if(!user.getText().equals("") && !String.valueOf(password.getPassword()).equals("")){
                    try{
                        if(comprobarCredenciales(PassHash(user.getText()), PassHash(String.valueOf(password.getPassword())))){
                            new VentanaMainAdmin();
                            v.dispose();
                        } else {
                            intentos -= 1;
                            if(intentos>0){
                                JOptionPane.showMessageDialog(null,"credenciales incorrectas, le restan "+intentos+" antes de que se cierre la ventana");
                            } else {
                                JOptionPane.showMessageDialog(null,"credenciales incorrectas, ya no le restan intentos");
                                v.dispose();
                            }
                        }
                    } catch (Exception error){
                        System.out.println("si llego aca algo esta mal con el mundo");
                        System.out.println(error);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"llene los dos espacios");
                }
            }
        });
        cancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                v.dispose();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Ventana.crearPanelMedio(subtitulo));
        panel.add(Ventana.crearPanelMedio(labUser, user));
        panel.add(Ventana.crearPanelMedio(labPassword, password));
        panel.add(Ventana.crearPanelMedio(cancelar, entrar));
        cp.add(titulo,BorderLayout.NORTH);
        cp.add(panel, BorderLayout.CENTER);
        v.setVisible(true);
        Point moverventana = v.getLocationOnScreen();
        moverventana.translate(600, 0);
        v.setLocation(moverventana);
    }

    public static String PassHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException{
        String strSalt = "@_M(FbH_H[m24!qU";
        byte[] salt = strSalt.getBytes();
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = f.generateSecret(spec).getEncoded();
        Base64.Encoder enc = Base64.getEncoder();
        return enc.encodeToString(hash);
    }

    public boolean comprobarCredenciales(String user, String pass){
        return user.equals("pLb/0OEQpTniwgBxZ/i3gQ==") && pass.equals("SaGF+LYHTTIksZj+8Cio2A==");
    }
}
