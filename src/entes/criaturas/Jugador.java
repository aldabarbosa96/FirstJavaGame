package entes.criaturas;

import controladores.Teclado;
import graphics.Pantalla;
import graphics.Sprites;

public class Jugador extends Criatura{
    private Teclado teclado;
    private int animacion;

    public Jugador(Teclado teclado, Sprites sprites){
        this.teclado = teclado;
        this.sprites = sprites;
    }
    public Jugador(Teclado teclado,Sprites sprites, int posX, int posY){
        this.teclado = teclado;
        this.sprites = sprites;
        this.x = posX;
        this.y = posY;
    }
    public void actualizar() {
        int desplazamientoX = 0;
        int desplazamientoY = 0;
        int velocidadMovimiento = 1;
        int velocidadsalto = 1;

        if (animacion < 32767) {
            animacion++;
        } else {
            animacion = 0;
        }
        if (teclado.saltar) {
            velocidadsalto = 6;
        }
        if (teclado.correr) {
            velocidadMovimiento = 2;
        }
        if (teclado.arriba) {
            desplazamientoY -= velocidadMovimiento;
            desplazamientoY -= velocidadsalto;
        }
        if (teclado.abajo) {
            desplazamientoY += velocidadMovimiento;
            desplazamientoY += velocidadsalto;
        }
        if (teclado.izquierda) {
            desplazamientoX -= velocidadMovimiento;
            desplazamientoX -= velocidadsalto;
        }
        if (teclado.derecha) {
            desplazamientoX += velocidadMovimiento;
            desplazamientoX += velocidadsalto;
        }
        if (desplazamientoX != 0 || desplazamientoY != 0) {
            mover(desplazamientoX, desplazamientoY);
            enMovimiento = true;
        } else {
            enMovimiento = false;
        }

        int resto = animacion % 40;

        if (direccion == 's') {
            sprites = Sprites.ABAJO0;
            if (enMovimiento) {
                if (animacion % 24 > 12) {
                    sprites = Sprites.ABAJO1;
                } else {
                    sprites = Sprites.ABAJO2;
                }
            }
        }
        if (direccion == 'n') {
            sprites = Sprites.ARRIBA0;
            if (enMovimiento) {
                if (resto > 10 && resto <= 20) {
                    sprites = Sprites.ARRIBA1;
                } else if (resto > 20 && resto <= 25) {
                    sprites = Sprites.ARRIBA0;
                } else if (resto > 30) {
                    sprites = Sprites.ARRIBA2;
                } else sprites = Sprites.ARRIBA0;
            }
        }

        if (direccion == 'w') {
            sprites = Sprites.IZQUIERDA0;
            if (enMovimiento) {
                if (resto > 10 && resto <= 20) {
                    sprites = Sprites.IZQUIERDA1;
                } else if (resto > 20 && resto <= 25) {
                    sprites = Sprites.IZQUIERDA0;
                } else if (resto > 30) {
                    sprites = Sprites.IZQUIERDA2;
                } else sprites = Sprites.IZQUIERDA0;
            }
        }
        if (direccion == 'e') {
            sprites = Sprites.DERECHA0;
            if (enMovimiento) {
                if (resto > 10 && resto <= 20) {
                    sprites = Sprites.DERECHA1;
                } else if (resto > 20 && resto <= 25) {
                    sprites = Sprites.DERECHA0;
                } else if (resto > 30) {
                    sprites = Sprites.DERECHA2;
                } else sprites = Sprites.DERECHA0;
            }
        }
    }
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarJugador(x,y,this);
    }
}
