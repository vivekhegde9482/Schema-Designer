package com.draw.elements;

import java.util.ArrayList;
import java.util.List;

public class Table implements Element{
    private String name;
    private String id;
    private String parent;
    private int width;
    private int height = 30;
    private int x=0;
    private int y=0;
    private List<Row> rows = new ArrayList<>();
    private List<ForeignKey> foreignKeys = new ArrayList<>();

    public Table(String name){
        this.name = name;
        this.width = this.name.length() * 8;
        id = "table:"+name;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void addRow(Row row){
        row.setParent(id);
        row.setY(this.height);
        this.rows.add(row);
        this.width = Math.max(this.width,row.getWidth());
        this.height = this.height + row.getHeight();
    }

    public void addForeignKey(ForeignKey key){
        foreignKeys.add(key);
    }


    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
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

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public String getParent() {
        return this.parent;
    }

    @Override
    public void setParent(String parent) {
        this.parent = parent;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getRowIDOfColumn(String colName){
        for (Row row: rows) {
            for (Column col: row.getColumns()) {
                if(col.getValue().equals(colName)){
                    return row.getId();
                }
            }
        }
        return null;
    }

    public List<ForeignKey> getForeignKeys(){
        return this.foreignKeys;
    }
    /*
        1. column width should be same as its upper column
        2. Add new Column if a row is missing a column
     */
    public void fixColumnDifferences(){
        for(int r=0;r<rows.size();r++){

        }
    }

}
