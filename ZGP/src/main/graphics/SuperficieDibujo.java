package main.graphics;

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

        this.raton = new Raton();

        setIgnoreRepaint(true);
        setCursor(raton.getCursor());
        setPreferredSize(new Dimension(ancho, alto));
        addKeyListener(GestControles.teclado);
        setFocusable(true);
        requestFocus();
    }
    public void dibujar(final GestEstado ge){
        BufferStrategy buffer = getBufferStrategy();

        if (buffer == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = buffer.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0,0,ancho,alto);

        ge.dibujar(g);

        Toolkit.getDefaultToolkit().sync();

        g.dispose();

        buffer.show();
    }
}
