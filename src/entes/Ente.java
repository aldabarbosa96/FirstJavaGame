package entes;

import maps.Map;

public abstract class Ente {
    protected int x;
    protected int y;
    private boolean eliminado = false;

    protected Map map;

    public void actualizar(){
    }
    public void mostrar(){
    }
    public void eliminar(){
        eliminado = true;
    }
    public int getPosX(){
        return x;
    }
    public int getPosY(){
        return y;
    }
    public void modificarPosX(int desplazamientoX){
        x += desplazamientoX;
    }
    public void modificarPosY(int desplazamientoY){
        y += desplazamientoY;
    }
    public boolean estaEliminado(){
        return eliminado;
    }
}
