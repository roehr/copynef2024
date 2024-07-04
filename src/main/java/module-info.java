module de.rehpic.copynef24 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.commons.io;


    opens de.rehpic.copynef24 to javafx.fxml;
    exports de.rehpic.copynef24;
}