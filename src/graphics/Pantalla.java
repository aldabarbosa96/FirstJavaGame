package graphics;

import entes.criaturas.Jugador;
import maps.tiles.Tile;

public final class Pantalla {
    private final int ancho;
    private final int alto;
    private int diferenciaX;
    private int diferenciaY;

    public final int[] pixeles;
    //temporary variables

    public Pantalla(final int ancho, final int alto){
        this.ancho=ancho;
        this.alto=alto;
        pixeles = new int[ancho*alto];
    }
    public void limpiar(){
        for (int i=0;i<pixeles.length;i++){
            pixeles[i] = 0;
        }
    }
    public void mostrarTile(int compX, int compY, Tile tile){
        compX -= diferenciaX;
        compY -= diferenciaY;

        for (int y=0; y<tile.sprites.getLado();y++){
            int posY = y + compY;
            for (int x=0;x<tile.sprites.getLado();x++){
                int posX = x + compX;
                if (posX < -tile.sprites.getLado() || posX >= ancho || posY < 0 || posY >= alto){
                    break;
                }
                if (posX < 0) posX = 0;
                pixeles[posX + posY * ancho] = tile.sprites.pixeles[x + y * tile.sprites.getLado()];
            }
        }
    }
    public void mostrarJugador(int compX, int compY, Jugador jugador){
        compX -= diferenciaX;
        compY -= diferenciaY;

        for (int y=0; y<jugador.getSprites().getLado();y++){
            int posY = y + compY;
            for (int x=0;x<jugador.getSprites().getLado();x++){
                int posX = x + compX;
                if (posX < -jugador.getSprites().getLado() || posX >= ancho || posY < 0 || posY >= alto){
                    break;
                }
                if (posX < 0) posX = 0;
                //pixeles[posX + posY * ancho] = jugador.getSprites().pixeles[x + y * jugador.getSprites().getLado()];
                int colorPixelJugador = jugador.getSprites().pixeles[x+y*jugador.getSprites().getLado()];
                if (colorPixelJugador != 0xffff00ff){
                    pixeles[posX + posY * ancho] = colorPixelJugador;
                }
            }
        }
    }

    public void setDiferencia(final int diferenciaX, final int diferenciaY){
        this.diferenciaX = diferenciaX;
        this.diferenciaY = diferenciaY;
    }
    public int getAncho() {
        return ancho;
    }
    public int getAlto() {
        return alto;
    }
}
