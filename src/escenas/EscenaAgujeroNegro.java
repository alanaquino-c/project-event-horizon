package escenas;

import elementos.AgujeroNegro;
import elementos.Nave;
import uwcse.graphics.Rectangle;
import java.awt.Color;

// escena 3: la nave llega al agujero negro (boceto), lo mira y termina
public class EscenaAgujeroNegro extends Escena {

    private Nave nave;

    // fondo de estrellas, el agujero negro fijo y la nave afuera de la pantalla
    protected void montar() {
        ponerFondo("fondo_espacio.png");
        agregar(new AgujeroNegro(908, 267, 200));
        nave = new Nave(-225, 803, 20);
        nave.encender();
        nave.setVelocidad(2, -1);
        agregarMovil(nave);
    }

    // la nave llega, frena, flota mirando el agujero negro, apaga motores y fin
    protected void reproducir() {
        animar(203);
        nave.setVelocidad(1, 0);
        animar(20);
        nave.setVelocidad(0, 0);
        nave.flotar(true);
        animar(120);
        nave.apagar();
        animar(110);

        ventana.add(new Rectangle(0, 0, ANCHO, ALTO, Color.BLACK, true));
        texto("FIN", 590, 320, 60);
        animar(100);
    }
}
