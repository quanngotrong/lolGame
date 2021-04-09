package org.teamGame.game.entities.creatures;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import org.teamGame.Settings.Setting;
import org.teamGame.game.gfx.Assets;
import org.teamGame.game.gfx.SpriteAnimation;
import org.teamGame.game.input.MouseManager;
import org.teamGame.util.Handler;

import java.util.Set;

public class Player extends Creature{

    protected int count = 9;
    protected int columns = 9;
    protected int width = 64;
    protected int height = 64;

    protected int offsetX = 0;
    protected int offsetY = 640;

    protected SpriteAnimation animation;
    protected Image player;

    // point to go
    private Point2D goingPoint;
    private int goingX, goingY;
    private boolean isPointVisited;

    private double actualX;
    private double actualY;
    private double distance;

    //mouse
    MouseManager mouseManager;

    public Player(Handler handler, double x, double y) {
        super(handler, Assets.player, x, y, Setting.DEFAULT_CREATURE_WIDTH, Setting.DEFAULT_CREATURE_HEIGHT);

        setSpeed(Setting.PLAYER_SPEED);

        imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        animation =new SpriteAnimation(imageView, Duration.millis(1000),
                count, columns, offsetX, offsetY, width, height);

        speed = 3;

        //mouse
        mouseManager = null;

        //bounds
        bottomBounds = new Rectangle(24, 38,16, 24);

        hitPoint = new Point2D(width/2, height/2);

        standPoint = new Point2D(bottomBounds.getX() + bottomBounds.getWidth()/2,
                bottomBounds.getY()+bottomBounds.getHeight()/2 );

        //going
        isPointVisited = true;
        goingX =(int)(standPoint.getX() + x);
        goingX =(int)(standPoint.getY() + y);

    }


    @Override
    public void tick() {
        if(mouseManager == null){
            mouseManager = handler.getMouseManager();
        }
        xMove = 0;
        yMove = 0;
        //movements
        getInput();
        setAnimation();
        move();

    }

    public void move(){
        x += xMove;
        y += yMove;

    }

    @Override
    public void render(GraphicsContext gc) {
        //draw player
        if(xMove != 0 || yMove!= 0){
            animation.play();
        } else{
            animation.stop();
        }

        player = imageView.snapshot(params, null);
        gc.drawImage(player, (int)(x-handler.getGameCamera().getxOffset()),
                (int)(y - handler.getGameCamera().getyOffset()));

    }

    @Override
    public void die() {

    }

    public void getInput(){
        if(
                mouseManager.getyPressed() != -1 &&
                mouseManager.getxPressed() != -1
        ) {
            if (mouseManager.getxPressed() != goingX||
                    mouseManager.getyPressed() != goingY) {
                goingX = mouseManager.getxPressed();
                goingY = mouseManager.getyPressed();

                isPointVisited = false;
            System.out.println("ha");
            }
        }
        if(isPointVisited == false){
            moveToPoint();
        }
    }



    public void moveToPoint(){
        double actualX = standPoint.getX() - handler.getGameCamera().getxOffset() + x;
        double actualY = standPoint.getY() - handler.getGameCamera().getyOffset() + y;
        double distance = Math.sqrt((actualX -goingX) * (actualX -goingX) + (actualY -goingY) * (actualY -goingY));
        double sin = Math.abs(actualX - goingX)/distance;
        double cos = Math.abs(actualY - goingY)/distance;


        if((int)(actualY) > goingY + 1 ){
            //up
            yMove = -speed * cos;
            direction = 1;
        }
        if((int)(actualY) < goingY - 1){
            //down
            yMove = speed * cos;
            direction = 2;
        }
        if((int)(actualX) < goingX -1 ){
            //right
            xMove = speed * sin;
            direction = 4;
        }
        if((int)(actualX) > goingX + 1 ){
            //left
            xMove = -speed * sin;
            direction = 3;
        }
        if((int)(actualY) == goingY
        && (int)(actualX) == goingX){
            isPointVisited = true;

        mouseManager.setxPressed();
        mouseManager.setyPressed();
        }
    }

    private void setAnimation(){
        if(direction == 1){ //up
            animation.setOffsetY(512);
        }
        if(direction == 2){ //down
            animation.setOffsetY(640);
        }
        if(direction == 3){ //left
            animation.setOffsetY(576);
        }
        if(direction == 4){ //right
            animation.setOffsetY(704);
        }
    }
}
