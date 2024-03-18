package maps;

import maps.tiles.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LoadedMap extends Map{
    private int[] pixeles;
    public LoadedMap(String ruta) {
        super(ruta);
    }
    protected void loadMap(String ruta){
        try {
            BufferedImage imagen = ImageIO.read(LoadedMap.class.getResource(ruta));

            ancho = imagen.getWidth();
            alto = imagen.getHeight();

            tilesCatalog = new Tile[ancho*alto];
            pixeles = new int[ancho*alto];
            imagen.getRGB(0,0,ancho,alto,pixeles,0,ancho);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void generateMap(){
        for (int i = 0; i < pixeles.length; i++){
            switch (pixeles[i]){
                case 0xFF1A1A1A:
                    tilesCatalog[i] = Tile.LADRILLO0;
                    continue;
                case 0xFF000000:
                    tilesCatalog[i] = Tile.LADRILLO1;
                    continue;
                case 0xFFECE6E6:
                    tilesCatalog[i] = Tile.LADRILLO1_FLIPPED;
                    continue;
                case 0xFFFF6B97:
                    tilesCatalog[i] = Tile.LADRILLO_CARTEL;
                    continue;
                case 0xFF2C5E42:
                    tilesCatalog[i] = Tile.LADRILLO_VENTANAS;
                    continue;
                case 0xFF178F4B:
                    tilesCatalog[i] = Tile.LADRILLO_VENTANASX;
                    continue;
                case 0xFF470C0C:
                    tilesCatalog[i] = Tile.LADRILLO_SEÑAL;
                    continue;
                case 0xFFF2A65E:
                    tilesCatalog[i] = Tile.PARED;
                    continue;
                case 0xFFF2E972:
                    tilesCatalog[i] = Tile.PARED_BORDES;
                    continue;
                case 0xFF66FFE3:
                    tilesCatalog[i] = Tile.PARED_BORDE_DERECHA;
                    continue;
                case 0xFFBA615F:
                    tilesCatalog[i] = Tile.PARED_BORDE_IZQUIERDA;
                    continue;
                case 0xFFEB564B:
                    tilesCatalog[i] = Tile.PARED_CARTEL;
                    continue;
                case 0xFFC2C2D1:
                    tilesCatalog[i] = Tile.PARED_LUZ;
                    continue;
                case 0xFF606070:
                    tilesCatalog[i] = Tile.PARED_LUZ_DERECHA;
                    continue;
                case 0xFF3CA370:
                    tilesCatalog[i] = Tile.PARED_LUZ_IZQUIERDA;
                    continue;
                case 0xFFFF34B1:
                    tilesCatalog [i] = Tile.PARED_EXTINTOR;
                    continue;
                case 0xFFDAF242:
                    tilesCatalog[i] = Tile.PARED_EXTINTOR_BORDE;
                    continue;
                case 0xFFFFB5B5:
                    tilesCatalog[i] = Tile.SUELO;
                    continue;
                case 0xFF4DA6FF:
                    tilesCatalog[i] = Tile.SUELO_RAYA_VD;
                    continue;
                case 0xFF5A265E:
                    tilesCatalog[i] = Tile.SUELO_RAYA_HA;
                    continue;
                case 0xFF473B78:
                    tilesCatalog[i] = Tile.SUELO_RAYA_VI;
                    continue;
                case 0xFF422445:
                    tilesCatalog[i] = Tile.SUELO_RAYA_HAB;
                    continue;
                case 0xFFFFFFFF:
                    tilesCatalog[i] = Tile.SUELO_RAYAE_HA;
                    continue;
                case 0xFF1B8C07:
                    tilesCatalog[i] = Tile.SUELO_RAYAE_HAX;
                    continue;
                case 0xFFFFFFEB:
                    tilesCatalog[i] = Tile.SUELO_RAYAE_VI;
                    continue;
                case 0xFFA4A42A:
                    tilesCatalog[i] = Tile.SUELO_RAYAE_HAB;
                    continue;
                case 0xFF656538:
                    tilesCatalog[i] = Tile.SUELO_RAYAE_VD;
                    continue;
                case 0xFF777704:
                    tilesCatalog[i] = Tile.SUELO_RAYA90;
                    continue;
                case 0xFF520478:
                    tilesCatalog[i] = Tile.SUELO_RAYA90X;
                    continue;
                case 0xFF9B55BE:
                    tilesCatalog[i] = Tile.SUELO_RAYA90Y;
                    continue;
                case 0xFFB74F6B:
                    tilesCatalog[i] = Tile.SUELO_RAYA90XY;
                    continue;
                case 0xFF6F2C3E:
                    tilesCatalog[i] = Tile.SUELO_ESQUINA;
                    continue;
                case 0xFFD45577:
                    tilesCatalog[i] = Tile.SUELO_ESQUINA_IAB;
                    continue;
                case 0xFF55D4AC:
                    tilesCatalog[i] = Tile.SUELO_ESQUINA_DAR;
                    continue;
                case 0xFF3B7362:
                    tilesCatalog[i] = Tile.SUELO_ESQUINA_DAB;
                    continue;
                case 0xFF43733B:
                    tilesCatalog [i] = Tile.SUELO_RAYA_ROJA;
                    continue;
                case 0xFFFFE600:
                    tilesCatalog[i] = Tile.SUELO_RAYA_AMARILLA;
                    continue;
                case 0xFF1A5135:
                    tilesCatalog[i] = Tile.SUELO_RAYA_ROJAC;
                    continue;
                case 0xFF1C38C8:
                    tilesCatalog[i] = Tile.SUELO_SOMBRA;
                    continue;
                case 0xFF5EA851:
                    tilesCatalog [i] = Tile.PUERTA;
                    continue;
                case 0xFF4C6557:
                    tilesCatalog[i] = Tile.PUERTA_ROJA;
                    continue;
                case 0xFFFA622A:
                    tilesCatalog[i] = Tile.ASCENSOR;
                    continue;
                case 0xFF432955:
                    tilesCatalog[i] = Tile.PUERTA_GRIS;
                    continue;
                case 0xFF900000:
                    tilesCatalog[i] = Tile.PUERTA_SEGURIDAD;
                    continue;
                case 0xFF672C95:
                    tilesCatalog[i] = Tile.PUERTA_BLANCA;
                    continue;
                case 0xFF279314:
                    tilesCatalog[i] = Tile.PUERTA_FIRE1;
                    continue;
                case 0xFF104307:
                    tilesCatalog[i] = Tile.PUERTA_FIRE2;
                    continue;
                default:
                    tilesCatalog[i] = Tile.VACIO;
            }
        }
    }
}
