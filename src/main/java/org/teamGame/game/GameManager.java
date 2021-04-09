package org.teamGame.game;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.teamGame.controller.GameController;
import org.teamGame.game.gfx.Assets;
import org.teamGame.game.gfx.GameCamera;
import org.teamGame.game.input.MouseManager;
import org.teamGame.game.world.World;
import org.teamGame.util.Handler;

import java.net.URL;

public class GameManager {
    //controller
    private GameController gameController;

    //timer
    AnimationTimer timer;
    private long start;
    private long timePerUpDate;
    private double delta = 0;
    private int count = 0;

    //canvases
    private Canvas backcanvas;
    private Canvas forecanvas;

    //graphicContexts
    private GraphicsContext gcb;
    private GraphicsContext gcf;

    private Stage stage;
    private Handler handler;


    //camera
    GameCamera gameCamera;

    private World world;

    private int height= 400,width=640;

    public GameManager(Handler handler, GameController gameController) {
        this.handler = handler;
        handler.setGameManager(this);
        this.stage = handler.getStage();
        this.gameController = gameController;

        //canvases
        backcanvas = gameController.getBackcanvas();
        forecanvas = gameController.getForecanvas();

        //camera
        gameCamera = new GameCamera(handler, 0,0);
        handler.setGameCamera();
    }

    private void initUI(){
        //graphicContexts
        gcb = backcanvas.getGraphicsContext2D();
        gcf = forecanvas.getGraphicsContext2D();

        //assets
        Assets.init();

        //graphic
        gcb.drawImage(Assets.mapLol, 0, 0, 4800, 4800);

        //World
        world = new World(handler);

        //loop
        start = System.nanoTime();
        timePerUpDate = 1000000000/40;
        timer = new MyTimer();

    }

    public void startGame(){

        initUI();

    }

    private class MyTimer extends AnimationTimer{

        @Override
        public void handle(long now) {
            doHandle(now);
        }

        private void doHandle(long now) {
//            delta += (now - start)/(double)timePerUpDate ;
//            start = now;
//
//            if(delta > 1.5){
//                delta = 0;
//            }
//            if(delta >= 1) {
//                update();
//                render(gcf);
//                delta--;
//            }
            update();
            render(gcf);
        }

    }

    public void update(){

    }

    public void render(GraphicsContext gcf){
        gcf.clearRect(0,0,width,height);
        world.render(gcf);
    }

    public AnimationTimer getTimer() {
        return timer;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }
}
