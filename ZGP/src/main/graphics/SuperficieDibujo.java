package main.graphics;

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
    private Teclado teclado;

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public Teclado getTeclado() {
        return teclado;
    }

    public SuperficieDibujo(final int ancho, final int alto){
        this.ancho = ancho;
        this.alto = alto;

        teclado = new Teclado();

        setIgnoreRepaint(true);
        setPreferredSize(new Dimension(ancho, alto));
        addKeyListener(teclado);
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
