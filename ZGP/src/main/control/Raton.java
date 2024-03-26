package main.control;

import main.tools.CargadorRecursos;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Raton {
    private final Cursor cursor;

    public Raton(){
        Toolkit config = Toolkit.getDefaultToolkit();

        BufferedImage icon = CargadorRecursos.cargarImgCompTranslucida("/resources/images/cursorMF.png");

        Point punta = new Point(0,8);

        this.cursor = config.createCustomCursor(icon,punta,"Cursor pistola");
    }
    public Cursor getCursor(){
        return this.cursor;
    }
}
