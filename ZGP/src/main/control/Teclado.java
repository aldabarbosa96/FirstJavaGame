package main.control;

import main.statusMachine.EstadoJuego;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {
    public Tecla arriba = new Tecla();
    public Tecla abajo = new Tecla();
    public Tecla izquierda = new Tecla();
    public Tecla derecha = new Tecla();
    public boolean corriendo = false;

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
            case KeyEvent.VK_SHIFT:
                corriendo = true;
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
            case KeyEvent.VK_SHIFT:
                corriendo = false;
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
        }
    }
    public void keyTyped (KeyEvent e){  //tecla tippeable
    }
}


