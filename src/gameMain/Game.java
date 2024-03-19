package gameMain;

import controladores.Teclado;
import entes.criaturas.Jugador;
import graphics.Pantalla;
import graphics.Sprites;
import maps.GeneratedMap;
import maps.LoadedMap;
import maps.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;
    private static volatile boolean enFuncionamiento = false;

    private static final int ancho = 700;
    private static final int alto = 500;

    private static final String nombre = "ZGP";

    private static String CONTADOR_APS = "";
    private static String CONTADOR_FPS = "";

    private static int aps =0;
    private static int fps =0;

    private static Thread thread;
    private static Teclado teclado;
    private static JFrame ventana;
    private static Pantalla pantalla;

    private static Map map;
    private static Jugador jugador;
    private static BufferedImage imagen = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
    private static int[] pixeles = ((DataBufferInt)imagen.getRaster().getDataBuffer()).getData();
    private static final ImageIcon icon = new ImageIcon(Game.class.getResource("/graphics/sprites/x_logo4.png"));


    Game() {
        setPreferredSize(new Dimension(ancho, alto));

        pantalla = new Pantalla(ancho,alto);

        teclado = new Teclado();
        addKeyListener(teclado);

        map = new LoadedMap("/graphics/sprites/tilepixel0.png");
        jugador = new Jugador(map,teclado, Sprites.ABAJO0,2001  ,1415);

        ventana = new JFrame(nombre);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(true);
        ventana.setLayout(new BorderLayout());
        ventana.add(this, BorderLayout.CENTER);
        //ventana.setUndecorated(true);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setIconImage(icon.getImage());
    }
    synchronized void iniciar() {
        enFuncionamiento = true;

        thread = new Thread(this, "Gráficos");
        thread.start();
    }
    private synchronized void detener(){
        enFuncionamiento = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void actualizar(){
         teclado.actualizar();
         jugador.actualizar();
         if (teclado.exit) System.exit(0);

         aps++;
    }
    public void mostrar(){
        BufferStrategy strategy = getBufferStrategy();

        if (strategy == null){
            createBufferStrategy(3);
            return;
        }

        // pantalla.limpiar();
        map.mostrar(jugador.getPosX() - pantalla.getAncho()/2 + jugador.getSprites().getLado() / 2, jugador.getPosY() - pantalla.getAlto() / 2 + jugador.getSprites().getLado() / 2, pantalla);
        jugador.mostrar(pantalla);

        System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length); //método optimizado

        Graphics g = strategy.getDrawGraphics();

        g.drawImage(imagen,0,0,getWidth(),getHeight(),null);
        g.setColor(Color.white);
        g.drawString(CONTADOR_APS,10,20);
        g.drawString(CONTADOR_FPS,10,40);
        g.drawString("X: "+jugador.getPosX(), 10,60);
        g.drawString("Y: "+jugador.getPosY(),10,75);
        g.dispose();
        strategy.show();

         fps++;
    }

    @Override
    public void run() {

         final int nanoSgxSg = 1000000000;
         final byte actxSg = 60;
         final double nanoSgxAct = nanoSgxSg / actxSg;
         long referenciaAct = System.nanoTime();
         long referenciaCont = System.nanoTime();
         double tiempoTransc;
         double delta = 0;

         requestFocus();

        while (enFuncionamiento){
            final long inicioBucle = System.nanoTime();
            tiempoTransc = inicioBucle - referenciaAct;
            referenciaAct = inicioBucle;
            delta += tiempoTransc/nanoSgxAct;

            while (delta >= 1){
                actualizar();
                delta--;
            }
            mostrar();

            if (System.nanoTime() - referenciaCont > nanoSgxSg){
                CONTADOR_APS = "APS: "+aps;
                CONTADOR_FPS = "FPS: "+fps;
                aps = 0;
                fps = 0;
                referenciaCont = System.nanoTime();
            }
        }
    }
}
