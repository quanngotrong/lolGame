package org.teamGame.game.tiles;

import javafx.scene.image.Image;

public class Tile {

    public static Tile[] tiles;
    private Image image;
    int id;

    public Tile(Image image, int id){
        tiles = new Tile[100];
        this.image = image;
        this.id = id;
        tiles[id] = this;
    }

}
