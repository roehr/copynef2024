package de.rehpic.copynef.controller;

import de.rehpic.copynef.ViewHandler;
import de.rehpic.copynef.model.ImageGallery;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

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
    public void initialize(){
       ViewHandler.getScene().addEventHandler(KeyEvent.KEY_PRESSED, this::handleInput);
        totalImages = ImageGallery.getImages().size();
        if (totalImages==0) {
            error.setVisible(true);
            imgView.setVisible(false);
            return;
        }

        imgView.setVisible(true);
        activeIndex = 0;
        imgView.setImage(ImageGallery.getImages().get(activeIndex));
        imgView.fitWidthProperty().bind(sort.widthProperty());
        imgView.fitHeightProperty().bind(sort.heightProperty());
    }

    private void handleInput(KeyEvent event) {
        if(event.getCode()== KeyCode.LEFT){
            if(activeIndex<=totalImages-1 && activeIndex>0){
                activeIndex--;
                imgView.setImage(ImageGallery.getImages().get(activeIndex));
                imgView.fitWidthProperty().bind(sort.widthProperty());
                imgView.fitHeightProperty().bind(sort.heightProperty());
            }
        }
        if(event.getCode()== KeyCode.RIGHT){
            if(activeIndex<totalImages-1){
                activeIndex++;
                imgView.setImage(ImageGallery.getImages().get(activeIndex));
                imgView.fitWidthProperty().bind(sort.widthProperty());
                imgView.fitHeightProperty().bind(sort.heightProperty());
            }
        }
    }
}
