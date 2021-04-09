package org.teamGame.game.entities.creatures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import org.teamGame.Settings.Setting;
import org.teamGame.game.entities.Entity;
import org.teamGame.util.Handler;

public abstract class Creature extends Entity {

    protected double speed;
    protected double xMove, yMove;
    protected int direction = 2;
    protected int damage;

    public Creature(Handler handler, Image image, double x, double y, int width, int height) {
        super(handler, image, x, y, width, height);
        speed = Setting.DEFAULT_SPEED;
        xMove = 0;
        yMove =0;
    }

    public void move(){

    }

    public void moveX(){

    }

    public void moveY(){

    }


    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getxMove() {
        return xMove;
    }

    public void setxMove(double xMove) {
        this.xMove = xMove;
    }

    public double getyMove() {
        return yMove;
    }

    public void setyMove(double yMove) {
        this.yMove = yMove;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
