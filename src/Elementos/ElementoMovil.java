package Elementos;

public abstract class ElementoMovil extends ElementoGrafico{
    
    // nuevos atributos para hacer avanzar a los objetos
    protected double velX, velY;
    
    public ElementoMovil(double x, double y, double velX, double velY){
        super(x,y);
        this.velX = velX;
        this.velY = velY;
    }

    //metodos
    public void mover(){
        x += velX;
        y += velY;
    }

    public void dibujar(){

    }

    // getters y setters
    public double getVelX(){ return velX; }
    public double getVelY(){ return velY; }

    public void setVelX(double newVelX){ velX = newVelX; }
    public void setVelY(double newVelY){ velY = newVelY; }
    
}
