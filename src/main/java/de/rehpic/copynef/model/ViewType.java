package de.rehpic.copynef.model;

public enum ViewType {
    START("start.fxml"),
    SELECT("select.fxml"),
    COPY("copy.fxml"),
    SORT("sort.fxml"),
    SETTINGS("settings.fxml"),
    HELLO("hello-view.fxml");
    private String fxml;

    private ViewType(String fxml) {
        this.fxml = fxml;
    }
    public String getFxml() {
        return "views/" + fxml;
    }
}
