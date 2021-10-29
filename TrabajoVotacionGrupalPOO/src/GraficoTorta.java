import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.text.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.*;

//basado en codigo de https://www.roseindia.net/java/example/java/swing/draw-pie-chart.shtml
/**
 *
 * Nombre de clase: GraficoTorta
 *
 * Genera un componente que es un grafico de torta con porcentajes y etiquetas
 *
 * @version: 28/10/2021/A
 *
 * @autores: Caraballo Ian, Craco Ivan, Serantes Matias
 *
 */

public class GraficoTorta extends JPanel
{
    private BufferedImage image;
    private final int PAD = 30;
    private Font font;
    private NumberFormat numberFormat;
    private Double[] marks = null;
    private String[] names = null;

    /**
     * crea un grafico de torta con los datos pasados como (partido,cantidadDeVotos) sacando el porcentaje
     * @param lista Lista de datos a sacar porcentaje y graficar
     */
    public GraficoTorta(Map<PartidoPoliticoAlianza,Double> lista)
    {
        List<String> nombres = new ArrayList<String>();
        List<Double> datos = new ArrayList<Double>();
        PartidoPoliticoAlianza tmpartido = null;
        Iterator<PartidoPoliticoAlianza> it = lista.keySet().iterator();
        while(it.hasNext()){
            tmpartido = it.next();
            if(lista.get(tmpartido)>0){
                nombres.add(tmpartido.getNombre());
                datos.add(lista.get(tmpartido));
            }
        }
        //es necesario para convertir de list a array
        Double[] arrayCarga = new Double[datos.size()];
        int count = 0;
        for (Double i : datos) {
            arrayCarga[count] = i;
            count++;
        }

        String[] cargaNombres = new String[nombres.size()];
        count=0;
        for (String i : nombres) {
            cargaNombres[count] = i;
            count++;
        }
        this.names = cargaNombres;
        this.marks = arrayCarga;

        font = new Font("Book Antiqua", Font.BOLD, 20);
        numberFormat = NumberFormat.getPercentInstance();
        addComponentListener(new ComponentAdapter()
        {});
    }

    /**
     * Genera un grafico de torta con los datos ingresados y lo devuelve como componente
     * @param nombres Array con las etiquetas a usar
     * @param datos Array con los datos de las etiquetas con los que se calculara el porcentaje
     */
    public GraficoTorta(String[] nombres, int[] datos)
    {
        List<String> TmpNombres = new ArrayList<String>();
        List<Integer> TmpDatos = new ArrayList<Integer>();
        for (String string : nombres) {
            TmpNombres.add(string);
        }
        int i = 0;
        for (int dat : datos) {
            if(dat>0){
                TmpDatos.add(dat);
            }else{
                TmpNombres.remove(i);
            }
            i++;
        }
        String[] salidaNombres = new String[TmpNombres.size()];
        i=0;
        for (String string : TmpNombres) {
            salidaNombres[i]= string;
            i++;
        }
        Double[] salidaDatos = new Double[TmpDatos.size()];
        i=0;
        for (int dat : TmpDatos) {
            salidaDatos[i]= Double.valueOf(dat);
            i++;
        }
        this.names = salidaNombres;
        this.marks = salidaDatos;
        font = new Font("Book Antiqua", Font.BOLD, 20);
        numberFormat = NumberFormat.getPercentInstance();
        addComponentListener(new ComponentAdapter()
        {});
    }

    /**
     * Genera un grafico de torta con los datos ingresados y lo devuelve como componente
     * @param nombres Array con las etiquetas a usar
     * @param datos Array con los datos de las etiquetas con los que se calculara el porcentaje
     */
    public GraficoTorta(String[] nombres, Double[] datos)
    {
        List<String> TmpNombres = new ArrayList<String>();
        List<Double> TmpDatos = new ArrayList<Double>();
        for (String string : nombres) {
            TmpNombres.add(string);
        }
        int i = 0;
        for (Double dat : datos) {
            if(dat>0){
                TmpDatos.add(dat);
            }else{
                TmpNombres.remove(i);
                i--;
            }
            i++;
        }
        String[] salidaNombres = new String[TmpNombres.size()];
        i=0;
        for (String string : TmpNombres) {
            salidaNombres[i]= string;
            i++;
        }
        Double[] salidaDatos = new Double[TmpDatos.size()];
        i=0;
        for (Double dat : TmpDatos) {
            salidaDatos[i]= dat;
            i++;
        }
        this.names = salidaNombres;
        this.marks = salidaDatos;
        font = new Font("Book Antiqua", Font.BOLD, 20);
        numberFormat = NumberFormat.getPercentInstance();
        addComponentListener(new ComponentAdapter()
        {});
    }

    /**
     * Aplica los cambios al componente
     */
    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        Graphics2D graphics2d = (Graphics2D)graphics;
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        createChartImage();
        graphics2d.drawImage(image, 0, 0, this);
    }
    /**
     * Calcula los datos y genera la imagen del grafico de torta
     */
    private void createChartImage()
    {
        int width = getWidth();
        int height = getHeight();
        int cp = width/2;
        int cq = height/2;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        g2.setPaint(Color.lightGray);
        g2.fillRect(0, 0, width, height);
        g2.setPaint(Color.black);
        int pie = Math.min(width,height) - 2*PAD;
        g2.draw(new Ellipse2D.Double(cp - pie/2, cq - pie/2, pie, pie));
        double total = 0;
        for(int j = 0; j < marks.length; j++)
            total += marks[j];
        double theta = 0, phi = 0;
        double p, q;
        for(int j = 0; j < marks.length; j++)
        {
            p = cp + (pie/2) * Math.cos(theta);
            q = cq + (pie/2) * Math.sin(theta);
            g2.draw(new Line2D.Double(cp, cq, p, q));
            phi = (marks[j]/total) * 2 * Math.PI;
            p = cp + (9*pie/24) * Math.cos(theta + phi/2);
            q = cq + (9*pie/24) * Math.sin(theta + phi/2);
            g2.setFont(font);
            String st = names[j];
            FontRenderContext frc = g2.getFontRenderContext();
            float textWidth = (float)font.getStringBounds(st, frc).getWidth();
            LineMetrics lm = font.getLineMetrics(st, frc);
            float sp = (float)(p - textWidth/2);
            float sq = (float)(q + lm.getAscent()/2);
            g2.drawString(st, sp, sq);
            p = cp + (pie/2 + 4*PAD/5) * Math.cos(theta + phi/2);
            q = cq + (pie/2 + 4*PAD/5) * Math.sin(theta+ phi/2);
            st = numberFormat.format(marks[j]/total);
            textWidth = (float)font.getStringBounds(st, frc).getWidth();
            lm = font.getLineMetrics(st, frc);
            sp = (float)(p - textWidth/2);
            sq = (float)(q + lm.getAscent()/2);
            g2.drawString(st, sp, sq);
            theta += phi;
        }
        g2.dispose();
    }
}
