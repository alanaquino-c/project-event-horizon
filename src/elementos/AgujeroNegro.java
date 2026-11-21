package elementos;

import java.awt.Color;
import uwcse.graphics.Arc;

/**
   el agujero negro del boceto es el objeto complejo (9 figuras):
   un disco de 3 colores partido en dos (mitad de atrás y mitad de adelante),
   un anillo naranja y amarillo y el centro negro
 */
public class AgujeroNegro extends Elemento {

    private static final Color NARANJA = new Color(255, 90, 0);
    private static final Color AMARILLO = new Color(255, 205, 0);
    private static final Color CREMA = new Color(255, 245, 160);

    // constructor del agujero negro con centro en (x, y) y radio es el del anillo de afuera
    public AgujeroNegro(int x, int y, int radio) {
        super(x, y);
        int ancho = radio * 2;      // mitad del ancho del disco
        int alto = radio / 2;       // mitad del alto del disco

        // la mitad de arriba del disco (queda detras del anillo)
        agregarPieza(mitadDisco(ancho, alto, NARANJA, 0));
        agregarPieza(mitadDisco(ancho - 20, alto - 12, AMARILLO, 0));
        agregarPieza(mitadDisco(ancho - 40, alto - 24, CREMA, 0));

        // el anillo y centro negro
        agregarPieza(circulo(0, 0, radio, NARANJA));
        agregarPieza(circulo(0, 0, radio - 20, AMARILLO));
        agregarPieza(circulo(0, 0, radio - 40, Color.BLACK));

        // la miitad de abajo del disco (queda adelante)
        agregarPieza(mitadDisco(ancho, alto, NARANJA, 180));
        agregarPieza(mitadDisco(ancho - 20, alto - 12, AMARILLO, 180));
        agregarPieza(mitadDisco(ancho - 40, alto - 24, CREMA, 180));
    }

    // media elipse: empieza en 0 grados (mitad de arriba) o en 180 (mitad de abajo)
    private Arc mitadDisco(int ancho, int alto, Color color, int inicio) {
        return new Arc(x - ancho, y - alto, ancho * 2, alto * 2, inicio, 180, color, true);
    }
}
