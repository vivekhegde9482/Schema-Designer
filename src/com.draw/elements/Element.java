package com.draw.elements;

public interface Element {
    String getID();
    String getParent();
    void setParent(String parent);
    int getWidth();
    void setWidth(int width);

    int getHeight();
    void setHeight();
    void setX(int x);
    int getX();
    int getY();
    void setY(int y);

}
