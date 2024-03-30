package main.entity;

import main.Constantes;
import main.control.GestControles;
import main.maps.Map;
import main.sprites.HojaSprites;
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
    private final int ANCHO_JUGADOR= 16;
    private final int ALTO_JUGADOR= 16;
    private final Rectangle LIMITE_ARRIBA = new Rectangle(Constantes.CENTRO_VENTANA_X - ANCHO_JUGADOR / 2,
            Constantes.CENTRO_VENTANA_Y, ANCHO_JUGADOR, 1);
    private final Rectangle LIMITE_ABAJO = new Rectangle(Constantes.CENTRO_VENTANA_X - ANCHO_JUGADOR / 2,
            Constantes.CENTRO_VENTANA_Y + ALTO_JUGADOR, ANCHO_JUGADOR, 1);
    private final Rectangle LIMITE_IZQUIERDA = new Rectangle(Constantes.CENTRO_VENTANA_X - ANCHO_JUGADOR / 2,
            Constantes.CENTRO_VENTANA_Y, 1, ALTO_JUGADOR);
    private final Rectangle LIMITE_DERECHA = new Rectangle(Constantes.CENTRO_VENTANA_X + ANCHO_JUGADOR / 2,
            Constantes.CENTRO_VENTANA_Y, 1, ALTO_JUGADOR);
    private int animacion;
    private int estado;
    public  int resistencia  = 300;
    private int recuperacion = 0;
    private final int RECUPERACION_MAX= 180;
    private boolean recuperado = true;
    private Map map;
    public Jugador(float posX,float posY, Map map){
        this.posX = posX;
        this.posY = posY;
        direccion = 0;
        enMovimiento = false;

        hs = new HojaSprites(Constantes.RUTA_PERSONAJE,Constantes.LADO_SPRITE,false);
        imageActual = hs.getSprites(0).getImagen();

        animacion = 0;
        estado = 0;

        this.map = map;
    }
    public void actualizar(){
        gestionVelResist();
        cambiarAnimacionEstado();
        enMovimiento = false;
        determinarDireccion();
        animar();
    }

    public void gestionVelResist(){
        if (GestControles.teclado.corriendo && resistencia > 0){
            velocidad = 2;
            recuperado = false;
            recuperacion = 0;
        } else {
            velocidad = 1;
            if (!recuperado && recuperacion < RECUPERACION_MAX){
                recuperacion++;
            }
            if (recuperacion == RECUPERACION_MAX && resistencia < 300){
                resistencia++;
            }
        }
    }
    private void cambiarAnimacionEstado(){
        if (animacion < 25){
            animacion++;
        } else {
            animacion = 0;
        }
        if (animacion < 5){
            estado = 0;
        }else if (animacion > 15){
            estado = 1;
        }else estado= 2;
    }
    private void determinarDireccion() {
        final int velocidadX = evaluarVelX();
        final int velocidadY = evaluarVelY();

        if (velocidadX == 0 && velocidadY == 0) {
            return;
        }
        if ((velocidadX != 0 && velocidadY == 0) || (velocidadX == 0 && velocidadY != 0)) {
            mover(velocidadX, velocidadY);
        } else {
            //eliminamos la posibilidad de moverse en diagonal (4 cordenadas)
            if (velocidadX == -1 && velocidadY == -1) {
                if (GestControles.teclado.izquierda.getUltimaPulsacion() > GestControles.teclado.arriba.getUltimaPulsacion()) {
                    mover(velocidadX, 0);
                } else {
                    mover(0, velocidadY);
                }
            }
            if (velocidadX == -1 && velocidadY == 1) {
                if (GestControles.teclado.izquierda.getUltimaPulsacion() > GestControles.teclado.abajo.getUltimaPulsacion()) {
                    mover(velocidadX, 0);
                } else {
                    mover(0, velocidadY);
                }
            }
            if (velocidadX == 1 && velocidadY == -1) {
                if (GestControles.teclado.derecha.getUltimaPulsacion() > GestControles.teclado.arriba.getUltimaPulsacion()) {
                    mover(velocidadX, 0);
                } else {
                    mover(0, velocidadY);
                }
            }
            if (velocidadX == 1 && velocidadY == 1){
                if (GestControles.teclado.derecha.getUltimaPulsacion() > GestControles.teclado.arriba.getUltimaPulsacion()){
                    mover(velocidadX,0);
                } else {
                    mover(0,velocidadY);
                }
            }
        }
    }
    private int evaluarVelX(){
        int velocidadX = 0;
        if (GestControles.teclado.izquierda.estaPulsada() && !GestControles.teclado.derecha.estaPulsada()){
            velocidadX = -1;
        } else if (GestControles.teclado.derecha.estaPulsada() && !GestControles.teclado.izquierda.estaPulsada()) {
            velocidadX = 1;
            
        }
        return velocidadX;
    }
    private int evaluarVelY(){
        int velocidadY = 0;
        if (GestControles.teclado.arriba.estaPulsada() && !GestControles.teclado.abajo.estaPulsada()){
            velocidadY = -1;
        } else if (GestControles.teclado.abajo.estaPulsada() && !GestControles.teclado.arriba.estaPulsada()) {
            velocidadY = 1;

        }
        return velocidadY;
    }
    private void mover(final int velocidadX, final int velocidadY){
        enMovimiento = true;

        cambiarDireccion(velocidadX,velocidadY);

        if (!fueraMap(velocidadX,velocidadY)){
            if (velocidadX == -1 && !colisionIzqueirda(velocidadX)){
                posX += velocidadX * velocidad;
                restarRes();
            }
            if (velocidadX == 1 && !colisionDerecha(velocidadX)){
                posX += velocidadX * velocidad;
                restarRes();
            }
            if (velocidadY == -1 && !colisionArriba(velocidadY)){
                posY += velocidadY * velocidad;
                restarRes();
            }
            if (velocidadY == 1 && !colisionAbajo(velocidadY)){
                posY += velocidadY * velocidad;
                restarRes();
                }
            }
        }
    private void restarRes() {
        if (GestControles.teclado.corriendo && resistencia > 0) {
            resistencia--;
        }
    }
    private boolean colisionArriba(int velY){
        for (int r = 0; r< map.areaColision.size();r++){
            final Rectangle area = map.areaColision.get(r);

            int origenX = area.x;
            int origenY = area.y + velY * (int)velocidad + 3 * (int)velocidad;

            final Rectangle areaFut = new Rectangle(origenX,origenY,Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);

            if (LIMITE_ARRIBA.intersects(areaFut)){
                return true;
            }
        }

        return false;
    }
    private boolean colisionAbajo(int velY){
        for (int r = 0; r< map.areaColision.size();r++){
            final Rectangle area = map.areaColision.get(r);

            int origenX = area.x;
            int origenY = area.y + velY * (int)velocidad - 3 * (int)velocidad;

            final Rectangle areaFut = new Rectangle(origenX,origenY,Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);

            if (LIMITE_ABAJO.intersects(areaFut)){
                return true;
            }
        }

        return false;
    }
    private boolean colisionIzqueirda(int velX){
        for (int r = 0; r< map.areaColision.size();r++){
            final Rectangle area = map.areaColision.get(r);

            int origenX = area.x + velX * (int)velocidad + 3 * (int)velocidad;
            int origenY = area.y;

            final Rectangle areaFut = new Rectangle(origenX,origenY,Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);

            if (LIMITE_IZQUIERDA.intersects(areaFut)){
                return true;
            }
        }

        return false;
    }
    private boolean colisionDerecha(int velX){
        for (int r = 0; r< map.areaColision.size();r++){
            final Rectangle area = map.areaColision.get(r);

            int origenX = area.x + velX * (int)velocidad - 3 * (int)velocidad;
            int origenY = area.y;

            final Rectangle areaFut = new Rectangle(origenX,origenY,Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);

            if (LIMITE_DERECHA.intersects(areaFut)){
                return true;
            }
        }

        return false;
    }
    private boolean fueraMap(final int velX, final int velY){
        int posFutX = (int) posX + velX * (int) velocidad;
        int posFutY = (int) posY + velY * (int) velocidad;

        final Rectangle borderMap = map.getBordes(posFutX,posFutY,ANCHO_JUGADOR,ALTO_JUGADOR);
        final boolean fuera;
        if (LIMITE_ARRIBA.intersects(borderMap) || LIMITE_ABAJO.intersects(borderMap) || LIMITE_IZQUIERDA.intersects(borderMap) ||
                LIMITE_DERECHA.intersects(borderMap)){
            fuera = false;
        }else {
            fuera = true;
        }
        return fuera;
    }

    private void cambiarDireccion (final int velocidadX, final int velocidadY){
        if (velocidadX == -1){
            direccion = 2;
        } else if (velocidadX == 1){
            direccion = 3;
        }
        if (velocidadY == -1){
            direccion = 1;
        } else if (velocidadY == 1) {
            direccion = 0;
        }

    }
    private void animar(){
        if (!enMovimiento){
            estado = 0;
            animacion = 0;
        }
        imageActual = hs.getSprites(direccion,estado).getImagen();
    }

    public void dibujar(Graphics g){
        final int centroX = Constantes.ANCHO_JUEGO / 2 - Constantes.LADO_SPRITE / 2;
        final int centroY = Constantes.ALTO_JUEGO / 2 - Constantes.LADO_SPRITE / 2;
        final int fontSize = 7;
        Font myFont = new Font("ZGP_Font", Font.PLAIN,fontSize);

        g.setColor(Color.white);
        g.drawImage(imageActual, centroX, centroY, null);
        g.setFont(myFont);
        g.drawString("STAMINA",10,430);
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
