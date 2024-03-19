package main.sprites;

import java.awt.image.BufferedImage;

public class Sprite {
    private final BufferedImage imagen;
    private final int ancho;
    private final int alto;

    public BufferedImage getImage(){
        return imagen;
    }
    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public Sprite(final BufferedImage imagen){
        this.imagen = imagen;

        ancho = imagen.getWidth();
        alto = imagen.getHeight();
    }
}
