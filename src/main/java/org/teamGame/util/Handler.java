package org.teamGame.util;

import javafx.stage.Stage;
import org.teamGame.Game;
import org.teamGame.game.GameManager;
import org.teamGame.game.gfx.GameCamera;
import org.teamGame.game.input.MouseManager;
import org.teamGame.scene.GameScene;
import org.teamGame.scene.StartScene;

public class Handler {
    private Stage stage;
    private Game game;

    //scene
    private GameScene gameScene;
    private StartScene startScene;

    //in game
    private GameManager gameManager;
    private MouseManager mouseManager;
    private GameCamera gameCamera;

    public GameScene getGameScene() {
        return gameScene;
    }

    public void setGameScene(GameScene gameScene) {
        this.gameScene = gameScene;
    }

    public StartScene getStartScene() {
        return startScene;
    }

    public void setStartScene(StartScene startScene) {
        this.startScene = startScene;
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public void setMouseManager(MouseManager mouseManager) {
        this.mouseManager = mouseManager;
    }

    public Stage getStage() {
        return game.getStage();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Handler(Game game){
        this.game = game;
        this.stage = game.getStage();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public void setGameCamera() {
        this.gameCamera = gameManager.getGameCamera();
    }
}
