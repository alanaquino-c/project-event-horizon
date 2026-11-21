package elementos;

import java.awt.Color;
import uwcse.graphics.Polygon;

/**
   la nave del boceto hecha con poligonos
   se dibuja mirando a la derecha y despues se gira con el angulo pedido
   tiene dos llamas (corta y larga) que se turnan para que parezca fuego
 */
public class Nave extends Elemento {

    private static final Color CUERPO = new Color(225, 230, 240);
    private static final Color ALETA = new Color(205, 210, 225);
    private static final Color ALA = new Color(180, 187, 204);
    private static final Color OSCURO = new Color(55, 58, 68);
    private static final Color METAL = new Color(95, 100, 112);
    private static final Color BORDE = new Color(30, 32, 42);
    private static final Color VIDRIO = new Color(40, 70, 120);
    private static final Color FUEGO = new Color(0, 190, 255);
    private static final Color INVISIBLE = new Color(0, 0, 0, 0);

    private Polygon llamaCorta;
    private Polygon llamaLarga;
    private boolean encendida = false;
    private int pasos = 0;

    // crea la nave con centro en (x, y) girada esos grados
    public Nave(int x, int y, double grados) {
        super(x, y);

        // llamas (van primero para quedar detrás de los motores)
        llamaCorta = poligono(INVISIBLE, true, new int[] {-114, -14, -144, -7, -129, 0, -144, 7, -114, 14});
        llamaLarga = poligono(INVISIBLE, true, new int[] {-114, -14, -168, -7, -141, 0, -168, 7, -114, 14});
        agregarPieza(llamaCorta);
        agregarPieza(llamaLarga);

        // motores
        parte(METAL, new int[] {-100, -11, -114, -14, -114, 0, -100, -3});
        parte(METAL, new int[] {-100, 3, -114, 0, -114, 14, -100, 11});

        // aleta de atras
        parte(ALETA, new int[] {-100, -15, -62, -15, -86, -60, -102, -60});

        // cuerpo y panza oscura
        parte(CUERPO, new int[] {-100, -15, 30, -17, 62, -16, 82, -12, 96, -7, 104, -2,
                106, 2, 100, 8, 88, 12, 60, 15, -100, 15});
        agregarPieza(poligono(OSCURO, true, new int[] {-100, 8, 70, 8, 99, 6, 100, 8, 88, 12, 60, 15, -100, 15}));

        // ventana de la cabina
        parte(VIDRIO, new int[] {58, -15, 76, -12, 85, -7, 60, -7});

        // lineas de la bodega de carga
        parte(BORDE, new int[] {-78, -8, 42, -9});
        parte(BORDE, new int[] {-40, -16, -40, 8});
        parte(BORDE, new int[] {-5, -17, -5, 8});

        // ala
        parte(ALA, new int[] {-98, 10, 20, 10, -28, 44, -92, 46});

        girar(grados);
    }

    // ademas de movers alterna la llama corta y la larga cada 6 pasos para darle la sensacion de avanzar  
    public void avanzar() {
        pasos++;
        llamaCorta.setColor(INVISIBLE);
        llamaLarga.setColor(INVISIBLE);
        if (encendida) {
            if ((pasos / 6) % 2 == 0) {
                llamaCorta.setColor(FUEGO);
            } else {
                llamaLarga.setColor(FUEGO);
            }
        }
        super.avanzar();
    }

    // prende los motores
    public void encender() {
        encendida = true;
    }

    // apaga los motores
    public void apagar() {
        encendida = false;
    }

    // agrega una pieza rellena con su borde oscuro
    private void parte(Color color, int[] puntos) {
        agregarPieza(poligono(color, true, puntos));
        agregarPieza(poligono(BORDE, false, puntos));
    }
}
