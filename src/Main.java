import uwcse.graphics.*;
import java.awt.Color;

import Escenas.Escena1;

public class Main{
    public static void main(String[] args){
        GWindow ventana = new GWindow(1280, 720);
        Escena1 e1 = new Escena1(ventana);

        ventana.setExitOnClose();
    }
}