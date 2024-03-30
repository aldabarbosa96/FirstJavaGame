package main.maps;

import main.Constantes;
import main.sprites.HojaSprites;
import main.sprites.Sprite;
import main.tools.CargadorRecursos;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Map {
    private String[] partes;
    private final int ancho;
    private final int alto;
    private final Sprite[] paleta;
    private final boolean[] colisiones;
    public ArrayList<Rectangle> areaColision = new ArrayList<Rectangle>();
    private final int[] sprites;
    private final int MARGEN_X= Constantes.ANCHO_JUEGO / 2 - Constantes.LADO_SPRITE / 2;
    private final int MARGEN_Y= Constantes.ALTO_JUEGO / 2 - Constantes.LADO_SPRITE / 2;

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public Sprite getSpritePaleta(final int indice) {
        return paleta[indice];
    }
    public Sprite getSpritePaleta(final int x, final int y) {
        return paleta[x+y*this.ancho];
    }
    public Sprite[] getPaleta(){
        return this.paleta;
    }

    public Map(final String ruta) {
        String contenido = CargadorRecursos.leerArchivoTexto(ruta);
        partes = contenido.split("\\*");

        ancho = Integer.parseInt(partes[0]);
        alto = Integer.parseInt(partes[1]);

        String hojasUsadas = partes[2];
        String[] hojaSeparada = hojasUsadas.split(",");

        String paletaEntera = partes[3];
        String[] partesPaleta = paletaEntera.split("#");

        paleta = asignarSprites(partesPaleta,hojaSeparada);

        String colisionesEnteras = partes[4];
        colisiones = extraerColisiones(colisionesEnteras);

        String spritesEnteros = partes[5];
        String[] cadenaSprites = spritesEnteros.split(" ");

        sprites = extraerSprites(cadenaSprites);
    }

    private Sprite[] asignarSprites(final String[] partesPaleta, final String[] hojaSeparada){
        Sprite[] paleta = new Sprite[partesPaleta.length];
        HojaSprites hoja = new HojaSprites("/resources/tiles/TileSheet0"+ hojaSeparada[0] + ".png",Constantes.LADO_SPRITE,false );

        for (int i=0;i<partesPaleta.length; i++){
            String spriteTemporal = partesPaleta[i];
            String[] partesSprite = spriteTemporal.split("-");

            int indicePaleta = Integer.parseInt(partesSprite[0]);
            int indiceSpriteHoja = Integer.parseInt(partesSprite[2]);

            paleta[indicePaleta] = hoja.getSprites(indiceSpriteHoja);
        }
        return paleta;
    }

    private boolean[] extraerColisiones(final String cadenaColisiones) {
        boolean[] colisiones = new boolean[cadenaColisiones.length()];
        for (int i = 0; i<cadenaColisiones.length();i++){
            if (cadenaColisiones.charAt(i) == '0'){
                colisiones[i] = false;
            }
            else {
                colisiones[i] =true;
            }
        }
        return colisiones;
    }
    private int[] extraerSprites (final String[] cadenaSprites){
        ArrayList<Integer> sprites = new ArrayList<Integer>();

        for (int i = 0; i < cadenaSprites.length; i++){
            if (cadenaSprites[i].length() == 2){
                sprites.add(Integer.parseInt(cadenaSprites[i]));
            } else {
                String uno = "";
                String dos = "";
                String error = cadenaSprites[i];

                uno += error.charAt(0);
                uno += error.charAt(1);

                dos += error.charAt(2);
                dos += error.charAt(3);

                sprites.add(Integer.parseInt(uno));
                sprites.add(Integer.parseInt(dos));
            }
        }
        int[] vectorSprites = new int[sprites.size()];

        for (int i=0; i< sprites.size(); i++){
            vectorSprites[i] = sprites.get(i);
        }
        return vectorSprites;
    }
    public void actualizar(final int posX, final int posY){
        actualizaAreasC(posX,posY);
    }
    private void actualizaAreasC(final int posX, final int posY){
        if (!areaColision.isEmpty()){
            areaColision.clear();
        }
        for (int y = 0;y<this.alto;y++){
            for (int x = 0;x<this.ancho;x++){
                int puntoX = x * Constantes.LADO_SPRITE - posX + MARGEN_X;
                int puntoY = y * Constantes.LADO_SPRITE - posY + MARGEN_Y;

                if (colisiones[x+y*this.ancho]){
                    final Rectangle rec = new Rectangle(puntoX,puntoY,Constantes.LADO_SPRITE,Constantes.LADO_SPRITE);
                    areaColision.add(rec);
                }
            }
        }
    }
    public void dibujar(Graphics g, final int posX, final int posY){
        for (int y=0; y<this.alto;y++){
            for (int x =0; x<this.ancho;x++){
                BufferedImage imagen = paleta[sprites[x+y*this.ancho]].getImagen();

                int puntoX = x * Constantes.LADO_SPRITE - posX + MARGEN_X;
                int puntoY = y * Constantes.LADO_SPRITE - posY + MARGEN_Y;

                g.drawImage(imagen,puntoX,puntoY,null);
            }
        }
    }
    public Rectangle getBordes(final int posX, final int posY, final int anchoJugador, final int altoJugador){

        int x = MARGEN_X - posX + anchoJugador;
        int y = MARGEN_Y - posY + altoJugador;
        int ancho = this.ancho * Constantes.LADO_SPRITE - anchoJugador * 2;
        int alto = this.alto * Constantes.LADO_SPRITE - altoJugador * 2;

        return new Rectangle(x,y,ancho,alto);
    }
}
