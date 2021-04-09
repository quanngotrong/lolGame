package org.teamGame.game.entities;

import javafx.geometry.Point2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.teamGame.Settings.Setting;
import org.teamGame.util.Handler;

public abstract class Entity {

    protected double x, y;
    protected int width, height;
    protected Handler handler;
    protected Image image;
    protected ImageView imageView;
    protected int health, maxHealth;

    protected boolean active = true;

    protected SnapshotParameters params;

    // diem entity dung
    protected Point2D standPoint;
    // diem dan bay vao
    protected Point2D hitPoint;

    protected Rectangle bodyBounds;
    protected Rectangle bottomBounds;

    public Entity(Handler handler , Image image, double x ,double y, int width, int height){
        this.handler = handler;
        this.image = image;

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.health= Setting.DEFAULT_HEALTH;

        params =new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);

    }

    public abstract void tick();

    public abstract void render(GraphicsContext g);

    public abstract void die();

    public void takeDamage(int amount){
        health -= amount;
        if(health <= 0){
            active = false;
            die();
        }
    }

//    public boolean checkEntityCollision(double xOffset, double yOffset){
//
//    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Rectangle getBodyBounds() {
        return bodyBounds;
    }

    public void setBodyBounds(Rectangle bodyBounds) {
        this.bodyBounds = bodyBounds;
    }

    public Rectangle getBottomBounds() {
        return bottomBounds;
    }

    public void setBottomBounds(Rectangle bottomBounds) {
        this.bottomBounds = bottomBounds;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Point2D getStandPoint() {
        return standPoint;
    }

    public void setStandPoint(Point2D standPoint) {
        this.standPoint = standPoint;
    }

    public Point2D getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(Point2D hitPoint) {
        this.hitPoint = hitPoint;
    }
}
