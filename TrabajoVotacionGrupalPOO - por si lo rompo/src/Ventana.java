/**
 * Nombre de clase:  Ventana
 * Clase de ayuda para generar ventanas de manera mas amigable
 * y crear subpaneles para usar en ventanas
 * @version: 22/09/2016/A
 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias
 */

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame{
	 /**

     * funcion estatica para la inclusion de listas
     * @param titulo Es el titulo que tendra la ventana
     * @param alto el alto en pixeles que tendra la ventana
     * @param ancho el ancho en pixeles que tendra la ventana
     * @param esMain en caso de verdadero al cerrar la ventana se cierran todas y se termina el programa,
     *  de lo contrario se puede cerrar sin que afecte a las demas
     */
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

    /**
     * Acomodador de etiqueta+caja de texto
     * @param label ingresa un etiquete para la caja de texto
     * @param texto Ingresa una caja de texto
     * @return devuelve un panel con la el label del lado derecho de la caja
     */
    public static JPanel crearPanelMedio(JLabel label,JTextField texto){
        JPanel salida = new JPanel();
        salida.setLayout(new FlowLayout());
        salida.add(label);
        salida.add(texto);
        return salida;
    }

    /**
     * Acomodador de dos etiquetas lateralmente
     * @param label etiqueta centrada a la izquierda
     * @param label2 etiqueta centrada a la izquierda
     * @return devuelve un panel con las dos etiquetas acomodadas
     */
    public static JPanel crearPanelMedio(JLabel label,JLabel label2){
        JPanel salida = new JPanel();
        salida.setLayout(new BoxLayout(salida, BoxLayout.Y_AXIS));
        salida.add(label);
        salida.add(label2);
        return salida;
    }

    /**
     * Centra un boton en el medio de la pantalla
     * @param boton Boton centrado
     * @return Devuelve un panel con el boton centrado
     */
    public static JPanel crearPanelMedio(JButton boton){
        JPanel salida = new JPanel();
        salida.setLayout(new FlowLayout());
        salida.add(boton);
        return salida;
    }

    /**
     * Centra una etiqueta en el medio de la pantalla
     * @param texto etiqueta a centrar
     * @return Devuelve un panel con la etiqueta centrada
     */
    public static JPanel crearPanelMedio(JLabel texto){
        JPanel salida = new JPanel();
        salida.setLayout(new FlowLayout());
        salida.add(texto);
        return salida;
    }

    /**
     * Acomodador de etiqueta+caja de seleccion
     * @param label Etiqueta del selector
     * @param lista Caja de seleccion
     * @return Devuelve un panel con la etiqueta a la derecha y la caja de seleccion a la izquierda
     */
    public static JPanel crearPanelMedio(JLabel label,JComboBox lista){
        JPanel salida = new JPanel();
        salida.setLayout(new FlowLayout());
        salida.add(label);
        salida.add(lista);
        return salida;
    }
    
    /**
     * Acomodador de etiqueta+caja de seleccion+boton
     * @param label Etiqueta del selector
     * @param lista Caja de seleccion
     * @param boton Boton
     * @return Devuelve un panel con la etiqueta a la derecha,seguido de la caja de seleccion y por ultimo el boton ordenados horizontalmente
     */
    public static JPanel crearPanelMedio(JLabel label,JComboBox lista,JButton boton){
        JPanel salida = new JPanel();
        salida.setLayout(new FlowLayout());
        salida.add(label);
        salida.add(lista);
        salida.add(boton);
        return salida;
    }

    /**
     * Acomoda dos paneles uno al lado del otro separados en el medio
     * @param button1 Boton derecha
     * @param button2 Boton izquierda
     * @return Devuelve un panel con los dos botones acomodados horizontalmente
     */
    public static JPanel crearPanelMedio(JButton button1, JButton button2){
        JPanel salida = new JPanel();
        salida.setLayout(new FlowLayout());
        salida.add(button1);
        salida.add(Box.createHorizontalGlue());
        salida.add(button2);
        return salida;
    }

    /**
     * Acomoda centrado un checkBox y un boton uno arriba del otro
     * @param check El checkBox
     * @param boton El Boton
     * @return Devuelve un panel con las partes acomodas
     */
    public static JPanel crearPanelMedio(JCheckBox check,JButton boton){
        JPanel salida = new JPanel();
        salida.setLayout(new BoxLayout(salida, BoxLayout.Y_AXIS));
        salida.add(check);
        salida.add(boton);
        return salida;
    }
    
    /**
     * Crea un panel con una lista centrada horizontalmente en el medio
     * @param lista Lista a centrar
     * @return Devuelve un panel con las listas acomodadas
     */

    public static JPanel crearPanelMedio(JList lista){
        JPanel salida = new JPanel(new FlowLayout());
        salida.add(lista);
        return salida;
    }
}
