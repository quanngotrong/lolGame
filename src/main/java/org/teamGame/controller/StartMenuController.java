package org.teamGame.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.teamGame.Game;
import org.teamGame.game.input.MouseManager;
import org.teamGame.scene.GameScene;
import org.teamGame.util.Handler;

import java.io.IOException;

public class StartMenuController implements FxController{

    private Handler handler;

    public StartMenuController(Handler handler){
        this.handler  = handler;
    }

    @FXML
    private Button button;

    @FXML
    private void handleButtonClick() throws IOException {
        GameScene gameScene = new GameScene(handler);
        handler.setGameScene(gameScene);
        handler.setMouseManager(new MouseManager(handler.getGameScene().getScene()));

        handler.getStage().setScene(gameScene.getScene());
    }
}
