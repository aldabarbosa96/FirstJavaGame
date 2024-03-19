package main.graphics;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.io.Serializable;

public class Ventana extends JFrame implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titulo;

    public Ventana(final String titulo,final SuperficieDibujo sd){
        this.titulo = titulo;

        configurarVentana(sd);
    }
    private void configurarVentana(final SuperficieDibujo sd){
        setTitle(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        //setIconImage();
        setLayout(new BorderLayout());
        add(sd,BorderLayout.CENTER);
        //setUndecorated(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
