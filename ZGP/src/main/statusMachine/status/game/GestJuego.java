package main.statusMachine.status.game;

import main.Constantes;
import main.control.GestControles;
import main.entity.Jugador;
import main.maps.Map;
import main.sprites.HojaSprites;
import main.statusMachine.EstadoJuego;
import main.tools.CargadorRecursos;
import main.user_interface.HUD;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GestJuego implements EstadoJuego {
    Map map = new Map(Constantes.RUTA_MAPA);
    Jugador jugador = new Jugador(160,220, map);
    BufferedImage logo = CargadorRecursos.cargarImgCompTranslucida(Constantes.RUTA_LOGO);
    @Override
    public void actualizar() {
        jugador.actualizar();
        map.actualizar((int)jugador.getPosX(),(int)jugador.getPosY());
    }
    @Override
    public void dibujar(Graphics g) {
        map.dibujar(g, (int) jugador.getPosX(), (int)jugador.getPosY());
        jugador.dibujar(g);

        g.drawImage(logo,850 - logo.getWidth()-8,450- logo.getHeight()-8,null);
        g.setColor(Color.white);
        g.drawString("X = " + jugador.getPosX(),790,20);
        g.drawString("Y = " + jugador.getPosY(),790,35);

        HUD.dibujarBarraRes(g,jugador.resistencia);
    }
}
