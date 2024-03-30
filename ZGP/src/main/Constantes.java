package main;

public class Constantes {
    public static final int LADO_SPRITE = 32;
    public static int ANCHO_JUEGO = 800;
    public static int ALTO_JUEGO = 480;

    public static int ANCHO_PANTALLA_COMPLETA = 2560;
    public static int ALTO_PANTALLA_COMPLETA = 1440;

    public static double FACTOR_ESCALADOX = ANCHO_PANTALLA_COMPLETA / ANCHO_JUEGO;
    public static double FACTOR_ESCALADOY = ALTO_PANTALLA_COMPLETA / ALTO_JUEGO;
    public static int CENTRO_VENTANA_X = ANCHO_JUEGO / 2;
    public static int CENTRO_VENTANA_Y = ALTO_JUEGO / 2;

    public static String RUTA_MAPA  = "/resources/map/01Map.tzgp";
    public static String RUTA_RATON  = "/resources/images/cursorMF.png";
    public static String RUTA_PERSONAJE = "/resources/tiles/characterSpriteSheet.png";
    public static String RUTA_ICONO_VENTANA = "/resources/images/x_logo4.png";
    public static String RUTA_LOGO = "/resources/images/x_logo5.png";

}
