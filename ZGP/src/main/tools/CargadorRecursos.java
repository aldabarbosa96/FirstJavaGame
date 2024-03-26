package main.tools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CargadorRecursos {
    public static BufferedImage cargarImgCompOpaca(final String ruta) {
        Image imagen = null;
        try {
            imagen = ImageIO.read(CargadorRecursos.class.getResourceAsStream(ruta));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice().getDefaultConfiguration();

        BufferedImage imagenAcelerada = gc.createCompatibleImage(imagen.getWidth(null), imagen.getHeight(null), Transparency.OPAQUE);
        Graphics g = imagenAcelerada.getGraphics();
        g.drawImage(imagen, 0, 0, null);
        g.dispose();

        return imagenAcelerada;
    }

    public static BufferedImage cargarImgCompTranslucida(final String ruta) {
        Image imagen = null;
        try {
            imagen = ImageIO.read(CargadorRecursos.class.getResourceAsStream(ruta));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice().getDefaultConfiguration();

        BufferedImage imagenAcelerada = gc.createCompatibleImage(imagen.getWidth(null), imagen.getHeight(null), Transparency.TRANSLUCENT);
        Graphics g = imagenAcelerada.getGraphics();
        g.drawImage(imagen, 0, 0, null);
        g.dispose();

        return imagenAcelerada;
    }

    public static String leerArchivoTexto(final String ruta) {
        String contenido = "";

        // Cambio a CargadorRecursos.class para buscar relativo a esta clase.
        InputStream entradaBytes = CargadorRecursos.class.getResourceAsStream(ruta);
        if (entradaBytes == null) {
            throw new RuntimeException("El recurso " + ruta + " no se pudo encontrar.");
        }

        try (BufferedReader lector = new BufferedReader(new InputStreamReader(entradaBytes))) {
            String line;
            while ((line = lector.readLine()) != null) {
                contenido += line; // Agrega salto de línea para preservar el formato del texto.
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contenido;
    }
}

