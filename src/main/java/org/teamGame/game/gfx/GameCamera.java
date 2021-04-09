package org.teamGame.game.gfx;

import org.teamGame.game.entities.Entity;
import org.teamGame.util.Handler;

public class GameCamera {

    private double xOffset, yOffset;
    private Handler handler;

    public GameCamera(Handler handler, double xOffset, double yOffset){
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void checkBlankSpace(){
//        if(xOffset < 0){
//            xOffset = 0;
//        } else if(xOffset > handler.getWorld().getWidth() * Settings.TILE_WIDTH - handler.getWidth()){
//            xOffset = handler.getWorld().getWidth() * Settings.TILE_WIDTH - handler.getWidth();
//        }
//
//        if(yOffset < 0){
//            yOffset = 0;
//        } else if(yOffset > handler.getWorld().getHeight() * Settings.TILE_HEIGHT - handler.getHeight()){
//            yOffset = handler.getWorld().getHeight() * Settings.TILE_HEIGHT - handler.getHeight();
//        }
    }

    public void centerOnEntity(Entity e){
//        xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
//        yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
    }

    public void move(double xAmt, double yAmt){
        xOffset += xAmt;
        yOffset += yAmt;
    }

    public double getxOffset() {
        return xOffset;
    }

    public void setxOffset(double xOffset) {
        this.xOffset = xOffset;
    }

    public double getyOffset() {
        return yOffset;
    }

    public void setyOffset(double yOffset) {
        this.yOffset = yOffset;
    }
}
