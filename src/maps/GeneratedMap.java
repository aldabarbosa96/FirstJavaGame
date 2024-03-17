package maps;

import java.util.Random;

public class GeneratedMap extends Map{
    private static final Random random = new Random();
    public GeneratedMap(int ancho, int alto) {
        super(ancho, alto);
    }
    protected void generateMap(){
        for (int y = 0; y < alto; y++){
            for (int x = 0; x < ancho; x++){
                tiles[x + y * ancho] = random.nextInt(5);
            }
        }
    }
}
