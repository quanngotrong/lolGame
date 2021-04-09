package org.teamGame.game.entities;

import javafx.scene.canvas.GraphicsContext;
import org.teamGame.game.entities.creatures.Player;
import org.teamGame.util.Handler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;

public class EntityManager {

    private Handler handler;
    private Player player;

    private Iterator i, j;

    private ArrayList<Entity> entities;
//    private ArrayList<Bullet> bullets;

    private Comparator<Entity> renderSort= Comparator.comparingDouble(a -> a.getY() + a.getHeight());

    public EntityManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;

        entities = new ArrayList<>();

        addEntity(player);
    }

    public void tick(){
        i = entities.iterator();
        while(i.hasNext()){
            Entity e = (Entity) i.next();
            e.tick();

            if(!e.isActive())
                i.remove();
        }
        entities.sort(renderSort);
    }

    public void render(GraphicsContext gc){

        for(Entity e: entities){
            e.tick();
            e.render(gc);
        }

    }



    public void addEntity(Entity e){
        entities.add(e);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
        addEntity(player);
    }

    public ArrayList<Entity> getEntities(){
        return entities;
    }

}
