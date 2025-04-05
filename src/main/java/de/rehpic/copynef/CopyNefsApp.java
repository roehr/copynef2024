package de.rehpic.copynef;

import de.rehpic.copynef.model.ViewType;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class CopyNefsApp extends Application {
    @Override
    public void start(Stage stage) {
        var scene = new Scene(new Pane());
        ResourceBundle rb = ResourceBundle.getBundle("de.rehpic.copynef.bundles.main", Locale.GERMANY);
        ViewHandler.setScene(scene);
        ViewHandler.setResources(rb);
        ViewHandler.switchToView(ViewType.START);

        stage.setTitle("CopyNef24");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}