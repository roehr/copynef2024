package de.rehpic.copynef.model;

public class RankedImage {
    private String filePath;
    private ImageRanking ranking;

    public RankedImage(String filePath, ImageRanking ranking) {
        this.filePath = filePath;
        this.ranking = ranking;
    }
    public String getFilePath() {
        return filePath;
    }
    public ImageRanking getRanking() {
        return ranking;
    }
    public void setRanking(ImageRanking ranking) {
        this.ranking = ranking;
    }
}
