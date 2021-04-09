package org.teamGame.game.gfx;

import javafx.scene.image.Image;


import java.net.URL;

public class Assets {
    private static final int width = 32, height = 32;
    public static Image grass;

    //map game lol
    public static Image mapLol;

    //creatures
    public static Image player, skeleton;

    public static void init(){

        //tile sheep
        SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Map_1.png"));

        //tile types
        grass = tileSheet.crop(32,64,width, height);

        //map lol
        mapLol = ImageLoader.loadImage("/images/mapt1.png");

        //entity
        player = ImageLoader.loadImage("/textures/player.png");
        skeleton = ImageLoader.loadImage("/textures/skeleton.png");

    }

}
