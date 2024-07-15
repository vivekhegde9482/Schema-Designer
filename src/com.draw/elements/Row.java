package com.draw.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Row implements Element{
    private String id;
    private int width=0;
    private int height=20;
    private String parent;
    private String name;

    private int colCount=0;

    private int y;

    private List<Column> columns = new ArrayList<>();

    public Row(String name){
        this.name=name;
        setId("Row:"+name+"_"+ ThreadLocalRandom.current().nextInt());
    }
    public void addColumn(Column column){
        column.setParent(this.id);
        column.setX(this.width);
        this.height = Math.max(this.height,column.getHeight());
        this.width = this.width + column.getWidth();
        columns.add(column);
        colCount++;
    }
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight() {

    }

    @Override
    public void setX(int x) {

    }

    @Override
    public int getX() {
        return 0;
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

    public List<Column> getColumns(){
        return this.columns;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getColCount() {
        return colCount;
    }

    public void setColCount(int colCount) {
        this.colCount = colCount;
    }
}
