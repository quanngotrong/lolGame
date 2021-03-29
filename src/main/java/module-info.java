module org.example {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.logging;
    requires java.prefs;
    requires java.base;

    opens org.teamGame to javafx.fxml;

    exports org.teamGame;
    exports org.teamGame.controller;
    exports org.teamGame.Managers;
    exports org.teamGame.scene;
    exports org.teamGame.util;
}