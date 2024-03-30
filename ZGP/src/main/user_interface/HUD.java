package main.user_interface;

import java.awt.*;

public class HUD {
    public static void dibujarBarraRes(Graphics g, int resistencia){
        int ancho = 110 * resistencia / 300;
        Color rojoOscuro = new Color(153,0,0);

        g.setColor(Color.gray);
        g.fillRect(10,435,110,5);

        g.setColor(Color.white);
        g.drawRect(9,434,111,6);

        g.setColor(Color.red);
        g.fillRect(10,435,ancho,4);

        g.setColor(rojoOscuro);
        g.fillRect(10,437,ancho,3);
    }
}
