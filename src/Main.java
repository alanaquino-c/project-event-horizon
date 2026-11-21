import escenas.Escena;
import escenas.EscenaAgujeroNegro;
import escenas.EscenaDespegue;
import escenas.EscenaSistemaSolar;
import java.awt.Frame;
import java.awt.Insets;
import java.util.ArrayList;
import uwcse.graphics.GWindow;
import uwcse.io.Sound;

/**
   crea la ventana y reproduce las 3 escenas en orden (unos 60 segundos)
   *ejecutar desde la carpeta del proyecto para que encuentre las imagenes*
 */
public class Main {

    // musica de fondo 
    public static final String MUSICA = "assets/sonido/interestellar.wav";

    // arma la lista de escenas, pone la música y reproduce las escenas una tras otra
    public static void main(String[] args) {
        GWindow ventana = crearVentana();
        Sound musica = new Sound(MUSICA);
        musica.loop();

        ArrayList<Escena> escenas = new ArrayList<Escena>();
        escenas.add(new EscenaDespegue());
        escenas.add(new EscenaSistemaSolar());
        escenas.add(new EscenaAgujeroNegro());

        for (int i = 0; i < escenas.size(); i++) {
            escenas.get(i).ejecutar(ventana);
        }
        musica.stop();
    }

    /**
       crea la ventana de 1280x720, en algunas computadoras la ventana se estira sola (en mi caso con linux con hyprland),
       por eso se la deja de tamaño fijo y se la vuelve a mostrar.
     */
    static GWindow crearVentana() {
        GWindow ventana = new GWindow("UENO", Escena.ANCHO, Escena.ALTO);
        ventana.setExitOnClose();
        Frame marco = Frame.getFrames()[0];
        marco.setVisible(false);
        marco.setResizable(false);
        marco.setSize(Escena.ANCHO, Escena.ALTO);
        marco.setVisible(true);
        Insets borde = marco.getInsets();
        marco.setSize(Escena.ANCHO + borde.left + borde.right, Escena.ALTO + borde.top + borde.bottom);
        return ventana;
    }
}
