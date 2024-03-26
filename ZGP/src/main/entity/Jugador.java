package main.entity;

import main.Constantes;
import main.control.GestControles;
import main.sprites.HojaSprites;
import main.sprites.Sprite;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Jugador {
    private float posX;
    private float posY;
    private int direccion;
    private double velocidad = 1;
    private boolean enMovimiento;
    private HojaSprites hs;
    private BufferedImage imageActual;
    private int animacion;
    private int estado;
    private Sprite sprite;

    public Jugador(float posX,float posY){
        this.posX = posX;
        this.posY = posY;
        direccion = 0;
        enMovimiento = false;

        hs = new HojaSprites("/resources/tiles/characterSpriteSheet.png",Constantes.LADO_SPRITE,false);
        imageActual = hs.getSprites(0).getImagen();

        animacion = 0;
        estado = 0;
    }
    public void actualizar(){
        cambiarAnimacionEstado();
        determinarDireccion();
        animar();
    }
    private void cambiarAnimacionEstado(){
    }
    private void determinarDireccion(){
        final int velocidadX = evaluarVelX();
        final int velocidadY = evaluarVelY();
    }
    private int evaluarVelX(){
        int velX = 0;
        if (GestControles.teclado.izquierda.estaPulsada() && !GestControles.teclado.derecha.estaPulsada()){
            velX = -1;
        } else if (GestControles.teclado.izquierda.estaPulsada() && !GestControles.teclado.derecha.estaPulsada()) {
            
        }
        return 0;
    }
    private int evaluarVelY(){
        return 0;
    }
    private void animar(){

    }

    public void dibujar(Graphics g){
        final int centroX = Constantes.ANCHO_PANTALLA / 2 - Constantes.LADO_SPRITE / 2;
        final int centroY = Constantes.ALTO_PANTALLA / 2 - Constantes.LADO_SPRITE / 2;

        g.setColor(Color.green);
        g.drawImage(imageActual, centroX, centroY, null);
        g.drawRect(centroX+9,centroY,13,32);

    }
    public void setPosX(float posX){
        this.posX = posX;
    }
    public void setPosY(float posY){
        this.posY = posY;
    }
    public float getPosX(){
        return posX;
    }
    public float getPosY(){
        return posY;
    }
}
