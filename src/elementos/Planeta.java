package elementos;

import java.awt.Color;
import java.awt.Font;
import uwcse.graphics.Oval;
import uwcse.graphics.TextShape;

/**
   un planeta es un circulo con su nombre abajo
   con los metodos poner() se le agregan detalles, hay que llamarlos
   antes de agregar el planeta a la ventana
 */
public class Planeta extends Elemento {

    private int radio;

    // crea el planeta si el nombre esta vacio no se escribe nada
    public Planeta(String nombre, int x, int y, int radio, Color color) {
        super(x, y);
        this.radio = radio;
        agregarPieza(circulo(0, 0, radio, color));
        if (nombre != null) {
            Font letra = new Font("SansSerif", Font.PLAIN, 15);
            agregarPieza(new TextShape(nombre, x - 20, y + radio + 12, Color.LIGHT_GRAY, letra));
        }
    }

    // un circulo mas grande detras para su atmosfera o aura del sol 
    public void ponerBrillo(Color color, int grosor) {
        agregarPiezaAtras(circulo(0, 0, radio + grosor, color));
    }

    // anillo plano detras del planeta para saturno
    public void ponerAnillo(Color color) {
        agregarPiezaAtras(new Oval(x - radio * 2, y - radio / 4, radio * 4, radio / 2, color, true));
    }

    // dos franjas y una mancha roja para jupiter
    public void ponerFranjas(Color franja, Color mancha) {
        agregarPieza(new Oval(x - radio * 8 / 10, y - radio / 3, radio * 16 / 10, radio / 6, franja, true));
        agregarPieza(new Oval(x - radio * 9 / 10, y + radio / 10, radio * 18 / 10, radio / 8, franja, true));
        agregarPieza(new Oval(x + radio / 5, y + radio / 3, radio / 3, radio / 5, mancha, true));
    }

    // detalles redondos verdes para la tierra, los de arriba se ven en la Tierra grande de la escena 1
    public void ponerContinentes() {
        Color verde = new Color(70, 170, 80);
        agregarPieza(new Oval(x - radio / 4, y - radio * 19 / 20, radio / 6, radio / 14, verde, true));
        agregarPieza(new Oval(x + radio / 6, y - radio * 9 / 10, radio / 5, radio / 14, verde, true));
        agregarPieza(new Oval(x - radio / 2, y - radio / 4, radio / 3, radio / 4, verde, true));
        agregarPieza(new Oval(x, y + radio / 6, radio / 3, radio / 5, verde, true));
    }

    // una luna chiquita al lado para la tierrea
    public void ponerLuna() {
        agregarPieza(circulo(radio * 17 / 10, -radio, radio / 4, Color.LIGHT_GRAY));
    }
}
