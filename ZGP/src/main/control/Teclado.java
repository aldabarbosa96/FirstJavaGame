package main.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {
    private final static int NUM_TECLAS = 256;
    private final boolean[] teclas = new boolean[NUM_TECLAS];
    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;
    public boolean exit;
    public boolean correr;
    public boolean saltar;

    public void actualizar(){
        arriba = teclas[KeyEvent.VK_W];
        abajo = teclas[KeyEvent.VK_S];
        izquierda = teclas[KeyEvent.VK_A];
        derecha = teclas[KeyEvent.VK_D];
        exit = teclas[KeyEvent.VK_ESCAPE];
        correr = teclas[KeyEvent.VK_SHIFT];
        saltar = teclas[KeyEvent.VK_SPACE];
    }

    @Override
    public void keyPressed(KeyEvent e) { //cualquier tecla pulsada;
        teclas[e.getKeyCode()] = true;

    }
    @Override
    public void keyReleased(KeyEvent e) { //tecla sostenida;
        teclas[e.getKeyCode()] = false;

    }
    @Override
    public void keyTyped(KeyEvent e) {
        //tecla que permite la escritura de un carácter;
    }
}


