package de.rehpic.copynef.controller;

import de.rehpic.copynef.ViewHandler;
import de.rehpic.copynef.model.Settings;
import de.rehpic.copynef.model.ViewType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;

import java.io.File;

public class StartController {
    @FXML
    VBox root;
    @FXML
    private Label state;
    @FXML
    private Label jpgPath;


    @FXML
    public void onSelectJpgs() {
         DirectoryChooser directoryChooser = new DirectoryChooser();

        File pathToJpgs = directoryChooser.showDialog(root.getScene().getWindow());
        if(pathToJpgs != null) {
            Settings.setJpgFolder(pathToJpgs);
        }
        state.setText(ViewHandler.getResources().getString("start.selected.jpg"));
        jpgPath.setText(pathToJpgs.getAbsolutePath());


    }

    public void onCopy(ActionEvent actionEvent) {
        ViewHandler.switchToView(ViewType.COPY);
    }

    public void onSort(ActionEvent actionEvent) {
        ViewHandler.switchToView(ViewType.SORT);
    }

    public void onLegacy(ActionEvent actionEvent) {
        ViewHandler.switchToView(ViewType.HELLO);
    }
}
