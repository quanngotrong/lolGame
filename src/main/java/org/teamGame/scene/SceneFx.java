package org.teamGame.scene;

import javafx.scene.Scene;
import org.teamGame.Game;
import org.teamGame.util.Handler;

public class SceneFx {
    protected Handler handler;
    protected Game game;
    protected Scene scene;

    public SceneFx(Handler handler) {
        this.handler = handler;
        this.game = handler.getGame();
    }
}
