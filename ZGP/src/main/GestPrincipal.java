package main;

import main.control.GestControles;
import main.graphics.SuperficieDibujo;
import main.graphics.Ventana;
import main.statusMachine.GestEstado;

public class GestPrincipal {
    private boolean enFuncionamiento = false;
    private String titulo;
    private int ancho;
    private int alto;

    private SuperficieDibujo sd;
    private Ventana ventana;
    private GestEstado ge;
    private GestPrincipal(final String titulo, final int ancho, final int alto){
        this.titulo = titulo;
        this.ancho = ancho;
        this.alto = alto;
    }

    public static void main(String[] args) {
        GestPrincipal mm = new GestPrincipal("ZGP", 800,600);

        Constantes.ANCHO_PANTALLA = 800;
        Constantes.ALTO_PANTALLA = 600;

        
        mm.iniciarJuego();
        mm.iniciarBuclePrincipal();
    }

    private void iniciarJuego() {
        enFuncionamiento = true;
        inicializar();
    }

    private void inicializar() {
        sd = new SuperficieDibujo(ancho,alto);
        ventana = new Ventana(titulo,sd);
        ge = new GestEstado();
    }

    private void iniciarBuclePrincipal() {
        int aps = 0;
        int fps=0;

        final int nanoSgxSg = 1000000000;
        final int actxSg = 60;
        final double nanoSgxAct = nanoSgxSg / actxSg;
        long referenciaAct = System.nanoTime();
        long referenciaCont = System.nanoTime();
        double tiempoTransc;
        double delta = 0;

        while (enFuncionamiento){
            final long inicioBucle = System.nanoTime();
            tiempoTransc = inicioBucle - referenciaAct;
            referenciaAct = inicioBucle;
            delta += tiempoTransc/nanoSgxAct;

            while (delta >= 1){
                actualizar();
                aps++;
                Constantes.APS = aps;
                delta--;
            }
            dibujar();
            fps++;

            if (System.nanoTime() - referenciaCont > nanoSgxSg){
                System.out.println("FPS: "+fps+" APS: "+aps);
                aps = 0;
                Constantes.APS = aps;
                fps = 0;
                referenciaCont = System.nanoTime();
            }
        }
    }
    private void actualizar(){
       ge.actualizar();
    }
    private void dibujar(){
       sd.dibujar(ge);
    }

}
