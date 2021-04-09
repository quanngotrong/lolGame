package org.teamGame.scene;

import javafx.scene.Scene;
import org.teamGame.Game;
import org.teamGame.util.Handler;

public abstract class SceneFx {
    protected Handler handler;
    protected Game game;
    protected Scene scene;
    protected String fxml;

    public SceneFx(Handler handler, String fxml) {
        this.handler = handler;
        this.game = handler.getGame();
        this.fxml = fxml;
    }

    abstract public Scene createScene();
}
