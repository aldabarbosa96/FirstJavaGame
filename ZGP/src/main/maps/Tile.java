package main.maps;

import main.sprites.Sprite;

import java.awt.*;

public class Tile {
    private final Sprite sprite;
    private final int id;
    private boolean solid;

    public Tile(final Sprite sprite, final int id){
        this.sprite = sprite;
        this.id = id;
        solid = false;
    }
    public Tile(final Sprite sprite, final int id, boolean solid){
        this.sprite = sprite;
        this.id=id;
        this.solid = solid;
    }
    public Sprite getSprite(){
        return sprite;
    }
    public int getId(){
        return id;
    }
    public void setSolid(final boolean solid){
        this.solid = solid;
    }
    public Rectangle getLimites(final int x, final int y){
        return  new Rectangle(x,y,sprite.getAncho(),sprite.getAlto());
    }
}
