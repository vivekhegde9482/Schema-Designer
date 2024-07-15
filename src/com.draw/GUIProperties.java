package com.draw;

import java.io.File;

public class GUIProperties {
    private boolean isAddArrow = false;
    private File[] selectedFiles;

    public boolean isAddArrow() {
        return isAddArrow;
    }

    public void setAddArrow(boolean addArrow) {
        isAddArrow = addArrow;
    }

    public File[] getSelectedFiles() {
        return selectedFiles;
    }

    public void setSelectedFiles(File[] selectedFiles) {
        this.selectedFiles = selectedFiles;
    }
}
