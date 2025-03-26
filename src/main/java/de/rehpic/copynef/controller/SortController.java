package de.rehpic.copynef.controller;

import de.rehpic.copynef.model.ImageGallery;
import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


public class SortController {
    @FXML
    private ImageView imgView;
    @FXML
    private Label error;
    @FXML
    private AnchorPane sort;

    private int activeIndex;
    private int totalImages;


    @FXML
    protected void initialize(){
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
    }
}
