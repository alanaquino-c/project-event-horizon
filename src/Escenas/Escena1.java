package Escenas;
import Elementos.AgujeroNegro;
import Elementos.Nave;
import uwcse.graphics.*;
import java.awt.Color;

public class Escena1 {
    
    public Escena1 (GWindow ventana){
        Rectangle fondoNegro = new Rectangle(0, 0, ventana.getWindowWidth(), ventana.getWindowHeight(), Color.BLACK, true);
        fondoNegro.addTo(ventana);

        AgujeroNegro agujeroNegro = new AgujeroNegro(749, 200, 200);
        agujeroNegro.addTo(ventana);
        
        Nave nave = new Nave(ventana, 0, 478, 0, 0);
        nave.addTo(ventana);
        
    }
}
