package Elementos;

import uwcse.animation.Actor;
import uwcse.animation.Stage;
import uwcse.graphics.*;
import java.awt.Image;

public class Nave extends ElementoMovil implements Actor{
    private Image[] frames = new Image[4];
    private ImageShape forma;
    private int potencia = 0;

    public Nave(GWindow ventana, int x, int y, double velX, double velY){
        super(x , y, velX, velY);
        frames[0] = ventana.getImageFromFilename("assets/naveQuieta.png");
        frames[1] = ventana.getImageFromFilename("assets/navePotencia1.png");
        frames[2] = ventana.getImageFromFilename("assets/navePotencia2.png");
        frames[3] = ventana.getImageFromFilename("assets/navePotencia3.png");
        forma = new ImageShape(frames[0], x, y);
    }

    // metodos
    public void addTo(GWindow ventana) { forma.addTo(ventana); }
    public void removeFromWindow() { forma.removeFromWindow(); }
    public void doAction(Stage s) { forma.moveBy(2 * potencia, -potencia); }


    public void setPotencia(int p){
        potencia = p;
        forma.setImage(frames[p]);
    }
}
