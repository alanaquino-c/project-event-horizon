package Elementos;

import uwcse.graphics.*;
import java.awt.Color;
import java.util.ArrayList;

public class AgujeroNegro extends ElementoGrafico {
    // colores del boceto 
    private static final Color NARANJA = new Color(255, 90, 0);
    private static final Color AMARILLO = new Color(255, 204, 0);
    private static final Color CREMA = new Color(255, 244, 163);

    // guarda todas las formas del agujero en el orden que hay que pintarlas 
    private ArrayList<Shape> formas = new ArrayList<Shape>();
    private int radio;
    private double inclinacion = 10;   // grados que va a girar el circulo

    // cx, cy = centro del agujero
    public AgujeroNegro(int cx, int cy, int radio) {
        super(cx, cy);
        this.radio = radio;

        // capa de pintuars 
        agregarDisco(0, 180);      // mitad de atrás
        agregarAnillo();           // círculos del agujero
        agregarDisco(180, 360);    // mitad de adelante
    }

    private void agregarDisco(int desde, int hasta) {
        Color[] colores = {NARANJA, AMARILLO, CREMA};
        double[] escalas = {1.0, 0.92, 0.85}; // escala para que cada ovalo sea mas chico y funcionen de discos
        for (int i = 0; i < 3; i++) {
            
            // las medidas del ovalo: 2.15 y 0.57 son proporciones del radio sacadas del boceto en Figma (que tambien me da las coordenadas)
            // el disco es 2.15 veces más ancho que el radio del agujero y 0.57 veces de alto.

            double rx = radio * 2.15 * escalas[i];
            double ry = radio * 0.57 * escalas[i];
            formas.add(semiElipse(rx, ry, desde, hasta, colores[i]));
        }
    }

    // crea los 3 círculos concentricos naranja, amarillo y negro en el centro
    private void agregarAnillo() {
        Color[] colores = {NARANJA, AMARILLO, Color.BLACK};
        double[] escalas = {1.0, 0.9, 0.8};
        for (int i = 0; i < 3; i++) {
            int r = (int) (radio * escalas[i]);
            // Oval pide la esquina superior izquierda, no el centro entonces por eso se resta el radio y el ancho y alto son el diametro
            // 
            formas.add(new Oval((int) x - r, (int) y - r, 2 * r, 2 * r, colores[i], true));
        }
    }

    private Polygon semiElipse(double radioHorizontal, double radioVertical, int anguloInicial, int anguloFinal, Color c) {

        // arma un Polygon con forma de pedazo de ovalo y lo inclina. El poligono se forma con muchos puntos en fila
        // el for va a ir recorriendo de 3 en 3 grados el borde del ovalo y vamos a ir poniendo los puntos del poligono 

        // mas o menos como un tiro parabolico y el vector de velocidad es lo que vamos a usar como punto para el poligono, mientras mas inclinado mas notorio van a ser los puntos del poligono
        Polygon poligono = new Polygon(c, true);
        // las fuinciones de Math.cos y Math.sin trbajan en radianes asi que convertimos primero
        double inc = Math.toRadians(inclinacion);
        for (int angulo = anguloInicial; angulo <= anguloFinal; angulo += 3) {
            double xSinGirar = radioHorizontal * Math.cos(Math.toRadians(angulo));
            double ySinGirar = -radioVertical * Math.sin(Math.toRadians(angulo));   // la y crece hacia abajo
            int xFinal = (int) Math.round(x + xSinGirar * Math.cos(inc) + ySinGirar * Math.sin(inc));
            int yFinal = (int) Math.round(y - xSinGirar * Math.sin(inc) + ySinGirar * Math.cos(inc));
            poligono.addPoint(xFinal, yFinal);
        }
        return poligono;
    }

    public void addTo(GWindow ventana) {
        for (int i = 0; i < formas.size(); i++) {
            formas.get(i).addTo(ventana);   // se agregan en el mismo orden
        }
    }

    public void removeFromWindow() {
        for (int i = 0; i < formas.size(); i++) {
            formas.get(i).removeFromWindow();
        }
    }
}