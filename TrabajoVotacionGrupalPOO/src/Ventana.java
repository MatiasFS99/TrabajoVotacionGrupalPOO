import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame{
    public Ventana(String titulo, int alto, int ancho, boolean esMain){
        super(titulo);
        setSize(ancho, alto);
        setResizable(false);
        if(esMain){
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else {
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        setIconImage(new ImageIcon("imgs\\urna.png", "urna").getImage());
    }

    public static JPanel crearPanelMedio(JLabel label,JTextField texto){
        JPanel salida = new JPanel();
        salida.setLayout(new FlowLayout());
        salida.add(label);
        salida.add(texto);
        return salida;
    }

    public static JPanel crearPanelMedio(JLabel label,JLabel label2){
        JPanel salida = new JPanel();
        salida.setLayout(new BoxLayout(salida, BoxLayout.Y_AXIS));
        salida.add(label);
        salida.add(label2);
        return salida;
    }

    public static JPanel crearPanelMedio(JButton boton){
        JPanel salida = new JPanel();
        salida.setLayout(new FlowLayout());
        salida.add(boton);
        return salida;
    }

    public static JPanel crearPanelMedio(JLabel texto){
        JPanel salida = new JPanel();
        salida.setLayout(new FlowLayout());
        salida.add(texto);
        return salida;
    }

    public static JPanel crearPanelMedio(JLabel label,JComboBox lista){
        JPanel salida = new JPanel();
        salida.setLayout(new FlowLayout());
        salida.add(label);
        salida.add(lista);
        return salida;
    }

    public static JPanel crearPanelMedio(JButton button1, JButton button2){
        JPanel salida = new JPanel();
        salida.setLayout(new FlowLayout());
        salida.add(button1);
        salida.add(Box.createHorizontalGlue());
        salida.add(button2);
        return salida;
    }

    public static JPanel crearPanelMedio(JCheckBox check,JButton boton){
        JPanel salida = new JPanel();
        salida.setLayout(new BoxLayout(salida, BoxLayout.Y_AXIS));
        salida.add(check);
        salida.add(boton);
        return salida;
    }

    public static JPanel crearPanelMedio(JList lista){
        JPanel salida = new JPanel(new FlowLayout());
        salida.add(lista);
        return salida;
    }
}
