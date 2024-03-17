package entes.criaturas;

import entes.Ente;
import graphics.Sprites;

public abstract class Criatura extends Ente {
    protected Sprites sprites;
    protected char direccion = 'n';
    protected boolean enMovimiento = false;

    public void actualizar(){
    }
    public void mostrar(){
    }
    public void mover(int desplazamientoX, int desplazamientoY){
        if (desplazamientoX > 0){
            direccion = 'e';
        }
        if (desplazamientoX < 0){
            direccion = 'w';
        }
        if (desplazamientoY > 0){
            direccion = 's';
        }
        if (desplazamientoY < 0){
            direccion = 'n';
        }
        if (!estaEliminado()){
            modificarPosX(desplazamientoX);
            modificarPosY(desplazamientoY);
        }
    }
    private boolean colision(){
        return false;
    }
    public Sprites getSprites(){
        return sprites;
    }
}
