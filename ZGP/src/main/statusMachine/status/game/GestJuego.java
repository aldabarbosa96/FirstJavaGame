package main.statusMachine.status.game;

import main.control.GestControles;
import main.entity.Jugador;
import main.maps.Map;
import main.sprites.HojaSprites;
import main.statusMachine.EstadoJuego;
import main.tools.CargadorRecursos;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GestJuego implements EstadoJuego {
    Map map = new Map("/resources/text/plantillaMap.tzgp");
    Jugador jugador = new Jugador(-224,-67);
    BufferedImage logo = CargadorRecursos.cargarImgCompTranslucida("/resources/images/x_logo5.png");
    @Override
    public void actualizar() {
        jugador.actualizar();
    }
    @Override
    public void dibujar(Graphics g) {
        map.dibujar(g, (int) jugador.getPosX(), (int)jugador.getPosY());
        jugador.dibujar(g);
        g.drawImage(logo,800 - logo.getWidth()-10,600- logo.getHeight()-10,null);
        g.setColor(Color.white);
        g.drawString("X = " + jugador.getPosX(),735,20);
        g.drawString("Y = " + jugador.getPosY(),735,40);
    }
}
