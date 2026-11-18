package Elementos;

public abstract class ElementoGrafico {
    protected double x, y;

    // cada elemento grafico va a tener su coordenada en x e y
    public ElementoGrafico(double x, double y){
        this.x = x;
        this.y = y;
    }

    // metodos
    // cada objeto se va a dibujar diferente por eso definimos como abstract
    public abstract void dibujar();

    // getters y setters
    public double getX(){ return x; }
    public double getY(){ return y; }

    public void setX(int newX){ x = newX; }
    public void setY(int newY){ y = newY; }

}
