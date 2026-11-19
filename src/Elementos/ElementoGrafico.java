package Elementos;

import uwcse.animation.Prop;
import uwcse.graphics.*;

public abstract class ElementoGrafico implements Prop{
    protected int x, y;

    // cada elemento grafico va a tener su coordenada en x e y
    public ElementoGrafico(int x, int y){
        this.x = x;
        this.y = y;
    }

    // getters y setters
    public int getX(){ return x; }
    public int getY(){ return y; }

    public void setX(int newX){ x = newX; }
    public void setY(int newY){ y = newY; }

}
