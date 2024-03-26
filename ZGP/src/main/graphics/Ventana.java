package main.graphics;

import main.tools.CargadorRecursos;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Ventana extends JFrame implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titulo;
    private final ImageIcon icon;

    public Ventana(final String titulo,final SuperficieDibujo sd){
        this.titulo = titulo;

        BufferedImage imagen = CargadorRecursos.cargarImgCompOpaca("/resources/images/x_logo4.png");
        this.icon = new ImageIcon(imagen);

        configurarVentana(sd);
    }
    private void configurarVentana(final SuperficieDibujo sd){
        setTitle(titulo);
        setIconImage(icon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(new BorderLayout());
        add(sd,BorderLayout.CENTER);
        //setUndecorated(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
