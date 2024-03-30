package main.control;

import main.Constantes;
import main.graphics.SuperficieDibujo;
import main.tools.CargadorRecursos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;

public class Raton extends MouseAdapter {
    private final Cursor cursor;
    private Point position;

    public Raton(final SuperficieDibujo sd){
        Toolkit config = Toolkit.getDefaultToolkit();

        BufferedImage icon = CargadorRecursos.cargarImgCompTranslucida(Constantes.RUTA_RATON);

        Point punta = new Point(0,8);

        this.cursor = config.createCustomCursor(icon,punta,"Cursor FK U");

        position = new Point();
        actualizarPos(sd);
    }
    public void actualizar(final SuperficieDibujo sd){
        actualizarPos(sd);
    }
    public void dibujar(Graphics g){
        g.setColor(Color.red);

        g.drawString("RX: "+position.getX(),790,50);
        g.drawString("RY: "+position.getY(),790,65);

    }
    public Cursor getCursor(){
        return this.cursor;
    }

    private void actualizarPos(final SuperficieDibujo sd){
        final Point posicionInicial = MouseInfo.getPointerInfo().getLocation();

        SwingUtilities.convertPointFromScreen(posicionInicial, sd);

        position.setLocation(posicionInicial.getX(), posicionInicial.getY());
    }
}
