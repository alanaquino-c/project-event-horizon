package elementos;

import java.awt.Color;
import uwcse.graphics.Oval;
import uwcse.graphics.Rectangle;

// la plataforma de despegue de la escena 1: base, torre roja con una luz y humo que aparece al despegar
public class Plataforma extends Elemento {

    private static final Color HUMO = new Color(205, 205, 210);
    private static final Color INVISIBLE = new Color(0, 0, 0, 0);

    private Oval[] nubes = new Oval[4];

    // crea la plataforma; (x, y) es el centro de la base
    public Plataforma(int x, int y) {
        super(x, y);
        Color gris = new Color(70, 72, 80);

        // torre con brazos y luz roja
        agregarPieza(new Rectangle(x + 58, y - 250, 24, 244, new Color(150, 45, 40), true));
        agregarPieza(new Rectangle(x + 20, y - 175, 38, 6, gris, true));
        agregarPieza(new Rectangle(x + 20, y - 120, 38, 6, gris, true));
        agregarPieza(circulo(70, -258, 7, Color.RED));

        // base
        agregarPieza(new Rectangle(x - 95, y - 10, 190, 16, gris, true));

        // humo (empieza invisible)
        nubes[0] = circulo(-50, -5, 32, INVISIBLE);
        nubes[1] = circulo(50, -5, 32, INVISIBLE);
        nubes[2] = circulo(-110, 2, 42, INVISIBLE);
        nubes[3] = circulo(110, 2, 42, INVISIBLE);
        for (int i = 0; i < nubes.length; i++) {
            agregarPieza(nubes[i]);
        }
    }

    // hace aparecer el humo
    public void echarHumo() {
        for (int i = 0; i < nubes.length; i++) {
            nubes[i].setColor(HUMO);
        }
    }
}
