package graphics;

public class Sprites  {
    private final int lado;

    public int getLado() {
        return lado;
    }

    private int x;
    private int y;

    public int[] pixeles;
    private HojaSprites hoja;


    //Colección Sprites Jugador:
    public static final Sprites ABAJO0 = new Sprites(32,0,0,0,HojaSprites.jugador);
    public static final Sprites ABAJO1 = new Sprites(32,0,1,0,HojaSprites.jugador);
    public static final Sprites ABAJO2 = new Sprites(32,0,2,0,HojaSprites.jugador);

    public static final Sprites ARRIBA0 = new Sprites(32,1,0,0,HojaSprites.jugador);
    public static final Sprites ARRIBA1 = new Sprites(32,1,1,0,HojaSprites.jugador);
    public static final Sprites ARRIBA2 = new Sprites(32,1,2,0,HojaSprites.jugador);

    public static final Sprites IZQUIERDA0 = new Sprites(32,2,0,0,HojaSprites.jugador);
    public static final Sprites IZQUIERDA1 = new Sprites(32,2,1,0,HojaSprites.jugador);
    public static final Sprites IZQUIERDA2 = new Sprites(32,2,2,0,HojaSprites.jugador);
    public static final Sprites DERECHA0 = new Sprites(32,3,0,0,HojaSprites.jugador);
    public static final Sprites DERECHA1 = new Sprites(32,3,1,0,HojaSprites.jugador);
    public static final Sprites DERECHA2 = new Sprites(32,3,2,0,HojaSprites.jugador);
    //Fin colección Sprites jugador;


    public static final Sprites VACIO = new Sprites(32,0);
    public static final Sprites LADRILLO0 = new Sprites(32,0,0,0,HojaSprites.laboratorio);
    public static final Sprites LADRILLO1 = new Sprites(32,0,1,0,HojaSprites.laboratorio);
    public static final Sprites LADRILLO1_FLIPPED = new Sprites(32,0,1,1,HojaSprites.laboratorio);
    public static final Sprites LADRILLO_CARTEL = new Sprites(32,0,2,0,HojaSprites.laboratorio);
    public static final Sprites PARED = new Sprites(32,1,0,0,HojaSprites.laboratorio);
    public static final Sprites PARED_BORDES = new Sprites(32,1,1,0,HojaSprites.laboratorio);
    public static final Sprites PARED_BORDE_DERECHA = new Sprites(32,1,2,0,HojaSprites.laboratorio);
    public static final Sprites PARED_BORDE_IZQUIERDA = new Sprites(32,1,2,1,HojaSprites.laboratorio);
    public static final Sprites PARED_CARTEL = new Sprites(32,1,3,0,HojaSprites.laboratorio);
    public static final Sprites PARED_LUZ = new Sprites(32,1,4,0,HojaSprites.laboratorio);
    public static final Sprites PARED_LUZ_DERECHA = new Sprites(32,1,5,0,HojaSprites.laboratorio);
    public static final Sprites PARED_LUZ_IZQUIERDA = new Sprites(32,1,5,1,HojaSprites.laboratorio);
    public static final Sprites PARED_EXTINTOR = new Sprites(32,1,6,0,HojaSprites.laboratorio);
    public static final Sprites PARED_EXTINTOR_BORDE = new Sprites(32,1,7,0,HojaSprites.laboratorio);
    public static final Sprites SUELO = new Sprites(32,2,0,0,HojaSprites.laboratorio);
    public static final Sprites SUELO_RAYA_VD = new Sprites(32,2,1,0,HojaSprites.laboratorio);
    public static final Sprites SUELO_RAYA_HA = new Sprites(32,2,1,4,HojaSprites.laboratorio);
    public static final Sprites SUELO_RAYA_VI = new Sprites(32,2,1,1,HojaSprites.laboratorio);
    public static final Sprites SUELO_RAYA_HAB = new Sprites(32,2,1,5,HojaSprites.laboratorio);
    public static final Sprites SUELO_RAYAE_HA = new Sprites(32,2,2,0,HojaSprites.laboratorio);
    public static final Sprites SUELO_RAYAE_HAX = new Sprites(32,2,2,1,HojaSprites.laboratorio);
    public static final Sprites SUELO_RAYAE_VI = new Sprites(32,2,2,4,HojaSprites.laboratorio);
    public static final Sprites SUELO_RAYAE_HAB = new Sprites(32,2,2,2,HojaSprites.laboratorio);
    public static final Sprites SUELO_RAYAE_VD = new Sprites(32,2,2,5,HojaSprites.laboratorio);
    public static final Sprites SUELO_RAYA90 = new Sprites(32,2,3,0,HojaSprites.laboratorio);
    public static final Sprites SUELO_RAYA90X = new Sprites(32,2,3,1,HojaSprites.laboratorio);
    public static final Sprites SUELO_RAYA90Y = new Sprites(32,2,3,2,HojaSprites.laboratorio);
    public static final Sprites SUELO_RAYA90XY = new Sprites(32,2,3,3,HojaSprites.laboratorio);
    public static final Sprites SUELO_ESQUINA = new Sprites(32,2,4,0,HojaSprites.laboratorio);
    public static final Sprites SUELO_ESQUINA_IAB = new Sprites(32,2,4,2,HojaSprites.laboratorio);
    public static final Sprites SUELO_ESQUINA_DAR = new Sprites(32,2,4,1,HojaSprites.laboratorio);
    public static final Sprites SUELO_ESQUINA_DAB = new Sprites(32,2,4,3,HojaSprites.laboratorio);
    public static final Sprites SUELO_RAYA_ROJA = new Sprites(32,2,5,0,HojaSprites.laboratorio);
    public static final Sprites SUELO_RAYA_ROJAC = new Sprites(32,2,6,0,HojaSprites.laboratorio);
    public static final Sprites SUELO_SOMBRA = new Sprites(32,2,7,0,HojaSprites.laboratorio);
    public static final Sprites PUERTA = new Sprites(32,3,0,0,HojaSprites.laboratorio);
    public static final Sprites ASCENSOR = new Sprites(32,3,1,0,HojaSprites.laboratorio);
    public static final Sprites PUERTA_GRIS = new Sprites(32,3,2,0,HojaSprites.laboratorio);
    public static final Sprites PUERTA_SEGURIDAD = new Sprites(32,3,3,0,HojaSprites.laboratorio);
    public static final Sprites PUERTA_BLANCA = new Sprites(32,3,4,0,HojaSprites.laboratorio);
    public static final Sprites PUERTA_FIRE1 = new Sprites(32,3,5,0,HojaSprites.laboratorio);
    public static final Sprites PUERTA_FIRE2 = new Sprites(32,3,6,0,HojaSprites.laboratorio);

    /*Colección Sprites desierto:
    public static final Sprites VACIO = new Sprites(32,0);
    public static final Sprites ASFALTO0 = new Sprites(32,0,0,0, HojaSprites.desierto);
    public static final Sprites ASFALTO1 = new Sprites(32,0,1,0, HojaSprites.desierto);
    public static final Sprites ASFALTO0_WHITELINE_H = new Sprites(32,0,2,0, HojaSprites.desierto);
    public static final Sprites ASFALTO0_WHITELINE_V = new Sprites(32,0,2,5, HojaSprites.desierto);
    public static final Sprites ARENA0 = new Sprites(32,1,0,0,HojaSprites.desierto);
    public static final Sprites ARENA1 = new Sprites(32,1,1,0,HojaSprites.desierto);
    public static final Sprites ARENA2 = new Sprites(32,1,0,3,HojaSprites.desierto);
    public static final Sprites OXIDO0 = new Sprites(32,2,0,0,HojaSprites.desierto);
    public static final Sprites OXIDO1 = new Sprites(32,2,1,0,HojaSprites.desierto);
    public static final Sprites GRAVA0 = new Sprites(32,3,0,0,HojaSprites.desierto);
    public static final Sprites GRAVA1 = new Sprites(32,3,1,0,HojaSprites.desierto);
    public static final Sprites HIERBA0 = new Sprites(32,4,0,0,HojaSprites.desierto);
    public static final Sprites HIERBA1 = new Sprites(32,4,1,0,HojaSprites.desierto);
    public static final Sprites ARBOL0 = new Sprites(32,4,2,0,HojaSprites.desierto);
    public static final Sprites ARBOL1 = new Sprites(32,4,2,1,HojaSprites.desierto);
    public static final Sprites ARBOL0_SIN_HOJAS0 = new Sprites(32,4,3,0,HojaSprites.desierto);
    public static final Sprites ARBOL0_SIN_HOJAS1 = new Sprites(32,4,3,1,HojaSprites.desierto);
    public static final Sprites WHITEFLOOR = new Sprites(32,5,1,0,HojaSprites.desierto);
    public static final Sprites WHITE = new Sprites(32,5,0,0,HojaSprites.desierto);

    Fin colección Sprites desierto;*/
    public Sprites(int lado, int columna, int fila,final int version, HojaSprites hoja) {
        this.lado = lado;
        this.pixeles = new int[lado * lado];
        this.x = columna * lado;
        this.y = fila * lado;
        this.hoja = hoja;

        loadSprite(version);
    }
    public Sprites(final int lado, final int color){
        this.lado = lado;
        pixeles = new int[lado*lado];

        for (int i = 0;i < pixeles.length; i++){
            pixeles[i] = color;
        }
    }
    private void loadSprite (int version){
        if (version == 0){
            cargaNormal();
        }
        else {
            cargaManipulada(version);
        }
    }
    private void cargaNormal(){
        for (int y = 0; y < lado; y++) {
            for (int x = 0; x < lado; x++) {
                pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.getAncho()];
            }
        }
    }
    private void cargaManipulada (int version){
        int[] pixelesTemporales = iniciarPixelesTemp();
        switch (version){
            case 1:
                invertirX(pixelesTemporales);
                break;
            case 2:
                invertirY(pixelesTemporales);
                break;
            case 3:
                invertirXY(pixelesTemporales);
                break;
            case 4:
                rotarI90(pixelesTemporales);
                break;
            case 5:
                rotarD90(pixelesTemporales);
                break;
            case 6:
                rotarI90YInvertido(pixelesTemporales);
                break;
            case 7:
                rotarD90YInvertido(pixelesTemporales);
                break;
            default:
                cargaNormal();
        }
    }
    private int[] iniciarPixelesTemp(){
        int[] pixelesTemporales = new int[lado*lado];
        for (int y = 0; y < lado; y++) {
            for (int x = 0; x < lado; x++) {
                pixelesTemporales[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.getAncho()];
            }
        }
        return pixelesTemporales;
    }
    private void invertirX(int[] pixelesTemporales){
        int i = 0;
        for (int y = 0; y < lado; y++){
            for (int x = lado-1; x > -1; x--){
                pixeles[i] = pixelesTemporales[x+y*lado];
                i++;
            }
        }
    }
    private void invertirY(int[] pixelesTemporales){
        int i = 0;
        for (int y = lado-1; y > -1; y--){
            for (int x = 0; x < lado; x++){
                pixeles[i] = pixelesTemporales[x+y*lado];
                i++;
            }
        }
    }
    private void invertirXY(int[] pixelesTemporales){
        for (int i = 0; i < pixeles.length; i++){
            pixeles[i] = pixelesTemporales[pixelesTemporales.length-1-i];
        }
    }
    private void rotarD90(int[] pixelesTemporales){
        int i = 0;
        for (int x = 0; x < lado; x++){
            for (int y = lado-1; y > -1; y--){
                pixeles[i] = pixelesTemporales[x+y*lado];
                i++;
            }
        }
    }
    private void rotarI90(int[] pixelesTemporales){
        int i = 0;
        for (int x = lado-1; x > -1; x--){
            for (int y = 0; y < lado; y++){
                pixeles[i] = pixelesTemporales[x+y*lado];
                i++;
            }
        }
    }
    private void rotarI90YInvertido(int[] pixelesTemporales){
        int i = 0;
        for (int x = 0; x < lado; x++){
            for (int y = 0; y < lado; y++){
                pixeles[i] = pixelesTemporales[x+y*lado];
                i++;
            }
        }
    }
    private void rotarD90YInvertido(int[] pixelesTemporales){
        int i = 0;
        for (int x = lado - 1; x > -1; x--){
            for (int y = lado -1; y > -1; y--){
                pixeles[i] = pixelesTemporales[x+y*lado];
                i++;
            }
        }
    }

}
