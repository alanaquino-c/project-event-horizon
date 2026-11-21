package escenas;

import elementos.Nave;
import elementos.Planeta;
import elementos.Plataforma;
import java.awt.Color;
import uwcse.graphics.TextShape;

// escena 1: cuenta regresiva y la nave despega de la iterra
public class EscenaDespegue extends Escena {

    private Planeta tierra;
    private Plataforma plataforma;
    private Nave nave;

    // fondo de cielo, la tierra grande abajo, la plataforma y la nave parada (mirando arriba)
    protected void montar() {
        ponerFondo("fondo_atmosfera.png");
        tierra = new Planeta(null, 640, 1700, 1150, new Color(40, 110, 210));
        tierra.ponerBrillo(new Color(90, 150, 230), 20);
        tierra.ponerContinentes();
        plataforma = new Plataforma(520, 556);
        nave = new Nave(520, 432, 90);
        agregarMovil(tierra);
        agregarMovil(plataforma);
        agregarMovil(nave);
    }

    // cuenta 3, 2, 1, la nave tiembla, sube, gira hacia la derecha y se va
    protected void reproducir() {
        animar(140);

        TextShape cuenta = texto("3", 615, 70, 90);
        animar(33);
        cuenta.setText("2");
        nave.encender();
        animar(33);
        cuenta.setText("1");
        plataforma.echarHumo();
        animar(33);
        cuenta.setText("¡DESPEGUE!");
        cuenta.moveBy(-215, 0);

        // tiembla (se mueve a un lado y al otro)
        for (int i = 0; i < 40; i++) {
            if (i % 2 == 0) {
                nave.setVelocidad(2, 0);
            } else {
                nave.setVelocidad(-2, 0);
            }
            animar(1);
        }

        // sube despacio y el suelo baja 
        nave.setVelocidad(0, -1);
        bajarSuelo(2);
        animar(75);
        ventana.remove(cuenta);

        // gira de a poco hacia la derecha
        for (int i = 0; i < 110; i++) {
            nave.girar(-0.55);
            nave.setVelocidad(1 + i / 40, -1);
            bajarSuelo(6);
            animar(1);
        }

        // sale rapido
        nave.setVelocidad(10, -5);
        animar(70);
    }

    // mueve la tierra y la plataforma hacia abajo
    private void bajarSuelo(int velocidad) {
        tierra.setVelocidad(0, velocidad);
        plataforma.setVelocidad(0, velocidad);
    }
}
