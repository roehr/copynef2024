package de.rehpic.copynef.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.rehpic.copynef.ViewHandler;
import de.rehpic.copynef.model.ImageGallery;
import de.rehpic.copynef.model.ImageRanking;
import de.rehpic.copynef.model.RankedImage;
import de.rehpic.copynef.model.Settings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SortController {
    @FXML
    private ImageView imgView;
    @FXML
    private Label error;
    @FXML
    private GridPane sort;

    private int activeIndex;
    private int totalImages;

    @FXML
    public void initialize() {
       ViewHandler.getScene().addEventHandler(KeyEvent.KEY_PRESSED, this::handleInput);
        totalImages = ImageGallery.getImages().size();
        if (totalImages==0) {
            error.setVisible(true);
            imgView.setVisible(false);
            return;
        }

        imgView.setVisible(true);
        activeIndex = 0;
        imgView.setImage(new Image(ImageGallery.getImages().get(activeIndex).getFilePath()));
        imgView.fitWidthProperty().bind(sort.widthProperty());
        imgView.fitHeightProperty().bind(sort.heightProperty());
    }

    private void handleInput(KeyEvent event) {
        if(event.getCode()== KeyCode.LEFT){
            if(activeIndex<=totalImages-1 && activeIndex>0){
                activeIndex--;
                imgView.setImage(new Image(ImageGallery.getImages().get(activeIndex).getFilePath()));
                imgView.fitWidthProperty().bind(sort.widthProperty());
                imgView.fitHeightProperty().bind(sort.heightProperty());
            }
        }
        if(event.getCode()== KeyCode.RIGHT){
            if(activeIndex<totalImages-1){
                activeIndex++;
                imgView.setImage(new Image(ImageGallery.getImages().get(activeIndex).getFilePath()));
                imgView.fitWidthProperty().bind(sort.widthProperty());
                imgView.fitHeightProperty().bind(sort.heightProperty());
            }
        }
        if(event.getCode()== KeyCode.D){
            updateRankings(ImageRanking.DELETE);
        }
        if(event.getCode()== KeyCode.N){
            updateRankings(ImageRanking.NONE);
        }
        if(event.getCode()== KeyCode.DIGIT1){
            updateRankings(ImageRanking.RANK_1);
        }
        if(event.getCode()== KeyCode.DIGIT2){
            updateRankings(ImageRanking.RANK_2);
        }
        if(event.getCode()== KeyCode.DIGIT3){
            updateRankings(ImageRanking.RANK_3);
        }
        if(event.getCode()== KeyCode.DIGIT4){
            updateRankings(ImageRanking.RANK_4);
        }
        if(event.getCode()== KeyCode.DIGIT5){
            updateRankings(ImageRanking.RANK_5);
        }

    }

    private void updateRankings(ImageRanking ranking) {
        try {

            RankedImage img = ImageGallery.getImages().get(activeIndex);
            img.setRanking(ranking);
            String jsonData = Settings.getJpgFolder() + "\\" + FilenameUtils.getBaseName(img.getFilePath())+".json";
            File jsonFile = new File(jsonData);
            ObjectMapper mapper = new ObjectMapper();
            String jsonStr = mapper.writeValueAsString(img);
            FileWriter myWriter = new FileWriter(jsonFile);
            myWriter.write(jsonStr);
            myWriter.flush();
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
