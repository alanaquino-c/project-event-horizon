package elementos;

import java.awt.Color;
import java.util.ArrayList;
import uwcse.graphics.GWindow;
import uwcse.graphics.Oval;
import uwcse.graphics.Polygon;
import uwcse.graphics.Shape;

/**
   elemento es la clase padre de todos los objetos de la animacion
   un elemento es una lista de figuras (piezas) que se mueven juntas
   la primera pieza que se agrega queda al fondo
 */
public abstract class Elemento {

    // centro del elemento
    protected int x;
    protected int y;

    // 
    private int velocidadX = 0;
    private int velocidadY = 0;
    private boolean flotando = false;
    private int pasos = 0;
    private ArrayList<Shape> piezas = new ArrayList<Shape>();

    // crea el elemento con su centro en (x, y)
    public Elemento(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // agrega una figura al elemento (adelante de las otras)
    protected void agregarPieza(Shape pieza) {
        piezas.add(pieza);
    }

    // agrega una figura detras de todas las otras
    protected void agregarPiezaAtras(Shape pieza) {
        piezas.add(0, pieza);
    }

    // recorre la lista de piezas y dibuja todas las piezas en la ventana
    public void agregarA(GWindow ventana) {
        for (int i = 0; i < piezas.size(); i++) {
            ventana.add(piezas.get(i));
        }
    }

    // cambia cuantos pixeles se mueve en cada paso osea la velocidad con la que se mueve
    public void setVelocidad(int velocidadX, int velocidadY) {
        this.velocidadX = velocidadX;
        this.velocidadY = velocidadY;
    }

    // si flota, el elemento sube y baja despacito (esto me sirve para la animacion de la nave)
    public void flotar(boolean flotando) {
        this.flotando = flotando;
    }

    // un paso de la animacion, se mueve segun su velocidad (y flota si hace falta)
    public void avanzar() {
        pasos++;
        if (flotando && pasos % 4 == 0) {
            if ((pasos / 60) % 2 == 0) {
                moverPor(0, 1);
            } else {
                moverPor(0, -1);
            }
        }
        moverPor(velocidadX, velocidadY);
    }

    // mueve todas las piezas con moveBy
    public void moverPor(int dx, int dy) {
        x =+ dx;
        y =+ dy;
        for (int i = 0; i < piezas.size(); i++) {
            piezas.get(i).moveBy(dx, dy);
        }
    }

    // gira el elemento sobre su centro (positivo: antihorario), slo gira los polígonos
    public void girar(double grados) {
        for (int i = 0; i < piezas.size(); i++) {
            piezas.get(i).rotateAround(x, y, grados);
        }
    }

    // crea un círculo (dx, dy) es la distancia desde el centro del elemento
    protected Oval circulo(int dx, int dy, int radio, Color color) {
        return new Oval(x + dx - radio, y + dy - radio, radio * 2, radio * 2, color, true);
    }

    // crea un poligono los puntos son {x1, y1, x2, y2, ...} medidos desde el centro
    protected Polygon poligono(Color color, boolean relleno, int[] puntos) {
        Polygon p = new Polygon(color, relleno);
        for (int i = 0; i < puntos.length; i = i + 2) {
            p.addPoint(x + puntos[i], y + puntos[i + 1]);
        }
        return p;
    }
}
