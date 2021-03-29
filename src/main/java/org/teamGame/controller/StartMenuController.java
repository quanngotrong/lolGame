package org.teamGame.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.teamGame.Game;
import org.teamGame.scene.GameScene;
import org.teamGame.util.Handler;

import java.io.IOException;

public class StartMenuController implements FxController{

    @FXML
    public Button button;

    @FXML
    public void handleButtonClick() throws IOException {
        GameScene gameScene = new GameScene(Game.getHandler());
        Game.getStage().setScene(gameScene.getScene());
    }
}
