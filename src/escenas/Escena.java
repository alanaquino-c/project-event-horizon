package escenas;

import elementos.Elemento;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import uwcse.graphics.GWindow;
import uwcse.graphics.ImageShape;
import uwcse.graphics.TextShape;

/**
   clase padre de las escenas, cada escena hija arma sus objetos en montar()
   y cuenta la animación en reproducir().
 */
public abstract class Escena {

    public static final int ANCHO = 1280;
    public static final int ALTO = 720;
    public static final int PAUSA = 30;   // milisegundos entre cuadro y cuadro

    protected GWindow ventana;
    private ArrayList<Elemento> moviles = new ArrayList<Elemento>();

    // crea los objetos de la escena y los agrega a la ventana
    protected abstract void montar();

    // la animacion de la escena
    protected abstract void reproducir();

    // borra lo anterior, arma la escena y la reproduce
    public void ejecutar(GWindow ventana) {
        this.ventana = ventana;
        ventana.suspendRepaints();   // para que no se vea como se arma
        ventana.erase();
        montar();
        reproducir();
    }

    // pone una imagen PNG de fondo (esta en assets/image) 
    protected void ponerFondo(String archivo) {
        ventana.add(new ImageShape(ventana.getImageFromFilename("assets/image/" + archivo), 0, 0));
    }

    // agrega un elemento estatico
    protected void agregar(Elemento elemento) {
        elemento.agregarA(ventana);
    }

    // agrega un elemento movil
    protected void agregarMovil(Elemento elemento) {
        elemento.agregarA(ventana);
        moviles.add(elemento);
    }

    // escribe un texto blanco en la ventana y lo devuelve para poder cambiarlo
    protected TextShape texto(String mensaje, int x, int y, int tamano) {
        TextShape t = new TextShape(mensaje, x, y, Color.WHITE, new Font("SansSerif", Font.BOLD, tamano));
        ventana.add(t);
        return t;
    }

    // reproduce cuadros: en cada uno todos los objetos moviles avanzan un paso y se hace una pausa
    protected void animar(int cuadros) {
        for (int i = 0; i < cuadros; i++) {
            ventana.suspendRepaints();
            for (int j = 0; j < moviles.size(); j++) {
                moviles.get(j).avanzar();
            }
            ventana.resumeRepaints();
            pausar(PAUSA);
        }
    }

    // detiene el programa unos milisegundos con sleep()
    protected void pausar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            // no pasa nada si se interrumpe la pausa
        }
    }
}
