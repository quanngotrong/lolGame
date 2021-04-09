package org.teamGame.scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import org.teamGame.Game;
import org.teamGame.controller.GameController;
import org.teamGame.controller.StartMenuController;
import org.teamGame.util.Handler;
import org.teamGame.util.Utils;

import java.io.IOException;

public class GameScene extends SceneFx{

    public GameScene(Handler handler) throws IOException {
        super(handler, "gameScene");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/"+fxml+ ".fxml"));
        fxmlLoader.setController(new GameController(handler));
        AnchorPane root = (AnchorPane)fxmlLoader.load();

        handler.setGameScene(this);

        scene = new Scene(root);
    }

    public Scene getScene(){
        return this.scene;
    }

    @Override
    public Scene createScene() {
        return null;
    }

}
