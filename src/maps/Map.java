package maps;

import graphics.Pantalla;
import maps.tiles.Tile;

public  class Map {
    protected int ancho;
    protected int alto;
    protected int[] tiles;
    protected Tile[] tilesCatalog;

    public Map(int ancho, int alto) {
        this.alto = alto;
        this.ancho = ancho;
        tiles = new int[ancho * alto];
        generateMap();
    }

    public Map(String ruta) {
        loadMap(ruta);
        generateMap();
    }

    protected void generateMap() {
    }

    protected void loadMap(String ruta) {
    }

    public void actualizar() {
    }
    public void mostrar(final int compX, final int compY, final Pantalla pantalla) {

        pantalla.setDiferencia(compX,compY);

        int N = compY >> 5;
        int S = (compY + pantalla.getAlto() + Tile.LADO) >> 5;
        int E = (compX + pantalla.getAncho() + Tile.LADO) >> 5;
        int O = compX >> 5;

        for (int y = N; y < S; y++) {
            for (int x = O; x < E; x++) {
                if (x<0 || y<0 || x >= ancho || y >= alto){
                    Tile.VACIO.mostrar(x,y,pantalla);
                }
                else {
                    tilesCatalog[x + y * ancho].mostrar(x, y, pantalla);

                }
            }
        }
    }
    /*public Tile getTile(final int x, final int y) {
        if (x<0 || y<0 || x>= ancho || y>= alto){
            return Tile.VACIO;
        }
        switch (tiles[x + y * ancho]) {
            case 0:
                return Tile.ASFALTO0;
            case 1:
                return Tile.ARENA0;
            case 2:
                return Tile.OXIDO0;
            case 3:
                return Tile.GRAVA0;
            case 4:
                return Tile.HIERBA0;
            case 5:
                return Tile.WHITE;

            default:
                return Tile.VACIO;
        }
    }*/
}
