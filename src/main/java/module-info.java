module org.example {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.logging;
    requires java.prefs;
    requires java.base;

    opens org.teamGame to javafx.fxml;
    opens org.teamGame.controller;
    opens org.teamGame.scene;
    opens org.teamGame.util;
    opens org.teamGame.game;
    opens org.teamGame.game.world;
    opens org.teamGame.game.gfx;
    opens org.teamGame.game.tiles;
    opens org.teamGame.game.input;
    opens org.teamGame.game.entities;

    exports org.teamGame;
    exports org.teamGame.controller;
    exports org.teamGame.scene;
    exports org.teamGame.util;
    exports org.teamGame.game;
    exports org.teamGame.game.world;
    exports org.teamGame.game.gfx;
    exports org.teamGame.game.tiles;
    exports org.teamGame.game.input;
    exports org.teamGame.game.entities;
    exports org.teamGame.game.entities.creatures;
    exports org.teamGame.game.entities.statics;

}