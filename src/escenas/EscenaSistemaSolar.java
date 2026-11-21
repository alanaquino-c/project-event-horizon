package escenas;

import elementos.Nave;
import elementos.Planeta;
import elementos.AmongUs;
import java.awt.Color;

   //escena 2: la nave cruza el sistema solar, los planetas pasan de derecha a izquierda
public class EscenaSistemaSolar extends Escena {

    private static final int ARRIBA = 175;
    private static final int ABAJO = 550;

    private Nave nave;

    // crea el sol, los 8 planetas, el among us y la nave
    protected void montar() {
        ponerFondo("fondo_espacio.png");

        Planeta sol = new Planeta("Sol", 760, -60, 210, new Color(255, 190, 40));
        sol.ponerBrillo(new Color(255, 120, 0), 30);
        Planeta tierra = new Planeta("Tierra", 1880, ABAJO, 46, new Color(40, 110, 210));
        tierra.ponerContinentes();
        tierra.ponerLuna();
        Planeta jupiter = new Planeta("Júpiter", 2400, ABAJO + 5, 115, new Color(215, 165, 115));
        jupiter.ponerFranjas(new Color(170, 115, 75), new Color(190, 90, 60));
        Planeta saturno = new Planeta("Saturno", 2700, ARRIBA, 70, new Color(230, 200, 130));
        saturno.ponerAnillo(new Color(205, 170, 105));

        Planeta[] planetas = new Planeta[9];
        planetas[0] = sol;
        planetas[1] = new Planeta("Mercurio", 1400, ABAJO - 10, 22, Color.GRAY);
        planetas[2] = new Planeta("Venus", 1640, ARRIBA, 42, new Color(235, 205, 140));
        planetas[3] = tierra;
        planetas[4] = new Planeta("Marte", 2110, ARRIBA, 32, new Color(200, 85, 55));
        planetas[5] = jupiter;
        planetas[6] = saturno;
        planetas[7] = new Planeta("Urano", 2980, ABAJO + 10, 55, new Color(160, 225, 235));
        planetas[8] = new Planeta("Neptuno", 3230, ARRIBA, 52, new Color(60, 90, 220));
        for (int i = 0; i < planetas.length; i++) {
            planetas[i].setVelocidad(-4, 0);
            agregarMovil(planetas[i]);
        }

        // among us sus
        AmongUs tripulante = new AmongUs(ventana, 2215, 205);
        tripulante.setVelocidad(-4, 0);
        agregarMovil(tripulante);

        nave = new Nave(-220, 360, 0);
        nave.encender();
        nave.setVelocidad(4, 0);
        agregarMovil(nave);
    }

    // La nave entra, se queda flotando en el medio y los planetas siguen pasando
    protected void reproducir() {
        animar(150);
        nave.setVelocidad(0, 0);
        nave.flotar(true);
        animar(700);
    }
}
