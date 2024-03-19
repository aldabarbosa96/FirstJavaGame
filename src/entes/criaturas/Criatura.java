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
            if (!colision(desplazamientoX,0)){
                modificarPosX(desplazamientoX);
            }
            if (!colision(0,desplazamientoY)){
                modificarPosY(desplazamientoY);
            }
        }
    }
    private boolean colision(int desplazamientoX, int desplazamientoY){
        boolean colision = false;

        int posicionX = x + desplazamientoX;
        int posicionY = y + desplazamientoY;

        int margenIzquierdo = -10;
        int margenDerecho = 20;

        int margenSuperior = -4;
        int margenInferior = 30;

        int bordeIzquierdo = (posicionX + margenDerecho) / sprites.getLado();
        int bordeDerecho = (posicionX + margenDerecho + margenIzquierdo) / sprites.getLado();

        int bordeSuperior = (posicionY + margenInferior) / sprites.getLado();
        int bordeInferior = (posicionY + margenInferior + margenSuperior) /sprites.getLado();

        if (map.getTileCatalog(bordeIzquierdo + bordeSuperior * map.getAncho()).solid()){
            colision = true;
        }
        if (map.getTileCatalog(bordeIzquierdo + bordeInferior * map.getAncho()).solid()){
            colision = true;
        }
        if (map.getTileCatalog(bordeDerecho + bordeSuperior * map.getAncho()).solid()){
            colision = true;
        }
        if (map.getTileCatalog(bordeDerecho + bordeInferior * map.getAncho()).solid()){
            colision = true;
        }

        return colision;
    }
    public Sprites getSprites(){
        return sprites;
    }
}
