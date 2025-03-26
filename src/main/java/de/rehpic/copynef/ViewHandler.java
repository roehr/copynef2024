package de.rehpic.copynef;

import de.rehpic.copynef.model.ViewType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.ResourceBundle;

public class ViewHandler {
    private static Scene scene;
    private static ResourceBundle resources;

    public static void setScene(Scene scene) {
        ViewHandler.scene = scene;
    }
    public static void setResources(ResourceBundle resources) {
        ViewHandler.resources = resources;
    }

    public static ResourceBundle getResources() {
        return resources;
    }

    static public void switchToView(ViewType view){
        if(scene == null){
            System.out.println("ViewSwitcher: Scene is null");
            return;
        }
        try {
           Parent root = FXMLLoader.load(ViewHandler.class.getResource(view.getFxml()), resources);
            scene.setRoot(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
