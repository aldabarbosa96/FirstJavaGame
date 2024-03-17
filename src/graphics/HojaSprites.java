package graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class HojaSprites {
    private final int ancho;
    public int getAncho() {
        return ancho;
    }
    private final int alto;
    public final int[] pixeles;
    public static HojaSprites desierto = new HojaSprites("/graphics/sprites/tiles0.png", 320,320);
    public static HojaSprites laboratorio = new HojaSprites("/graphics/sprites/interiortiles.png", 320,320);
    public static HojaSprites jugador = new HojaSprites("/graphics/sprites/characterSpriteSheet2.png", 320,320);
    public HojaSprites(final String ruta, final int ancho, final int alto){
        this.ancho = ancho;
        this.alto = alto;

        pixeles = new int[ancho * alto];

        BufferedImage imagen;
        try {
            imagen = ImageIO.read(HojaSprites.class.getResource(ruta));
            imagen.getRGB(0,0,ancho,alto,pixeles,0,ancho);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
