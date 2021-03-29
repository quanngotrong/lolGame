package org.teamGame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.teamGame.scene.StartScene;
import org.teamGame.util.Handler;

import java.io.IOException;

/**
 * JavaFX App
 */
public class Game extends Application {

    private static Scene scene;
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Game.stage = stage;
    }

    private StartScene startScene;
    private static Handler handler;

    public static Handler getHandler() {
        return handler;
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        Game.scene = scene;
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        stage.setTitle("game");

        startScene = new StartScene(handler);
        scene = startScene.getScene();
        stage.setScene(scene);
        stage.show();
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

}