package org.teamGame.scene;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import org.teamGame.Game;
import org.teamGame.util.Handler;
import org.teamGame.util.Utils;

import java.io.IOException;

public class StartScene extends SceneFx{

    public StartScene(Handler handler) throws IOException {
        super(handler);
        AnchorPane root = (AnchorPane)Utils.loadFXML("startMenu");

        scene = new Scene(root, 640, 480);
    }

    public Scene getScene() {
        return scene;
    }

}
