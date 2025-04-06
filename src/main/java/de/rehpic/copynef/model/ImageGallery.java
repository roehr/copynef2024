package de.rehpic.copynef.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class ImageGallery {
    // TODO: List of Files? List of Images?
    public static List<RankedImage> getImages() {
        List<RankedImage> images = new ArrayList<>();
        File folder = Settings.getJpgFolder();
       if(folder != null && folder.isDirectory()) {
           for (File file : folder.listFiles()) {
               if(file.getName().toLowerCase().endsWith(".jpg")) {
                   RankedImage img = new RankedImage(file.toURI().toString(), ImageRanking.NONE);
                   images.add(img);
                   String jsonData = file.getName().toLowerCase().replace("jpg", "json");
                   File jsonFile = new File(Settings.getJpgFolder(), jsonData);
                   try{
                       if(jsonFile.createNewFile()){
                           ObjectMapper mapper = new ObjectMapper();
                           String jsonStr = mapper.writeValueAsString(img);
                           FileWriter myWriter = new FileWriter(jsonFile);
                           myWriter.write(jsonStr);
                           myWriter.close();
                       }
                   }
                   catch(IOException e){
                       e.printStackTrace();
                   }
               }
           }
       }
        return images;
    }
}
