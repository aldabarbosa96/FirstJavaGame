package main.statusMachine;

import main.statusMachine.status.game.GestJuego;

import java.awt.*;

public class GestEstado {
    private EstadoJuego[] estados;
    private EstadoJuego estadoActual;
    
    public GestEstado(){
        inicarEstados();
        inicarEstadoActual();
    }
    private void inicarEstados() {
        estados = new EstadoJuego[1];
        estados[0] = new GestJuego();
    }

    private void inicarEstadoActual() {
        estadoActual = estados[0];
    }
    public void actualizar(){
        estadoActual.actualizar();
    }
    public void dibujar(final Graphics g){
        estadoActual.dibujar(g);
    }
    public void cambiarEstadoActual(final int nuevoEstado){
        estadoActual = estados[nuevoEstado];
    }
    public EstadoJuego obtenerEstadoActual(){
        return estadoActual;
    }
}
