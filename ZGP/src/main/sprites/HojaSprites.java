package main.sprites;

import main.tools.CargadorRecursos;

import java.awt.image.BufferedImage;

public class HojaSprites {
    final private int anchoHojaPixeles;
    final private int altoHojaPixeles;

    final private int anchoHojaSprites;
    final private int altoHojaSprites;

    final private int anchoSprites;
    final private int altoSprites;

    final private Sprite[] sprites;

    public Sprite getSprites(final int indice) {
        return sprites[indice];
    }
    public Sprite getSprite(final int x, final int y){
        return sprites[x+y*anchoSprites];
    }

    public HojaSprites(final String ruta, final int tamañoSprites, final boolean hojaOpaca){
        final BufferedImage imagen;

        if (hojaOpaca){
            imagen = CargadorRecursos.cargarImgCompOpaca(ruta);
        }else {
            imagen = CargadorRecursos.cargarImgCompTranslucida(ruta);
        }
        anchoHojaPixeles = imagen.getWidth();
        altoHojaPixeles = imagen.getHeight();

        anchoHojaSprites = anchoHojaPixeles/tamañoSprites;
        altoHojaSprites = altoHojaPixeles/tamañoSprites;

        anchoSprites = tamañoSprites;
        altoSprites = tamañoSprites;

        sprites = new Sprite[anchoHojaSprites * altoHojaSprites];
        rellenarSpritesImagen(imagen);
    }
    public HojaSprites(final String ruta, final int anchoSprites,final int altoSprites,final boolean hojaOpaca){
        final BufferedImage imagen;

        if (hojaOpaca){
            imagen = CargadorRecursos.cargarImgCompOpaca(ruta);
        }else {
            imagen = CargadorRecursos.cargarImgCompTranslucida(ruta);
        }
        anchoHojaPixeles = imagen.getWidth();
        altoHojaPixeles = imagen.getHeight();

        anchoHojaSprites = anchoHojaPixeles/anchoSprites;
        altoHojaSprites = altoHojaPixeles/altoSprites;

        this.anchoSprites = anchoSprites;
        this.altoSprites = anchoSprites;

        sprites = new Sprite[anchoHojaSprites * altoHojaSprites];
        rellenarSpritesImagen(imagen);
    }
    private void rellenarSpritesImagen(final BufferedImage imagen){
        for (int y = 0; y < altoHojaSprites; y++){
            for (int x = 0; x < anchoHojaSprites; x++){
                final int posX = x*anchoSprites;
                final int posY = y* altoSprites;

                sprites[x+y*anchoSprites] = new Sprite(imagen.getSubimage(posX,posY,anchoSprites,altoSprites));
            }
        }
    }
}
