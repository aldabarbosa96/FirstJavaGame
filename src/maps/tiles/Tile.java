package maps.tiles;

import graphics.Pantalla;
import graphics.Sprites;

public class Tile {
    public int x;
    public int y;
    public Sprites sprites;
    private boolean solid;
    public static final int LADO = 32;
    public static final Tile VACIO = new Tile(Sprites.VACIO,true);
    public static final Tile LADRILLO0 =new Tile(Sprites.LADRILLO0, true);
    public static final Tile LADRILLO1 =new Tile(Sprites.LADRILLO1,true);
    public static final Tile LADRILLO1_FLIPPED =new Tile(Sprites.LADRILLO1_FLIPPED,true);
    public static final Tile LADRILLO_CARTEL =new Tile(Sprites.LADRILLO_CARTEL,true);
    public static final Tile LADRILLO_VENTANAS =new Tile(Sprites.LADRILLO_VENTANAS,true);
    public static final Tile LADRILLO_VENTANASX =new Tile(Sprites.LADRILLO_VENTANASX,true);
    public static final Tile LADRILLO_SEÑAL =new Tile(Sprites.LADRILLO_SEÑAL,true);
    public static final Tile LADRILLO_VENTANA =new Tile(Sprites.LADRILLO_VENTANA,true);
    public static final Tile PARED =new Tile(Sprites.PARED,true);
    public static final Tile PARED_BORDES =new Tile(Sprites.PARED_BORDES,true);
    public static final Tile PARED_BORDE_IZQUIERDA =new Tile(Sprites.PARED_BORDE_IZQUIERDA,true);
    public static final Tile PARED_BORDE_DERECHA =new Tile(Sprites.PARED_BORDE_DERECHA,true);
    public static final Tile PARED_CARTEL =new Tile(Sprites.PARED_CARTEL,true);
    public static final Tile PARED_LUZ =new Tile(Sprites.PARED_LUZ,true);
    public static final Tile PARED_LUZ_DERECHA =new Tile(Sprites.PARED_LUZ_DERECHA,true);
    public static final Tile PARED_LUZ_IZQUIERDA =new Tile(Sprites.PARED_LUZ_IZQUIERDA,true);
    public static final Tile PARED_EXTINTOR =new Tile(Sprites.PARED_EXTINTOR,true);
    public static final Tile PARED_EXTINTOR_BORDE =new Tile(Sprites.PARED_EXTINTOR_BORDE,true);
    public static final Tile PARED_VENTANA =new Tile(Sprites.PARED_VENTANA,true);
    public static final Tile PARED_VENTANAX =new Tile(Sprites.PARED_VENTANAX,true);
    public static final Tile SUELO =new Tile(Sprites.SUELO);
    public static final Tile SUELO_RAYA_VD =new Tile(Sprites.SUELO_RAYA_VD);
    public static final Tile SUELO_RAYA_HA  =new Tile(Sprites.SUELO_RAYA_HA);
    public static final Tile SUELO_RAYA_VI  =new Tile(Sprites.SUELO_RAYA_VI);
    public static final Tile SUELO_RAYA_HAB  =new Tile(Sprites.SUELO_RAYA_HAB);
    public static final Tile SUELO_RAYAE_HA  =new Tile(Sprites.SUELO_RAYAE_HA);
    public static final Tile SUELO_RAYAE_HAX  =new Tile(Sprites.SUELO_RAYAE_HAX);
    public static final Tile SUELO_RAYAE_VI  =new Tile(Sprites.SUELO_RAYAE_VI);
    public static final Tile SUELO_RAYAE_HAB  =new Tile(Sprites.SUELO_RAYAE_HAB);
    public static final Tile SUELO_RAYAE_VD  =new Tile(Sprites.SUELO_RAYAE_VD);
    public static final Tile SUELO_RAYA90  =new Tile(Sprites.SUELO_RAYA90);
    public static final Tile SUELO_RAYA90X  =new Tile(Sprites.SUELO_RAYA90X);
    public static final Tile SUELO_RAYA90Y  =new Tile(Sprites.SUELO_RAYA90Y);
    public static final Tile SUELO_RAYA90XY  =new Tile(Sprites.SUELO_RAYA90XY);
    public static final Tile SUELO_ESQUINA  =new Tile(Sprites.SUELO_ESQUINA);
    public static final Tile SUELO_ESQUINA_IAB  =new Tile(Sprites.SUELO_ESQUINA_IAB);
    public static final Tile SUELO_ESQUINA_DAR  =new Tile(Sprites.SUELO_ESQUINA_DAR);
    public static final Tile SUELO_ESQUINA_DAB  =new Tile(Sprites.SUELO_ESQUINA_DAB);
    public static final Tile SUELO_RAYA_ROJA  =new Tile(Sprites.SUELO_RAYA_ROJA);
    public static final Tile SUELO_RAYA_AMARILLA  =new Tile(Sprites.SUELO_RAYA_AMARILLA);
    public static final Tile SUELO_RAYA_ROJAC  =new Tile(Sprites.SUELO_RAYA_ROJAC);
    public static final Tile SUELO_RAYA_ROJACY  =new Tile(Sprites.SUELO_RAYA_ROJACY);
    public static final Tile SUELO_SOMBRA  =new Tile(Sprites.SUELO_SOMBRA);
    public static final Tile PUERTA  =new Tile(Sprites.PUERTA,true);
    public static final Tile PUERTA_ROJA  =new Tile(Sprites.PUERTA_ROJA,true);
    public static final Tile ASCENSOR  =new Tile(Sprites.ASCENSOR,true);
    public static final Tile PUERTA_GRIS  =new Tile(Sprites.PUERTA_GRIS,true);
    public static final Tile PUERTA_SEGURIDAD  =new Tile(Sprites.PUERTA_SEGURIDAD,true);
    public static final Tile PUERTA_BLANCA  =new Tile(Sprites.PUERTA_BLANCA,true);
    public static final Tile PUERTA_FIRE1  =new Tile(Sprites.PUERTA_FIRE1,true);
    public static final Tile PUERTA_FIRE2  =new Tile(Sprites.PUERTA_FIRE2,true);
    /*
    public static final Tile ASFALTO0 = new Tile(Sprites.ASFALTO0);
    public static final Tile ASFALTO1 = new Tile(Sprites.ASFALTO1);
    public static final Tile ASFALTO_WHITELINES_H = new Tile(Sprites.ASFALTO0_WHITELINE_H);
    public static final Tile ASFALTO_WHITELINES_V = new Tile(Sprites.ASFALTO0_WHITELINE_V);
    public static final Tile ARENA0 = new Tile(Sprites.ARENA0);
    public static final Tile ARENA1 = new Tile(Sprites.ARENA1);
    public static final Tile ARENA2 = new Tile(Sprites.ARENA2);
    public static final Tile OXIDO0 = new Tile(Sprites.OXIDO0);
    public static final Tile OXIDO1 = new Tile(Sprites.OXIDO1);
    public static final Tile GRAVA0 = new Tile(Sprites.GRAVA0);
    public static final Tile GRAVA1 = new Tile(Sprites.GRAVA1);
    public static final Tile HIERBA0 = new Tile(Sprites.HIERBA0);
    public static final Tile HIERBA1 = new Tile(Sprites.HIERBA1);
    public static final Tile ARBOL0 = new Tile(Sprites.ARBOL0);
    public static final Tile ARBOL1 = new Tile(Sprites.ARBOL1);
    public static final Tile ARBOL0_SIN_HOJAS0 = new Tile(Sprites.ARBOL0_SIN_HOJAS0);
    public static final Tile ARBOL0_SIN_HOJAS1 = new Tile(Sprites.ARBOL0_SIN_HOJAS1);
    public static final Tile WHITEFLOOR = new Tile(Sprites.WHITEFLOOR);
    public static final Tile WHITE = new Tile(Sprites.WHITE);
*/
    public Tile(Sprites sprites){
        this.sprites = sprites;
        solid = false;
    }
    public Tile(Sprites sprites, boolean solid){
        this.sprites = sprites;
        this.solid = solid;
    }
    public void mostrar(int x, int y, Pantalla pantalla){
        pantalla.mostrarTile(x << 5, y << 5, this);
    }
    public boolean solid(){
        return solid;
    }
}
