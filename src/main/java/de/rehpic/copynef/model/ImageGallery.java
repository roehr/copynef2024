package de.rehpic.copynef.model;

import javafx.scene.image.Image;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageGallery {
    // TODO: List of Files? List of Images?
    public static List<Image> getImages() {
        List<Image> images = new ArrayList<>();
        File folder = Settings.getJpgFolder();
       if(folder != null && folder.isDirectory()) {
           for (File file : folder.listFiles()) {
               if(file.getName().toLowerCase().endsWith(".jpg")) {
                   Image image = new Image(file.toURI().toString());
                   images.add(image);
               }
           }
       }
        return images;
    }
}
