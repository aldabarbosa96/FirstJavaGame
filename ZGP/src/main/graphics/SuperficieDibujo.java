package main.graphics;

import main.Constantes;
import main.GestPrincipal;
import main.control.GestControles;
import main.control.Raton;
import main.control.Teclado;
import main.statusMachine.GestEstado;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class SuperficieDibujo extends Canvas {
    public static final long serialVersionUID = 2L;

    private int ancho;
    private int alto;
    private Raton raton;
    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public SuperficieDibujo(final int ancho, final int alto){
        this.ancho = ancho;
        this.alto = alto;

        this.raton = new Raton(this);

        setIgnoreRepaint(true);
        setCursor(raton.getCursor());
        setPreferredSize(new Dimension(ancho, alto));
        addKeyListener(GestControles.teclado);
        setFocusable(true);
        requestFocus();
    }
    public void actualizar(){
        raton.actualizar(this);
    }
    public void dibujar(final GestEstado ge){
        final BufferStrategy buffer = getBufferStrategy();

        if (buffer == null){
            createBufferStrategy(4);
            return;
        }
        final Graphics2D g = (Graphics2D) buffer.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0,0,Constantes.ANCHO_PANTALLA_COMPLETA,Constantes.ALTO_PANTALLA_COMPLETA);

        if (Constantes.FACTOR_ESCALADOX != 1.0 || Constantes.FACTOR_ESCALADOY != 1.0) {
            g.scale(Constantes.FACTOR_ESCALADOX, Constantes.FACTOR_ESCALADOY);
        }

        ge.dibujar(g);

        g.setColor(Color.white);
        g.drawString("FPS: "+ GestPrincipal.getFps(), 5,20);
        g.drawString("APS: "+ GestPrincipal.getAps(), 5,35);
        raton.dibujar(g);


        Toolkit.getDefaultToolkit().sync();

        g.dispose();

        buffer.show();
    }
}
