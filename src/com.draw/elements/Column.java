package com.draw.elements;

import java.util.concurrent.ThreadLocalRandom;

public class Column implements Element{
    private String id;
    private int width=100;
    private int height=20;
    private String parent;
    public static final int MAX_WIDTH = 140;

    public static final int MIN_WIDTH = 100;
    private String value;

    private int x=0;

    public Column(String value){
        setValue(value);
        setId("Column:"+value+"_"+ ThreadLocalRandom.current().nextInt());
    }

    @Override
    public String getID() {
        return this.id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight() {

    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        int width = value.length() * 8;
        if(width > MAX_WIDTH){
            width = MAX_WIDTH;
            this.height = this.height + 20;
        }

        this.width = Math.max(this.width,width);

        this.value = value;
    }

    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setY(int y) {
    }

    public void setX(int x) {
        this.x = x;
    }
}
