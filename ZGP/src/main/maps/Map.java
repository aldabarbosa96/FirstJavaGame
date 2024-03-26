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

    private final boolean[] colisiones;
    private final int[] sprites;

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
        HojaSprites hoja = new HojaSprites("/resources/tiles/"+ hojaSeparada[0] + ".png",32,true );

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
    public void dibujar(Graphics g, int posX, int posY){
        int anchoSprite = Constantes.LADO_SPRITE;
        int altoSprite = anchoSprite;

        for (int y=0; y<this.alto;y++){
            for (int x =0; x<this.ancho;x++){
                BufferedImage imagen = paleta[sprites[x+y*this.ancho]].getImagen();
                g.drawImage(imagen,x*anchoSprite - posX,y*altoSprite-posY,null);
            }
        }
    }
}
