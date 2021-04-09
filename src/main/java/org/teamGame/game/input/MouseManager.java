package org.teamGame.game.input;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

public class MouseManager {
    private boolean leftPressed, rightPressed;
    private int mouseX, mouseY;
    private int xPressed , yPressed;

    private Scene scene;

    public MouseManager(Scene scene){
        this.scene = scene;

        xPressed = -1;
        yPressed = -1;

        addListener();
    }

    public void addListener(){
        scene.addEventFilter(MouseEvent.MOUSE_PRESSED, mousePressedEventHandler);
        scene.addEventFilter(MouseEvent.MOUSE_RELEASED, mouseReleasedEventHandler);
        scene.addEventFilter(MouseEvent.MOUSE_MOVED, mouseMovedEventHandler);
    }

    private EventHandler<MouseEvent>mousePressedEventHandler = e ->{
        if(e.getButton() == MouseButton.PRIMARY){
            leftPressed = true;
        }
        else if(e.getButton() == MouseButton.SECONDARY){
            rightPressed = true;
        }
    };

    private EventHandler<MouseEvent> mouseReleasedEventHandler = e ->{
        if(e.getButton() == MouseButton.PRIMARY) {
            leftPressed = false;
        }
        else if(e.getButton() == MouseButton.SECONDARY) {
            rightPressed = false;
            xPressed = (int) e.getX();
            yPressed = (int) e.getY();
            System.out.println(xPressed + " " + yPressed);
        }
    };

    private EventHandler<MouseEvent> mouseMovedEventHandler = e -> {
        mouseX = (int) e.getX();
        mouseY = (int) e.getY();
    };

    //getters & setters
    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public int getxPressed() {
        return xPressed;
    }

    public int getyPressed() {
        return yPressed;
    }

    public void setxPressed(){
        xPressed = -1;
    }
    public void setyPressed(){
        yPressed = -1;
    }
}
