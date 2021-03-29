package org.teamGame.scene;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import org.teamGame.Game;
import org.teamGame.util.Handler;
import org.teamGame.util.Utils;

import java.io.IOException;

public class GameScene extends SceneFx{

    public GameScene(Handler handler) throws IOException {
        super(handler);
        AnchorPane root = (AnchorPane) Utils.loadFXML("gameScene");

        scene = new Scene(root);
    }

    public Scene getScene(){
        return this.scene;
    }

}
