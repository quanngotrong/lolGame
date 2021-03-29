package org.teamGame.util;

import org.teamGame.Game;

public class Handler {

    private Game game;

    public Handler(Game game){
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }



}
