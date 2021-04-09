package org.teamGame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.teamGame.game.GameManager;
import org.teamGame.scene.StartScene;
import org.teamGame.util.Handler;

import java.io.IOException;

/**
 * JavaFX App
 */
public class Game extends Application {

    private Scene scene;
    private Stage stage;

    public Stage getStage() {
        return stage;
    }

    private StartScene startScene;
    private Handler handler;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        stage.setTitle("game");

        startScene = new StartScene(handler);
        scene = startScene.getScene();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    @Override
    public void init() throws Exception {
        super.init();
        handler = new Handler(this);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }


    public void launchGame(String[] args) {
        launch(args);
    }

    public StartScene getStartScene() {
        return startScene;
    }

    public void setStartScene(StartScene startScene) {
        this.startScene = startScene;
    }

    public Handler getHandler() {
        return handler;
    }

    public Scene getScene() {
        return scene;
    }
}