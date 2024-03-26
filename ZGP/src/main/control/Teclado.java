package main.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {
    public Tecla arriba = new Tecla();
    public Tecla abajo = new Tecla();
    public Tecla izquierda = new Tecla();
    public Tecla derecha = new Tecla();

    public void keyPressed(KeyEvent e) { //cualquier tecla pulsada;
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                arriba.teclaPulsada();
                break;
            case KeyEvent.VK_S:
                abajo.teclaPulsada();
                break;
            case KeyEvent.VK_A:
                izquierda.teclaPulsada();
                break;
            case KeyEvent.VK_D:
                derecha.teclaPulsada();
                break;
        }
    }
    public void keyReleased(KeyEvent e) { //tecla sostenida;
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                arriba.teclaSoltada();
                break;
            case KeyEvent.VK_S:
                abajo.teclaSoltada();
                break;
            case KeyEvent.VK_A:
                izquierda.teclaSoltada();
                break;
            case KeyEvent.VK_D:
                derecha.teclaSoltada();
                break;
        }
    }
    public void keyTyped (KeyEvent e){
    }
}


