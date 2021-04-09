package org.teamGame.scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import org.teamGame.Game;
import org.teamGame.controller.StartMenuController;
import org.teamGame.util.Handler;
import org.teamGame.util.Utils;

import java.io.IOException;

public class StartScene extends SceneFx{

    public StartScene(Handler handler) throws IOException {
        super(handler, "startMenu");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/"+"startMenu" + ".fxml"));
        fxmlLoader.setController(new StartMenuController(handler));
        AnchorPane root = (AnchorPane)fxmlLoader.load();

        scene = new Scene(root, 800, 400);
        scene.getStylesheets().add(getClass().getResource("/css/startMenu.css").toExternalForm());
    }

    public Scene getScene() {
        return scene;
    }

    @Override
    public Scene createScene() {
        return null;
    }
}
