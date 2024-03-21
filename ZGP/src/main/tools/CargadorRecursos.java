package main.tools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CargadorRecursos {
    public static BufferedImage cargarImgCompOpaca(final String ruta){
        Image imagen = null;
        try {
            imagen = ImageIO.read(CargadorRecursos.class.getResourceAsStream(ruta));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice().getDefaultConfiguration();

        BufferedImage imagenAcelerada = gc.createCompatibleImage(imagen.getWidth(null), imagen.getHeight(null),Transparency.OPAQUE);
        Graphics g = imagenAcelerada.getGraphics();
        g.drawImage(imagen,0,0,null);
        g.dispose();

        return imagenAcelerada;
    }
    public static BufferedImage cargarImgCompTranslucida(final String ruta){
        Image imagen = null;
        try {
            imagen = ImageIO.read(ClassLoader.class.getResource(ruta));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice().getDefaultConfiguration();

        BufferedImage imagenAcelerada = gc.createCompatibleImage(imagen.getWidth(null), imagen.getHeight(null),Transparency.TRANSLUCENT);
        Graphics g = imagenAcelerada.getGraphics();
        g.drawImage(imagen,0,0,null);
        g.dispose();

        return imagenAcelerada;
    }
}
