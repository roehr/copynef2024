module de.rehpic.copynef {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.commons.io;
    requires java.desktop;


    opens de.rehpic.copynef to javafx.fxml;
    exports de.rehpic.copynef;
    exports de.rehpic.copynef.controller;
    exports de.rehpic.copynef.model;
    opens de.rehpic.copynef.controller to javafx.fxml;
}