package com.example.davidguajardoosorio.marveljava.model;

/**
 * Created by davidguajardoosorio on 25-06-17.
 */

public class Thumbnail {
    private String path;
    private String extension;

    public String getPath() {
        return path + "." + getExtension();
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
