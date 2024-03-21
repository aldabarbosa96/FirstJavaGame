package main.statusMachine.status.game;

import main.sprites.HojaSprites;
import main.statusMachine.EstadoJuego;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GestJuego implements EstadoJuego {
    private GestMapa gestorMapa;
    HojaSprites hs = new HojaSprites("/resources/interiortiles.png",32, true);
    @Override
    public void actualizar() {
    }

    @Override
    public void dibujar(Graphics g) {
        BufferedImage imagen = hs.getSprites(3,3).getImagen();
        g.drawImage(imagen, 100,100,null);
    }
}
