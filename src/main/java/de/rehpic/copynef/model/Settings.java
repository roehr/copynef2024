package de.rehpic.copynef.model;

import java.io.File;

public class Settings {
    private static File rawFolder;
    private static File jpgFolder;
    private static RawType rawType;
   // private static

    public static File getRawFolder() {
        return rawFolder;
    }

    public static void setRawFolder(File rawFolder) {
        Settings.rawFolder = rawFolder;
    }

    public static File getJpgFolder() {
        return jpgFolder;
    }

    public static void setJpgFolder(File jpgFolder) {
        Settings.jpgFolder = jpgFolder;
    }

    public static RawType getRawType() {
        return rawType;
    }

    public static void setRawType(RawType rawType) {
        Settings.rawType = rawType;
    }
}
