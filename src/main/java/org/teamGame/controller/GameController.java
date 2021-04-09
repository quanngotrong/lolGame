package org.teamGame.controller;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import org.teamGame.game.GameManager;
import org.teamGame.scene.StartScene;
import org.teamGame.util.Handler;

import java.io.IOException;

public class GameController implements FxController{
    private Handler handler;

    GameManager gameManager;

    //display
    private GraphicsContext gc;

    public GameController(Handler handler){
        this.handler = handler;
    }

    @FXML
    private Canvas backcanvas;

    @FXML
    private Canvas forecanvas;

    @FXML
    private Button button1;

    @FXML
    private Button button0;

    @FXML
    private Button button2;

    @FXML
    public void initialize(){
        this.gc = this.backcanvas.getGraphicsContext2D();
        
        gameManager = new GameManager(handler, this);
        handler.setGameManager(gameManager);
        gameManager.startGame();
        gameManager.getTimer().start();

        //test
        this.button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("ha");
                StartScene scene = null;
                try {
                    scene = new StartScene(handler);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                handler.getStage().setScene(scene.getScene());
            }
        });

        button0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameManager.getTimer().start();
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameManager.getTimer().stop();
            }
        });

    }

    public Canvas getBackcanvas() {
        return backcanvas;
    }

    public Canvas getForecanvas(){
        return forecanvas;
    }

}

