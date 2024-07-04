package de.rehpic.copynef24;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class HelloController {
    private File pathToJpgs;
    private File pathToRaws;
    private DirectoryChooser directoryChooser;
    @FXML
    VBox root;
    @FXML
    private Label state;
    @FXML
    private Label jpgPath;
    @FXML
    private Label nefPath;
    @FXML
    private TextArea messages;

    @FXML
    ProgressBar progress;

    @FXML
    public void onSelectJpgs() {
        directoryChooser = new DirectoryChooser();
        pathToJpgs = directoryChooser.showDialog(root.getScene().getWindow());
        state.setText("Selected JPG Folder");
        jpgPath.setText(pathToJpgs.getAbsolutePath());
        progress.setProgress(0);
    }

    @FXML
    public void onSelectNefs() {
        directoryChooser = new DirectoryChooser();
        pathToRaws = directoryChooser.showDialog(root.getScene().getWindow());
        state.setText("Selected NEF Folder");
        nefPath.setText(pathToRaws.getAbsolutePath());
        progress.setProgress(0);
    }

    @FXML
    public void onCopy() {

        messages.setText("");
        Thread copyThread = new Thread(this::copyFiles);
        copyThread.start();
    }

    private void copyFiles () {
        File[] directoryListing = pathToJpgs.listFiles();
        Platform.runLater(() -> progress.setProgress(0));
        if (directoryListing != null) {
            int progressCount = 0;
            String rawFolder = pathToJpgs +"/raw";
            boolean rawDirSuccess = new File(rawFolder).mkdirs();
            if(!rawDirSuccess){
                messages.setText("Couldn't create raw folder. Does it already exist? \n");
            }
            for (File child : directoryListing) {
                progressCount++;
                String fileToCopy= child.getName().replace(".JPG", ".NEF");

                try{
                    File file=new File(pathToRaws +"/"+ fileToCopy);
                    FileUtils.copyFile(file, new File(pathToJpgs + "/raw/" + fileToCopy));
                    int finalProgressCount = progressCount;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            state.setText(String.valueOf(finalProgressCount) + '/' + directoryListing.length);
                            progress.setProgress((double) finalProgressCount /(double) directoryListing.length);
                        }
                    });
                } catch (IOException e) {
                    int finalProgressCount = progressCount;
                    Platform.runLater(() -> {
                        messages.setText( messages.getText() + "There is no sourcefile " + fileToCopy + "\n");
                        progress.setProgress((double) finalProgressCount /(double) directoryListing.length);
                        state.setText(String.valueOf(finalProgressCount) + '/' + directoryListing.length);
                    });
                }
            }
            Platform.runLater(() -> state.setText("Done. " + directoryListing.length + " files processed"));
        }
    }
}