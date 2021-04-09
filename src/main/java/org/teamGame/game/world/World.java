package org.teamGame.game.world;

import javafx.scene.canvas.GraphicsContext;
import org.teamGame.game.entities.EntityManager;
import org.teamGame.game.entities.creatures.Player;
import org.teamGame.util.Handler;
import org.teamGame.util.Utils;

public class World {

    private Handler handler;

    private int width, height;

    //number of col and row
    private int col, row;

    //start position of player
    private Player player;
    private int spawnX = 20, spawnY = 20;
    private int[][] tiles;

    // entities
    EntityManager entityManager;

    public World(Handler handler){
        this.handler = handler;


        player = new Player(handler, spawnX, spawnY);
        entityManager = new EntityManager(handler,player);
    }

    public void tick(){
        entityManager.tick();

    }

    public void render(GraphicsContext gc){
        entityManager.render(gc);
    }

    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");

        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for(int y = 0; y < height; y++) {
            for(int x =  0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x+y*col) + 4]);
            }
        }
    }



}
