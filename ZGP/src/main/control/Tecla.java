package main.control;

public class Tecla {
    private boolean pulsada = false;
    private long ultimaPulsacion = System.nanoTime();

    public void teclaPulsada(){
        pulsada = true;
        ultimaPulsacion = System.nanoTime();
    }
    public void teclaSoltada(){
        pulsada = false;
    }
    public boolean estaPulsada(){
        return pulsada;
    }
    public long getUltimaPulsacion(){
        return ultimaPulsacion;
    }
}
