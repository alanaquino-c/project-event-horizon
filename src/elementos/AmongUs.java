package elementos;

import uwcse.graphics.GWindow;
import uwcse.graphics.ImageShape;

// un Among Us (imagen PNG sin fondo) flotando en el espacio 
public class AmongUs extends Elemento {

    // crea el amongus (x, y) es la esquina de arriba a la izquierda de la imagen
    public AmongUs(GWindow ventana, int x, int y) {
        super(x, y);
        agregarPieza(new ImageShape(ventana.getImageFromFilename("assets/image/amongus_chico.png"), x, y));
        flotar(true);
    }
}
