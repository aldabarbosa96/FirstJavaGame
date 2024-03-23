package main.statusMachine.status.game;

import main.sprites.HojaSprites;
import main.statusMachine.EstadoJuego;
import main.tools.CargadorRecursos;

import java.awt.*;

public class GestJuego implements EstadoJuego {
    private GestMapa gestorMapa;
    String texto = CargadorRecursos.leerArchivoTexto("/resources/text/prueba.tzgp");
    HojaSprites hs = new HojaSprites("/resources/tiles/interiortiles.png",32, true);
    @Override
    public void actualizar() {
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(Color.white);
       g.drawString(texto,10,10);
    }
}
